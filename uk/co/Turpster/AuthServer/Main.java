package uk.co.Turpster.AuthServer;

import java.sql.SQLException;

import uk.co.Turpster.AuthServer.connection.ConnectionHandler;

public class Main
{
	private static Logger logger;
	private DatabaseHandler dbHandler;
	private ConnectionHandler connectionHandler;
	
	private String
	username,
	password;
	
	public static void main(String[] args)
	{
		new Main();
	}
	
	public Main()
	{
		logger = new Logger();
		
//		username = JOptionPane.showInputDialog("Please enter the appropriate database username");
//		password = JOptionPane.showInputDialog("Please enter the appropriate database password");
		username = "username";
		password = "password";
		
		this.dbHandler = new DatabaseHandler("localhost", username, password);
		
		this.dbHandler.start();
		
		logger.log(Logger.INFO, "Starting War-Gauge Authentication server.");
		
		int connectionHandlerPort = 21010;
		
		connectionHandler = new ConnectionHandler(connectionHandlerPort);
		connectionHandler.start();
		
		try 
		{
			this.connect();
		}
		catch (SQLException e) 
		{
			logger.log(Logger.ERROR, "An error has been occured while connecting to the database.");
			getLogger().log(Logger.SEVERE, "No longer accepting valid sessions until database is connected.");
			connectionHandler.accept = false;
//			e.printStackTrace();
		}
	}
	
	public void connect() throws SQLException
	{
		dbHandler.connect("name");
	}
	
	public static Logger getLogger()
	{
		return logger;
	}
}
