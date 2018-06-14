package uk.co.Turpster.AuthServer.connection;

import java.io.*;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Random;

import packet.Packet;
import packet.PacketLogin;
import packet.PacketLoginValidate;
import uk.co.Turpster.AuthServer.Server;
import uk.co.Turpster.AuthServer.DatabaseHandler;
import uk.co.Turpster.AuthServer.Logger;

public class ConnectionHandler implements Runnable
{
	private Thread thread;
	
	public boolean accept = true;
	
	private ServerSocket serversocket;
	private boolean running = false;

	private DatabaseHandler databaseHandler;

	//Session ID - Username
	HashMap<Integer, String> sessions = new HashMap<Integer, String>();

	public ConnectionHandler(DatabaseHandler databaseHandler, int port)
	{
		this.databaseHandler = databaseHandler;

		try 
		{
			serversocket = new ServerSocket(port);
		}
		catch (BindException e)
		{
			Server.getLogger().log(Logger.SEVERE, "CONNECTION IS ALREADY BINDED: PREHAPS THE SERVER IS ALREADY RUNNING?");
			Server.getLogger().log(Logger.INFO, "Exiting program.");
			System.exit(-1);
		}
		catch (IOException e) 
		{
			Server.getLogger().log(Logger.WARNING, "Error occured when trying to create the server socket.");
			e.printStackTrace();
		}
	}
	
	public synchronized void start()
	{
		thread = new Thread(this, "Connection-Handler");
		thread.start();
		
		running = true;
	}
	
	public synchronized void stop()
	{
		try 
		{
			thread.join();
		}
		catch (InterruptedException e) 
		{
			Server.getLogger().log(Logger.WARNING, "Error occured when trying to join connection thread");
			stop();
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() 
	{
		while (running)
		{
			try 
			{
				Server.getLogger().log(Logger.FINE, "Waiting for user...");
				Socket connection = serversocket.accept();
				Server.getLogger().log(Logger.FINE, "Connection recieved from connector: " + connection.getRemoteSocketAddress().toString() + ".");
				
				ObjectOutputStream output = new ObjectOutputStream(connection.getOutputStream());
				output.flush();
				ObjectInputStream input = new ObjectInputStream(connection.getInputStream());
				
				if (accept)
				{
					try
					{
						Packet packet = (Packet) input.readObject();
						if (packet instanceof PacketLogin)
						{
							PacketLogin loginPacket = (PacketLogin) packet;
							boolean valid = databaseHandler.isLoginValid(loginPacket.getUsername(), loginPacket.getPassword(), true);

							if (valid)
							{
								Random random = new Random();

								int id = random.nextInt(Integer.MAX_VALUE);

								Server.getLogger().log(Logger.FINE, "ID: " + id);

								sessions.put(id , loginPacket.getUsername());
								output.writeObject(new PacketLoginValidate(id));
								output.flush();

								connection.close();
							}
							else
							{
								output.writeObject(new PacketLoginValidate(1));
							}
						}
						else
						{
							Server.getLogger().log(Logger.WARNING, "Connector sent a different type of packet: " + connection.getRemoteSocketAddress().toString() + ".");
						}
					}
					catch (ClassNotFoundException e)
					{
						e.printStackTrace();
					}
					catch (ClassCastException e)
					{
						Server.getLogger().log(Logger.WARNING, "Connector sent suspicious data: " + connection.getRemoteSocketAddress().toString() + ".");
					}
				}
				else
				{
					output.writeObject(new PacketLoginValidate(1));
				}
				
				System.out.println("Connected!");
				connection.close();
			}
			catch (IOException e)
			{
				Server.getLogger().log(Logger.ERROR, "There has been an error trying to establish a connection with a connector.");
				e.printStackTrace();
			}
		}
	}	
	
	@SuppressWarnings("unused")
	private OutputStream getObjectOutputStream(Socket connection)
	{
		OutputStream output = null;
		try 
		{
			output = connection.getOutputStream();
			output.flush();
		}
		catch (IOException e) 
		{
			Server.getLogger().log(Logger.ERROR, "There has been an error setting up streams with the connection.");
			e.printStackTrace();
		}
		
		return output;
	}
	
	@SuppressWarnings("unused")
	private InputStream getObjectInputStream(Socket connection)
	{
		InputStream input = null;
		try 
		{
			input = connection.getInputStream();
		}
		catch (IOException e) 
		{
			Server.getLogger().log(Logger.ERROR, "There has been an error setting up streams with the connection.");
			e.printStackTrace();
		}
		
		return input;
	}
}
