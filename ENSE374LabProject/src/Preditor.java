import java.util.*;

public class Preditor extends Animal{

	private int daysLeft;
	private boolean canBeEatenBy[];
	private boolean eatenToday;
	private boolean eatsToday;
	
	public Preditor()
	{
		for(int i = 0; i < 11; i++)
			canBeEatenBy[i] = false;
		int daysLeft = 1000;
		eatenToday = false;
		eatsToday = false;
	}
	
	public void setDaysLeft(int daysLeft)
	{
		return;
	}

	public int getDaysLeft(int days)
	{
		return days;
	}
	
	public void setCanBeEatenBy(String typeName)
	{
		if(typeName == "caterpillar")					//if it is a caterpillar
		{
			canBeEatenBy[3] = true;						//bluejay
		}
		else if(typeName == "grasshopper")					//if it is a grasshopper
		{
			canBeEatenBy[3] = true;						//bluejay
		}
		else if(typeName == "deer")					//if it is a deer
		{
			canBeEatenBy[8] = true;						//wolf
		}
		else if(typeName == "bluejay")					//if it is a bluejay
		{
			canBeEatenBy[9] = true;						//fox
		}
		else if(typeName == "squirel")					//if it is a squirel
		{
			canBeEatenBy[7] = true;						//hawk
			canBeEatenBy[9] = true;						//fox
		}
		else if(typeName == "mouse")					//if it is a mouse
		{
			canBeEatenBy[7] = true;						//hawk
			canBeEatenBy[9] = true;						//fox
		}
		else if(typeName == "rabbit")					//if it is a rabbit
		{
			canBeEatenBy[9] = true;						//fox
			canBeEatenBy[8] = true;						//wolf
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
		return true;
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
