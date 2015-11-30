import java.util.Arrays;
import java.util.Random;

public class Animal {

	private int moves;
	private int moveDir;
	private int maxMoves;
	private String type;
	private int xLoc;
	private int yLoc;
	
	public Animal()
	{
		moves = 0;
		moveDir = 0;
		maxMoves = 0;
		type = null;
	}
	
	public Animal(String typeName, int animalMovesMax, int x, int y)
	{
		moves = 0;
		moveDir = 0;
		maxMoves = animalMovesMax;
		type = typeName;
		xLoc = x;
		yLoc = y;
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
	
	public int getXLoc()
	{
		return xLoc;
	}
	
	public int getYLoc()
	{
		return yLoc;
	}
	
	public void setMoves(int numMoves)
	{
		moves = numMoves;
		return;
	}
	
	public void setXLoc(int newLoc)
	{
		xLoc = newLoc;
		return;
	}
	
	public void setYLoc(int newLoc)
	{
		yLoc = newLoc;
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
		
	public String getIsType(String typeName)
	{
		if(typeName == "caterpillar")
			return "pred";
		else if(typeName == "grasshopper")
			return "pred";
		else if(typeName == "deer")
			return "pred";
		else if(typeName == "bluejay")
			return "pred";
		else if(typeName == "squirel")
			return "pred";
		else if(typeName == "mouse")
			return "pred";
		else if(typeName == "rabbit")
			return "pred";
		else if(typeName == "hawk")
			return "super";
		else if(typeName == "wolf")
			return "super";
		else if(typeName == "fox")
			return "super";
		else
			return "plant";
	}

	public void determineMove()
	{
		moves = randomGenerator(getMaxMoves());
		moveDir = randomGenerator(4);	
	}
	
	public int randomGenerator(int max)
	{
		Random rand = new Random();
		int number = rand.nextInt(max);
		return number;
	}
	
	public void newLocation()
	{	
		if(getIsType(type) == "plant")
			return;
		
		determineMove();

		if(moveDir == 0)      //moves east
		{
			xLoc = (xLoc + moves);
		}
		else if(moveDir == 1)		//moves north
		{
			yLoc = (yLoc + moves);
		}
		else if(moveDir == 2)		//moves west
		{
			xLoc = (xLoc - moves);
		}
		else if(moveDir == 3)		//moves south
		{
			yLoc = (yLoc - moves);
		}
		correctBounds();
		return;
	}
	
	public void correctBounds()
	{
		if(xLoc < 0 )
		{
			xLoc = 0;
		}
		else if(xLoc > 150)
		{
			xLoc = 150;
		}
		
		if(yLoc < 0)
		{
			yLoc = 0;
		}
		else if(yLoc > 150)
		{
			yLoc = 150;
		}
		return; 
	}
	
}
