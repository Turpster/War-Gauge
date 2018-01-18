package uk.co.Turpster.connection;

public class ConnectionManager
{
	
	public ConnectionManager()
	{
		
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
		
		return 2;
	}
}
