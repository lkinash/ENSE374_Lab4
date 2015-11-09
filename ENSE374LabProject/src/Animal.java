
public class Animal {

	private int moves;
	private int moveDir;
	private int maxMoves;
	private String type;
	
	public Animal(String typeName)
	{
		moves = 0;
		moveDir = 0;
		maxMoves = 0;
		type = typeName;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String typeName)
	{
		type = typeName;
		return;
	}
	
	public int getMoves()
	{
		return moves;
	}
	
	public int getMovesDir()
	{
		return moveDir;
	}
	
	public int getMaxMoves()
	{
		return maxMoves;
	}
	
	public void setMoves(int numMoves)
	{
		moves = numMoves;
		return;
	}
	
	public void setMovesDir(int numMoveDir)
	{
		moveDir = numMoveDir;
		return;
	}
	
	public void setMaxMoves(int numMovesMax)
	{
		maxMoves = numMovesMax;
		return;
	}
	
}
