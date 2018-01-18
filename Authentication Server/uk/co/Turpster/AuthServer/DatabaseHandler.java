package uk.co.Turpster.AuthServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler implements Runnable
{
	Connection connection;
	
	private Thread thread;
	private boolean running = false;
	
	private String
	serverAddress,
	port,
	username,
	password;
	
	public DatabaseHandler(String serverAddress, String username, String password) 
	{
		this.serverAddress = serverAddress;
		this.username = username;
		this.password = password;
		this.port = "3306";
	}
	
	public DatabaseHandler(String serverAddress, String port, String username, String password) 
	{
		this.serverAddress = serverAddress;
		this.username = username;
		this.password = password;
		this.port = port;
	}
	
	public synchronized void start()
	{
		thread = new Thread(this, "Database-Handler");
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
		
		}
	}
	
	public void connect(String databasename) throws SQLException
	{
		connection = DriverManager.getConnection("jdbc:mysql://" + serverAddress + ":" + port + "/" + databasename, username, password);
	}
	
	
}
