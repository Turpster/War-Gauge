package uk.co.Turpster.client;

public class ConnectionManager
{
	
	public ConnectionManager()
	{
		
	}
	
	/* SPECIAL ID'S
	 * 1 - COULDN'T ESTABLISH CONNECTION - (INVALID LOGIN)
	 * 2 - SPECIAL DEBUGGING MODE
	 */
	
	protected static int SESSION_INVALID = 1;
	protected static int SESSION_DEBUGGING = 2;
	
	protected int getSessionID(String username, String password)
	{
		/*
		 * TODO
		 * VALIDATE AND ESTABLISH ID WITH SERVER.
		 */
		
		return 2;
	}
}
