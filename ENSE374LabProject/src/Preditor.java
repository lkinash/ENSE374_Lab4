import java.util.*;

public class Preditor extends Animal{

	private int daysLeft;
	private boolean[] canBeEatenBy  = new boolean[11];
	private boolean eatenToday;
	private boolean eatsToday;
	
	
	public Preditor(String name, int maxMoves, int x, int y)
	{
		super(name, maxMoves, x, y);
		int daysLeft = 2;
		eatenToday = false;
		eatsToday = false;
		setCanBeEatenBy(name);
	}

	public Preditor(String name, int maxMoves, int x, int y, int days)
	{
		super(name, maxMoves, x, y);
		int daysLeft = days;
		eatenToday = false;
		eatsToday = false;
		setCanBeEatenBy(name);
	}
	
	public void setDaysLeft(int days)
	{
		daysLeft = days;
		return;
	}

	public int getDaysLeft()
	{
		return daysLeft;
	}
	
	public void setCanBeEatenBy(String typeName)
	{
			
		Arrays.fill(canBeEatenBy, Boolean.FALSE);
		
		if(typeName == "caterpillar")					//if it is a caterpillar
		{
			Arrays.fill(canBeEatenBy, 3 , 3 ,Boolean.TRUE);			//bluejay
		}
		else if(typeName == "grasshopper")					//if it is a grasshopper
		{
			Arrays.fill(canBeEatenBy, 3 , 3 ,Boolean.TRUE); 		//bluejay
		}
		else if(typeName == "deer")					//if it is a deer
		{
			Arrays.fill(canBeEatenBy, 8 , 8 ,Boolean.TRUE);			//wolf
		}
		else if(typeName == "bluejay")					//if it is a bluejay
		{
			Arrays.fill(canBeEatenBy, 9 , 9 ,Boolean.TRUE);					//fox
		}
		else if(typeName == "squirel")					//if it is a squirel
		{
			Arrays.fill(canBeEatenBy, 7 , 7 ,Boolean.TRUE);						//hawk
			Arrays.fill(canBeEatenBy, 9 , 9 ,Boolean.TRUE);					//fox
		}
		else if(typeName == "mouse")					//if it is a mouse
		{
			Arrays.fill(canBeEatenBy, 7 , 7 ,Boolean.TRUE);						//hawk
			Arrays.fill(canBeEatenBy, 9 , 9 ,Boolean.TRUE);						//fox
		}
		else if(typeName == "rabbit")					//if it is a rabbit
		{
			Arrays.fill(canBeEatenBy, 7 , 8 ,Boolean.TRUE);						//fox and wolf
		}
		
		return;
	}
	
	public boolean getCanBeEatenBy(String typeName)
	{
		boolean canBeEaten = false;
		int animalId = 10;
	
		if(typeName == "caterpillar")
			animalId = 0;
		else if(typeName == "grasshopper")
			animalId = 1;
		else if(typeName == "deer")
			animalId = 2;
		else if(typeName == "bluejay")
			animalId = 3;
		else if(typeName == "squirel")
			animalId = 4;
		else if(typeName == "mouse")
			animalId = 5;
		else if(typeName == "rabbit")
			animalId = 6;
		else if(typeName == "hawk")
			animalId = 7;
		else if(typeName == "wolf")
			animalId = 8;
		else if(typeName == "fox")
			animalId = 9;
	
		return canBeEatenBy[animalId];
	}

	public boolean getEatenToday()
	{
		return eatenToday;
	}
	
	public void setEatenToday(boolean eaten)
	{
		eatenToday = eaten;
		return;
	}
	
	public boolean getEatsToday()
	{
		return eatsToday;
	}
	
	public void setEatsToday(boolean eats)
	{
		eatsToday = eats;
		return;
	}
	
	
}
