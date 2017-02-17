
import java.io.Serializable;

public class AiPlayer extends Player implements Serializable
{
	private static final long serialVersionUID = 1L;

	// AiPlayer constructor referring to parent class
	public AiPlayer(String userName, String familyName, String givenName)
	{
		super(userName,familyName,givenName);
	}

	// MakeMove method overridden when an object of AiPlayer has been called
	public Move makeMove(int[][] gameBoard)
	{
		for(int row=0; row<gameBoard.length;row++){
			for(int col=0;col<gameBoard[0].length;col++){
				if(gameBoard[row][col]==0){
					Move move = new Move(row,col);
					return move;
				}
			}
		}
		return null;
	}
}
