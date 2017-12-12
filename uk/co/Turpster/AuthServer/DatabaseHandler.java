package uk.co.Turpster.AuthServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler 
{
	Connection connection;
	
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
	
	public void connect(String databasename) throws SQLException
	{
		connection = DriverManager.getConnection("jdbc:mysql://" + serverAddress + ":" + port + "/" + databasename, username, password);
	}
	
	
}
