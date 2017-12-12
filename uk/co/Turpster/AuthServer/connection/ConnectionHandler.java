package uk.co.Turpster.AuthServer.connection;

import java.io.IOException;
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
		
		this.start();
	}
	
	public synchronized void start()
	{
		thread = new Thread(this);
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
				System.out.println("Waiting for connection...");
				Socket connection = serversocket.accept();
				
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
}
