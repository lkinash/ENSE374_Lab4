import java.util.*;
// There are 10 animals in the world, each is assigned a number, like an id for that animal
// the animal ID numbers are as follows
// Caterpillar: 0
// Grasshopper: 1
// Deer: 2
// Bluejay: 3
// Squirel: 4
// Mouse: 5
// Rabbit: 6
// Hawk: 7
// Wolf: 8
// Fox: 9

public class Plant {

	private boolean canBeEatenBy[];
	private String type;
	private boolean eatenToday;
	
	public Plant()
	{
		for(int i = 0; i < 11; i++)
			canBeEatenBy[i] = false;
		type = null;
		eatenToday = false;
	}
	
	public void setCanBeEatenBy(String typeName)			//based on if the plant is grass or not it will assign which animals can eat it
	{	
		if(typeName == "grass")					//if it is a grass
		{
			canBeEatenBy[1] = true;				//then grasshopper
			canBeEatenBy[2] = true;				//and deer
			canBeEatenBy[5] = true;				//and mouse
			canBeEatenBy[6] = true;				//and rabbit
		}										//these are set to true since these are the animals that can eat grass
		else									//else if here because if it is not grass it is trees and shrubs 
		{
			canBeEatenBy[0] = true;				//then caterpillar
			canBeEatenBy[3] = true;				//and bluejay
			canBeEatenBy[4] = true;				//and squirel
			canBeEatenBy[5] = true;				//and mouse are set true since they can eat the trees and shrubs
		}
		
		return;
	}
	
	public boolean getCanBeEatenBy(String typeName)		//this function is passed an animal type and passes back if that animal can eat this plant or not
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
	
	public void setType(String typeName)
	{
		type = typeName;
		return;
	}
	
	public String getType()
	{
		return type;
	}
	
	public boolean getEatenToday()
	{
		return true;
	}
	
	public void setEatenToday(boolean getsEaten)
	{
		return;
	}
	
}
