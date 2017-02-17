
public class InvalidCommandException extends Exception 
{
	public InvalidCommandException(String command)
	{
		super("'"+command+"'"+" is not a valid command."+"\n"+"\n"+">");
	}
	
	public InvalidCommandException()
	{
		super("Incorrect number of arguments supplied to command."+"\n"+"\n"+">");
	}
	
}
