public class Move {

	private int row;
	private int col;

	public Move(){

	}
	//Overriding method for an object of HumanPlayer makeMove implementation
	public Move(int playerMove)
	{
		row = playerMove;
		col = playerMove;
	}
	//Overriding method for an object of aiPlayer makeMove implementation
	public Move(int playerRowMove, int playerColMove)
	{
		row = playerRowMove;
		col = playerColMove;
	}

	public int getRow()
	{
		return row;
	}

	public int getCol()
	{
		return col;
	}
}