package uk.co.Turpster.AuthServer.connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

import uk.co.Turpster.AuthServer.Logger;
import uk.co.Turpster.AuthServer.Main;

public class ConnectionHandler implements Runnable
{
	private Thread thread;
	
	public boolean accept = true;
	
	private ServerSocket serversocket;
	private boolean running = false;
	
	public ConnectionHandler(int port)
	{
		try 
		{
			serversocket = new ServerSocket(port);
		}
		catch (BindException e)
		{
			Main.getLogger().log(Logger.SEVERE, "CONNECTION IS ALREADY BINDED: PREHAPS THE SERVER IS ALREADY RUNNING?");
			Main.getLogger().log(Logger.INFO, "Exiting program.");
			System.exit(-1);
		}
		catch (IOException e) 
		{
			Main.getLogger().log(Logger.WARNING, "Error occured when trying to create the server socket.");
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
			Main.getLogger().log(Logger.WARNING, "Error occured when trying to join connection thread");
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
				Main.getLogger().log(Logger.FINE, "Waiting for user...");
				Socket connection = serversocket.accept();
				Main.getLogger().log(Logger.FINE, "Connection recieved from connector: " + connection.getRemoteSocketAddress().toString() + ".");
				
				OutputStream output = this.getObjectOutputStream(connection);
				InputStream input = this.getObjectInputStream(connection);
				
				if (accept)
				{
					/*
					 * VALIDATE USER DETAILS AND SEND IF USER DATA IS OKAY OR NOT.
					 */
				}
				
				System.out.println("Connected!");
				connection.close();
			}
			catch (IOException e)
			{
				Main.getLogger().log(Logger.ERROR, "There has been an error trying to establish a connection with a connector.");
				e.printStackTrace();
			}
		}
	}	
	
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
			Main.getLogger().log(Logger.ERROR, "There has been an error setting up streams with the connection.");
			e.printStackTrace();
		}
		
		return output;
	}
	
	private InputStream getObjectInputStream(Socket connection)
	{
		InputStream input = null;
		try 
		{
			input = connection.getInputStream();
		}
		catch (IOException e) 
		{
			Main.getLogger().log(Logger.ERROR, "There has been an error setting up streams with the connection.");
			e.printStackTrace();
		}
		
		return input;
	}
}
