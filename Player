import java.io.Serializable;

public abstract class Player implements Serializable
{
	
		private static final long serialVersionUID = 1L;
		
		private String userName;
		private String familyName;
		private String givenName;
		private int gamesPlayed;
		private int gamesWon;
		private int gamesDrawn;
		private double drawRatio;
		private double winRatio;
		
		public Player()
		{
			userName="";
			familyName="";
			givenName="";
			gamesPlayed=0;
			gamesWon=0;
			gamesDrawn=0;
			drawRatio=0.0;
			winRatio=0.0;
		}
		
		abstract Move makeMove(int[][] gameBoard);
		
		public Player(String userName)
		{
				this.userName=userName;
				familyName="";
				givenName="";
				gamesPlayed=0;
				gamesWon=0;
				gamesDrawn=0;
				drawRatio=0.0;
				winRatio=0.0;
				
		}
		
		public Player(String userName, String familyName, String givenName)
		{
				this.userName=userName;
				this.familyName=familyName;
				this.givenName=givenName;
				gamesPlayed=0;
				gamesWon=0;
				gamesDrawn=0;
				drawRatio=0.0;
				winRatio=0.0;
		}
		
		public Player(Player aPlayer)
		{
				if (aPlayer==null)
				{
						System.exit(0);
				}
				userName=aPlayer.userName;
				familyName=aPlayer.familyName;
				givenName=aPlayer.givenName;
				gamesPlayed=aPlayer.gamesPlayed;
				gamesWon=aPlayer.gamesWon;
				gamesDrawn=aPlayer.gamesDrawn;
				drawRatio=aPlayer.getDrawRatio();
				winRatio= aPlayer.getWinRatio();
		}
		
		public void setUserName(String userName)
		{
				this.userName=userName;
		}
		
		public void setFamilyName(String familyName)
		{
				this.familyName=familyName;
		}
		
		public void setGivenName(String givenName)
		{
				this.givenName=givenName;
		}
		
		public void setGamesPlayed(int gamesPlayed)
		{
				this.gamesPlayed+=gamesPlayed;
		}
	
		public void setGamesWon(int gamesWon)
		{
				this.gamesWon+=gamesWon;
		}
		
		public void setGamesDrawn(int gamesDrawn)
		{
				this.gamesDrawn+=gamesDrawn;
		}
		public void setDrawRatio()
		{
			if (gamesPlayed == 0)
				drawRatio = 0;	
			else
				drawRatio = ((double)gamesDrawn/(double)gamesPlayed)*100;
		}
		public void setWinRatio()
		{
			if (gamesPlayed == 0)
				winRatio = 0;	
			else 
				winRatio = ((double)gamesWon/(double)gamesPlayed)*100;
		}
		public double getDrawRatio()
		{
			return drawRatio;
		}
		public double getWinRatio()
		{
			return winRatio;
		}
		public String getUserName()
		{
				return userName;
		}
		
		public String getFamilyName()
		{
				return familyName;
		}
		
		public String getGivenName()
		{
				return givenName;
		}
		
		public int getGamesPlayed()
		{
			return gamesPlayed;
		}
		
		public int getGamesWon()
		{
			return gamesWon;
		}
		
		public int getGamesDrawn()
		{
			return gamesDrawn;
		}
		
		public String toString()
		{
				return (userName + "," + familyName + "," + givenName + "," + 
						gamesPlayed +" games,"+gamesWon +" wins,"+gamesDrawn+" draws");
		}
		
		public boolean equals (Player otherPlayer)
		{
				if (otherPlayer==null)
					return false;
				else
					return(userName.equals(otherPlayer.userName) && familyName.equals(otherPlayer.familyName)
								&& givenName.equals(otherPlayer.givenName));
		}
		
		public void setStatsToZero()
		{
			this.gamesPlayed = 0;
			this.gamesDrawn = 0;
			this.gamesWon = 0;
		}
}
