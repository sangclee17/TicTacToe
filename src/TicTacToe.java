/**
 * @author Scott Lee
 */

import java.util.Scanner;

public class TicTacToe 
{
	public static Scanner keyboard = new Scanner(System.in);
	private boolean gameOn = true;
	private static final String ADDPLAYER = "addplayer";
	private static final String ADDAIPLAYER = "addaiplayer";
	private static final String REMOVEPLAYER = "removeplayer";
	private static final String EDITPLAYER = "editplayer";
	private static final String RESETSTATS = "resetplayer";
	private static final String DISPLAYPLAYER = "displayplayer";
	private static final String RANKINGS = "rankings";
	private static final String PLAYGAME = "playgame";
	private static final String EXIT = "exit";
	private static final String EMPTY = "";
	private PlayerManager manager;
	private GameManager gameManager;
	private String [] str;
	private	String mode;
	private	String input;


	public void run()
	{
		manager = new PlayerManager();
		gameManager = new GameManager();

		System.out.println("Welcome to Tic Tac Toe!\n");
		System.out.print(">");

		manager.readFromFile();

		while(gameOn)
		{
			try
			{
				input = keyboard.nextLine();
				str=input.split(" ");
				mode=str[0]; 
				switch(mode)
				{
				case ADDPLAYER:
					try{
						String[]human=str[1].split(",");//addHumanPlayer
						if(human.length<3)
							throw new InvalidCommandException();
						Player human1 =new HumanPlayer(human[0],human[1],human[2]);//create an object of HumanPlayer
						manager.addPlayer(human1);	
						System.out.println("");
						System.out.print(">");
					}catch (InvalidCommandException e){
						System.out.print(e.getMessage());}
					break;
				case ADDAIPLAYER:
					try{
						String[]ai=str[1].split(",");//addAIPlayer
						if(ai.length<3)
							throw new InvalidCommandException();
						Player ai1 =new AiPlayer(ai[0],ai[1],ai[2]);//create an object of HumanPlayer
						manager.addPlayer(ai1);	
						System.out.println("");
						System.out.print(">");
					}catch (InvalidCommandException e){
						System.out.print(e.getMessage());}
					break;
				case PLAYGAME:
					try{
						String[] play=str[1].split(",");
						if(play.length<2)
							throw new InvalidCommandException();
						gameManager.setCurrentPlayer(manager, play[0], play[1]);
						System.out.println("");
						System.out.print(">");
					}catch (InvalidCommandException e){
						System.out.print(e.getMessage());}
					break;
				case DISPLAYPLAYER:
					if(input.contains(" "))
					{
						manager.displayPlayer(str[1]); 
						System.out.println("");
						System.out.print(">");
					}
					else
					{   
						manager.displayPlayer();
						System.out.println("");
						System.out.print(">");
					}
					break;
				case REMOVEPLAYER:
					if(input.contains(" "))
					{
						manager.removePlayer(str[1]);
						System.out.println("");
						System.out.print(">");
					}
					else
					{
						System.out.println("Are you sure you want to remove all players? (y/n)");
						String answer=keyboard.next();
						if(answer.equals("y"))
						{
							manager.removePlayer();
							System.out.println("");
							System.out.print(">");
							break;
						}
						if(answer.equals("n"))
						{
							System.out.println("");
							System.out.print(">");   
							break;
						}
					}
					break;
				case EDITPLAYER:
					try{
						String[] edit=str[1].split(",");
						if(edit.length<3)
							throw new InvalidCommandException();
						manager.editPlayer(edit[0],edit[1],edit[2]);
						System.out.println("");
						System.out.print(">");
					}catch (InvalidCommandException e){
						System.out.print(e.getMessage());}
					break;
				case RESETSTATS:
					if (input.contains(" "))
						manager.resetStats(str[1]);
					else
					{
						System.out.println("Are you sure you want to reset all player statistics? (y/n)");
						String answer=keyboard.next();
						if(answer.equals("y"))
						{
							manager.resetStats();
							System.out.println("");
							System.out.print(">");
							break;
						}
						if(answer.equals("n"))
							System.out.println("");
						System.out.print(">");
						break;
					}
					break;
				case RANKINGS:
					manager.rankings();
					manager.displayRankings();
					System.out.println("");
					System.out.print(">");
					break;
				case EXIT:
					System.out.print("\n");
					manager.writeToFile();
					System.exit(0);
					break;	
				case EMPTY:
					break;
				default:
					throw new InvalidCommandException(str[0]);
				}
			}catch(InvalidCommandException e){
				System.out.print(e.getMessage());}
		}
	}

	public static void main(String[] args) {
		TicTacToe gameSystem = new TicTacToe();
		gameSystem.run();
	}

}