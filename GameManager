
public class GameManager {

	private int grid[][];
	private  Player [] currentPlayer;
	private boolean playOn;
	private int playTurn;
	private boolean s1;
	private boolean s2;
	private static final int ROWS = 3;
	private static final int COLS = 3;
	private static final int EMPTY = 0;
	private static final int NOUGHT = 1;
	private static final int CROSS = 2;
	private static final int CURRENT_PLAYER_1 = 1;
	private static final int CURRENT_PLAYER_2 = 2;
	private static final int NOUGHT_WON = 1;
	private static final int CROSS_WON = 2;
	private static final int DRAW = 3;
	
	// A method to set current players by taking 2 players called and 
	// an object of PlayerManager to compare if they exist in the array. 
	public void setCurrentPlayer(PlayerManager p, String p1, String p2)
	{	
		currentPlayer=new Player[2];
		s1=false;
		s2=false;
		for (int i=0; i<p.getNumOfPlayers();i++)
			if(p1.equals(p.getElement(i).getUserName()))
			{
				currentPlayer[0]=p.getElement(i);
				s1=true;
			}

		for (int j=0; j<p.getNumOfPlayers();j++)
			if(p2.equals(p.getElement(j).getUserName()))
			{
				currentPlayer[1]=p.getElement(j);
				s2=true;
			}
		if (s1==true && s2==true)
		{
			run();
			return;
		}
		System.out.println("Player does not exist.");
	}

	public void run()
	{
		newGrid();
		playOn=true;
		playTurn=1;
		while(playOn && playTurn<10)
		{
			if(playTurn%2==0)

			{
				askPlayer(CURRENT_PLAYER_2);
			}
			else
			{
				askPlayer(CURRENT_PLAYER_1);
			}
			playTurn++;
			printGrid();
			checkForWinning();
			if(playOn&&playTurn==10)
			{
				getGameState(DRAW);
			}
		}
	}
	// getter for instance variable currentPlayer
	public Player getCurrentPlayer(int index)
	{
		return currentPlayer[index];
	}

	// Print the board 
	public void newGrid()
	{
		grid = new int [ROWS][COLS];
		for(int row=0;row<grid.length;row++)
		{
			for(int col=0;col<grid[0].length;col++)
			{
				printCell(grid[row][col]);
				if (col==0||col==1)
					System.out.print("|");	
			}
			if(row==0||row==1)
				System.out.print("\n-----\n");
		}
	}

	public void printGrid()
	{
		for(int row=0;row<grid.length;row++)
		{
			for(int col=0;col<grid[0].length;col++)
			{
				printCell(grid[row][col]);
				if (col==0||col==1)
					System.out.print("|");	
			}
			if(row==0||row==1)
				System.out.print("\n-----\n");
		}
	}

	// Convert integer value of cells to char
	public void printCell(int cell)
	{
		switch(cell)
		{
		case EMPTY : System.out.print(' ');break;
		case NOUGHT: System.out.print('O');break;
		case CROSS : System.out.print('X');break;
		}
	}

	public void askPlayer(int player)
	{
		System.out.println();
		int row; 
		int col;
		do 
		{
			//player - 1 gives Player O if player = 1 and Player X if player = 2
			System.out.println(currentPlayer[player-1].getGivenName()+"'s move:");
			row = currentPlayer[player-1].makeMove(grid).getRow();
			col = currentPlayer[player-1].makeMove(grid).getCol();
		} while(notValid(row,col));
		playerMove(player,row,col);
		
	}
	// define notValid input of user 
	public boolean notValid (int row,int col)
	{
		if(row>2 || row<0 || col>2 || col<0)
		{
			System.out.println("Invalid move. You must place at a cell within {0,1,2} {0,1,2}.");
			return true;		
		}
		else if(!emptyCell(row,col))
		{
			System.out.println("Invalid move. The cell has been occupied.");
			return true;
		}
		else
			return false;
	}
	// Return true if cell is empty as zero
	public boolean emptyCell(int row,int col)
	{
		if(grid[row][col]==EMPTY)
			return true;
		else
			return false;
	}

	// Mark player's move (input) on the board
	public void playerMove(int player,int row, int col)
	{
		if(emptyCell(row,col) && row>=0 && row <=2 && col>=0 && col<=2)
			grid[row][col]=player;
		else
			grid[row][col]=EMPTY;
	}

	// Check for winning case
	public void checkForWinning()
	{
		// One player has 3 marks in a sequence horizontally
		for(int row=0;row<grid.length;row++)
			if(grid[row][0]==grid[row][1] && grid[row][1]==grid[row][2]
					&&!emptyCell(row,0))
			{
				playOn=false;
				getGameState(grid[row][0]);
				return;
			}
		// vertically 
		for(int col=0;col<grid[0].length;col++)
			if(grid[0][col]==grid[1][col] && grid[1][col]==grid[2][col]
					&&!emptyCell(0,col))
			{
				playOn=false;
				getGameState(grid[0][col]);
				return;
			}
		// Diagonally
		if(grid[0][0]==grid[1][1] && grid[1][1]==grid[2][2]
				&&!emptyCell(0,0))
		{
			playOn=false;
			getGameState(grid[0][0]);
		}
		// Anti-diagonally
		if(grid[2][0]==grid[1][1] && grid[1][1]==grid[0][2]
				&&!emptyCell(2,0))
		{
			playOn=false;
			getGameState(grid[2][0]);
		}
	}

	// Update game state and send it to the PlayerManager
	// by setting each player's game result
	public void getGameState(int gamestate)
	{
		if (gamestate==NOUGHT_WON)// When currentPlayer[0], wins the game
		{
			System.out.println();
			System.out.println("Game over. " + currentPlayer[0].getGivenName() +" won!" );
			currentPlayer[0].setGamesPlayed(1);
			currentPlayer[0].setGamesWon(1);
			currentPlayer[1].setGamesPlayed(1);
		}
		if (gamestate==CROSS_WON)// When Jack, currentPlayer[1], wins the game
		{
			System.out.println();
			System.out.println("Game over. " + currentPlayer[1].getGivenName()+" won!" );
			currentPlayer[1].setGamesPlayed(1);
			currentPlayer[0].setGamesPlayed(1);
			currentPlayer[1].setGamesWon(1);
		}
		if(gamestate==DRAW)// When there is a draw
		{
			System.out.println();
			System.out.println("Game over. It was a draw!");
			currentPlayer[0].setGamesPlayed(1);
			currentPlayer[1].setGamesPlayed(1);
			currentPlayer[0].setGamesDrawn(1);
			currentPlayer[1].setGamesDrawn(1);
		}
	}

}
