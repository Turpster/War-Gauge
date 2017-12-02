package uk.co.Turpster.client;

public class Session
{
	int ID;
	
	boolean debugging = false;
	
	public String username;
	
	public Session(ConnectionManager connectionMang, String username, String password)
	{
		this.username = username;
		
		ID = connectionMang.getSessionID(username, password);
		
		if (ID == ConnectionManager.SESSION_DEBUGGING)
		{
			debugging = true;
		}
	}
	
	public boolean validate()
	{
		
		/*
		 * TODO
		 * Check if ID is not invalid from server side
		 */
		return false;
	}
}
