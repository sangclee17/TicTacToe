
import java.io.Serializable;

public class HumanPlayer extends Player implements Serializable
{
	private static final long serialVersionUID = 1L;

	// HumanPlayer constructor referring to parent class
	public HumanPlayer(String userName, String familyName, String givenName)
	{
		super(userName,familyName,givenName);
	}

	// MakeMove method overridden when an object of HumanPlayer has been called
	public Move makeMove(int[][] gameboard){
		Move playerMove = new Move(TicTacToe.keyboard.nextInt());
		return playerMove;
	}
}
