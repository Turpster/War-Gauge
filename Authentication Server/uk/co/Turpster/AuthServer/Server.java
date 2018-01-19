package uk.co.Turpster.AuthServer;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import uk.co.Turpster.AuthServer.connection.ConnectionHandler;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Server
{
	private static Logger logger;
	private DatabaseHandler dbHandler;
	private ConnectionHandler connectionHandler;
	
	private String
	username,
	password;

	public static void main(String[] args)
    {
        new Server();
    }
	
	public Server()
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
		
		connectionHandler = new ConnectionHandler(dbHandler, connectionHandlerPort);
		connectionHandler.start();
		
		try 
		{
			this.connect();
		}
		catch (SQLException e) 
		{
			logger.log(Logger.ERROR, "An error has been occured while connecting to the database.");
//			getLogger().log(Logger.SEVERE, "No longer accepting valid sessions until database is connected.");
//			connectionHandler.accept = false;
//			e.printStackTrace();
		}
	}
	
	public void connect() throws SQLException
	{
		dbHandler.connect("name");
	}

	public static String md5Enc(String target)
	{
		Mac sha256_HMAC = null;
		try
		{
			sha256_HMAC = Mac.getInstance("HmacSHA256");
			SecretKeySpec secretKey = new SecretKeySpec("1234".getBytes(), "HmacSHA256");
			sha256_HMAC.init(secretKey);
		} catch (InvalidKeyException e)
		{
			e.printStackTrace();
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		byte[] hash = sha256_HMAC.doFinal(target.getBytes());
		String check = HexBin.encode(hash);
		return new String(check);
	}

	public static Logger getLogger()
	{
		return logger;
	}
}
