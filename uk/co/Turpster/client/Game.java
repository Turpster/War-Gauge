package uk.co.Turpster.client;

public class Game 
{
	private Session session;
	public ConnectionManager connectionMang;
	
	public Game(String[] args)
	{
		String username = null;
		String password = null;
		
		for (int i = 0; i >= args.length; i++)
		{
			if (args[i].equalsIgnoreCase("-username"))
			{
				username = args[i + 1];
			}
			if (args[i].equalsIgnoreCase("-password"))
			{
				password = args[i + 1];
			}
		}
		
		if (username == null || password == null)
		{
			System.exit(1);
		}
		
		connectionMang = new ConnectionManager();
		
		session = new Session(connectionMang, username, password);
	}
	
	public static void main(String[] args)
	{
		new Game(args);
	}
}

