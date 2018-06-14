package uk.co.Turpster.connection;

import packet.PacketLogin;
import packet.PacketLoginValidate;
import packet.Packet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectionManager
{
	String inetAddress;
	int port;

	public ConnectionManager(String inetAddress)
	{
		this.inetAddress = inetAddress;
		this.port = 21010;
	}
	
	/* SPECIAL ID'S
	 * 1 - COULDN'T ESTABLISH CONNECTION - (INVALID LOGIN)
	 * 2 - SPECIAL DEBUGGING MODE
	 */
	
	public static int SESSION_INVALID = 1;
	public static int SESSION_DEBUGGING = 2;
	
	public int getSessionID(String username, String password)
	{
		/*
		 * TODO
		 * VALIDATE AND ESTABLISH ID WITH SERVER.
		 */

		try
		{
			System.out.println("Before");
			@SuppressWarnings("resource")
			Socket connection = new Socket(inetAddress, port);
			System.out.println("After");

			ObjectInputStream input = new ObjectInputStream(connection.getInputStream());
			ObjectOutputStream output = new ObjectOutputStream(connection.getOutputStream());
			output.flush();

			output.writeObject(new PacketLogin(username, password));
			output.flush();

			Object packetResponse = null;
			try {
				packetResponse = input.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			try {
				if ((Packet) packetResponse instanceof PacketLoginValidate) {
						System.out.println(((PacketLoginValidate) packetResponse).getSessionID() + "");
						return ((PacketLoginValidate) packetResponse).getSessionID();
				} else {
					return 1;
				}
			} catch (ClassCastException e) {
				return 1;
			}
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
			return 1;
		}
	}
}
