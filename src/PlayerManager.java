import java.io.*;

public class PlayerManager 
{
	private int maxNumOfPlayers=100;
	private Player [] playerList = new Player [maxNumOfPlayers];
	private int numOfPlayers=0;

	// A method to add player
	// increase the number of players each time when a player are added 
	public void addPlayer(Player p)
	{	
		for(int i=0; i<numOfPlayers;i++){
			if(playerList[i].getUserName().equals(p.getUserName())){
				System.out.println("The username has been used already.");
				return;
			}
		}
		playerList[numOfPlayers]=p;
		numOfPlayers++;
	}
	// A method to remove a player
	public void removePlayer(String p)
	{ 	int i;
	for(i=0; i<numOfPlayers;i++)
	{
		if(p.equals(playerList[i].getUserName()))
		{
			for(int j=i; j < numOfPlayers-1; j++)
				playerList[j]=playerList[j+1];

			numOfPlayers--;
			return;
		}
	}

	System.out.println("The player does not exist.");
	}
	// Method to remove all the players listed
	public void removePlayer()
	{
		for(int i=0;i<numOfPlayers;i++)
		{
			playerList[i]=playerList[numOfPlayers];
		}
		numOfPlayers=0;
	}
	// Method to edit a player
	public void editPlayer(String userName, String familyName, String givenName)
	{
		for(int i=0; i<numOfPlayers;i++)
			if(userName.equals(playerList[i].getUserName()))
			{
				playerList[i].setUserName(userName);
				playerList[i].setFamilyName(familyName);
				playerList[i].setGivenName(givenName);
				return;
			}	
		System.out.println("The player does not exist.");
	}
	// A method to reset one specific player
	public void resetStats(String p)
	{
		for(int i=0; i<numOfPlayers;i++)
			if (p.equals(playerList[i].getUserName()))
			{
				playerList[i].setStatsToZero();
				return;
			}
		System.out.println("The player does not exist.");
	}	
	// A method to reset all the players listed
	public void resetStats()
	{
		for (int i=0;i<numOfPlayers;i++)
		{
			playerList[i].setStatsToZero();
		}
	}
	// A method to display one specific player
	public void displayPlayer(String p)
	{

		for(int i=0;i<numOfPlayers;i++)

			if(p.equals(playerList[i].getUserName()))
			{
				System.out.println(playerList[i]);
				return;
			}
		System.out.println("The player does not exist.");		    		
	}
	// Method to display all the player listed 
	public void displayPlayer()
	{
		for(int i=0;i<numOfPlayers-1;i++)
		{
			int minIndex=i;
			for(int j=i+1; j<numOfPlayers;j++){
				if(playerList[j].getUserName().compareTo(playerList[minIndex].getUserName())<0)
				{
					minIndex=j;
				}
			}
			Player temp=playerList[minIndex];
			playerList[minIndex]=playerList[i];
			playerList[i]=temp;
		}
		for(int index=0;index<numOfPlayers;index++)
		{	
			System.out.println(playerList[index]);	
		}
	}
	// Ranks the player using selection sort
	public void rankings()
	{
		for(int index=0;index<numOfPlayers;index++)
		{
			playerList[index].setDrawRatio();
			playerList[index].setWinRatio();
		}

		for(int i=0;i<numOfPlayers-1;i++){
			int maxIndex=i;		
			for(int j=i+1;j<numOfPlayers;j++){                  //determine by winRatio			
				if (playerList[j].getWinRatio() > playerList[maxIndex].getWinRatio()){
					maxIndex=j;
				}                   //if tie presents on winRatio, determine by drawRatio
				else if (playerList[j].getWinRatio() == playerList[maxIndex].getWinRatio()
						&& playerList[j].getDrawRatio() > playerList[maxIndex].getDrawRatio()){
					maxIndex=j;
				}              //if tie presents on both drawRatio and winRatio, sort alphabetically 
				if(playerList[j].getDrawRatio() == playerList[maxIndex].getDrawRatio()
						&& playerList[j].getWinRatio() == playerList[maxIndex].getWinRatio()){
					if (playerList[j].getUserName().compareTo(playerList[maxIndex].getUserName())<0){
						maxIndex=j;
					}	
				}
			}
			Player temp = playerList[maxIndex];
			playerList[maxIndex]=playerList[i];
			playerList[i]=temp;
		}
	}
	//Print out rankings
	public void displayRankings()
	{
		System.out.println(" WIN  | DRAW | GAME | USERNAME");
		for(int i=0;i<numOfPlayers;i++)
		{
			String winLine = String.format("%1$4d",Math.round(playerList[i].getWinRatio()));
			String drawLine = String.format("%1$4d", Math.round(playerList[i].getDrawRatio()));
			String gameLine = String.format("%1$3d", playerList[i].getGamesPlayed());
			System.out.println(winLine + "% |"+ drawLine +"% |"
					+gameLine+"   |"+" "+playerList[i].getUserName());
		}
	}
	// getter for number of players
	public int getNumOfPlayers()
	{
		return numOfPlayers;
	}
	// definition of when the array is full
	public boolean isFull()
	{
		return(numOfPlayers==maxNumOfPlayers);
	}
	// definition of when the array is empty
	public boolean empty()
	{
		return(numOfPlayers==0);
	}
	// Getter for the playerList array
	public Player getElement(int index)
	{
		return playerList[index];
	}
	// Write the array of playerList and numOfPlayers to the file "Players.dat"
	public void writeToFile()
	{
		try
		{
			ObjectOutputStream fileout = new ObjectOutputStream(new FileOutputStream("Players.dat"));
			fileout.writeObject(playerList);
//			for(int i=0; i<100;i++)
//			{
//				fileout.writeObject(playerList[i]);
//			}
			fileout.writeObject(numOfPlayers);
			fileout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("Error !");
			System.exit(0);
		}
	}
	// Read playerList and numOfPlayers from the file "Players.dat"
	public void readFromFile()
	{
		try
		{
			ObjectInputStream filein = new ObjectInputStream(new FileInputStream("Players.dat"));
			playerList = (Player[]) filein.readObject();
//			for(int i=0; i<100;i++){
//			playerList[i] = (Player)filein.readObject();
//			}
			numOfPlayers = (int) filein.readObject();
			filein.close();
		}
		catch(FileNotFoundException e)
		{
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("Error !");
			System.exit(0);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("Error !");
			System.exit(0);
		}

	}
}