package uk.co.Turpster.AuthServer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger 
{	
	public static int 
	INFO = 0,
	FINE = 1,
	ERROR = 2,
	WARNING = 3,
	SEVERE = 4;
	
	public void log(int logseverity, String message)
	{
		String severityMessage = null;
		
		switch(logseverity)
		{
		case 0:
			severityMessage = "INFO";
			break;
		case 1:
			severityMessage = "FINE";
			break;
		case 2:
			severityMessage = "ERROR";
			break;
		case 3:
			severityMessage = "WARNING";
			break;
		case 4:
			severityMessage = "SEVERE";
			break;
		default:
			return;
		}
		
		String prefix = "~ [" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] ";
		
		String finalMessage = prefix + severityMessage + ": " + message;
		
		System.out.println(finalMessage);
	}
}
