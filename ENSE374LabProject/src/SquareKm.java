import java.util.*;

public class SquareKm {

	private ArrayList <Animal> animalList  = new ArrayList <Animal>();
	private int xCoor;
	private int yCoor;
	
	public SquareKm(int x, int y)
	{
		xCoor = x;
		yCoor = y;
	}
	
	public void setX(int x)
	{
		xCoor = x;
		return;
	}
	
	public void setY(int y)
	{
		yCoor = y;
		return;
	}
	
	public int getX()
	{
		return xCoor;
	}
	
	public int getY()
	{
		return yCoor;
	}
	
	public void addAnimalSuper(String animalName, int maxMoves, int xCoordinate, int yCoordinate)
	{
		animalList.add(new Superpreditor(animalName, maxMoves, xCoordinate, yCoordinate));
		return;
	}
	
	public void addAnimalSuper(String animalName, int maxMoves, int xCoordinate, int yCoordinate, int days)
	{
		animalList.add(new Superpreditor(animalName, maxMoves, xCoordinate, yCoordinate, days));
		return;
	}
	
	public void addAnimalPred(String animalName, int maxMoves, int xCoordinate, int yCoordinate)
	{
		animalList.add(new Preditor(animalName, maxMoves, xCoordinate, yCoordinate));
		return;
	}
	
	public void addAnimalPred(String animalName, int maxMoves, int xCoordinate, int yCoordinate, int days)
	{
		animalList.add(new Preditor(animalName, maxMoves, xCoordinate, yCoordinate, days));
		return;
	}
	
	public void addAnimalPlant(String animalName, int maxMoves, int xCoordinate, int yCoordinate)
	{
		animalList.add(new Plant(animalName, maxMoves, xCoordinate, yCoordinate));
		return;
	}
	
	public void addAnimalPlant(String animalName, int maxMoves, int xCoordinate, int yCoordinate, int days)
	{
		animalList.add(new Plant(animalName, maxMoves, xCoordinate, yCoordinate, days));
		return;
	}
	
	public void deleteAnimal(int index)
	{
		animalList.remove(index);
		return;
	}
	
	public void printAnimals(int x, int y)
	{
		for (Animal temp : animalList) {
			System.out.println( x + ",  "+ y + "  contains: " + temp.getType() + ". ");
		}
		return;
	}

	public int numberAnimals()
	{
		 return animalList.size();
	}
	
	public void animalMove()
	{
		for (Animal temp : animalList) {
			temp.newLocation();
		}
	}
	
	public int checkMove(int i)
	{
		Animal temp = animalList.get(i); 
		if(temp.getXLoc() != getX() || temp.getYLoc() != getY() )
			{
				int number = (temp.getXLoc() * 1000 + temp.getYLoc());
				return number;
			}
		else
			return -1;
	}
	
	public String getAnimalType(int index)
	{
		return animalList.get(index).getType(); 
	}
	
	public String getAnimalKind(int index)
	{
		if(animalList.get(index) instanceof Plant){
			return "plant";
		}
		else if(animalList.get(index) instanceof Preditor){
			return "pred";
		}
		else if(animalList.get(index) instanceof Superpreditor){
			return "super";
		}
		else
			return "";
	}
	
	public int getAnimalDaysLeft(int index)
	{
		Animal temp =  animalList.get(index); 
		if(temp instanceof Preditor) 
			return ((Preditor)temp).getDaysLeft();
		else
			return 0;
	}
	
	public void checkEating()
	{
		int num = animalList.size();
		int i = num;
		Animal temp1, temp2;
		if(num > 1)
		{
		while (i > 0)
		{
	        temp1 = animalList.get(i - 1);
	        if(temp1.getIsType(temp1.getType()) == "plant")
	        {
	        	Plant tempPlant1;
	        	
	        }
	        else if(temp1.getIsType(temp1.getType()) == "pred")
	        {
	        	Preditor tempPred1;
	        	
	        }
	        if(temp1.getIsType(temp1.getType()) == "super")
	        {
	        	Superpreditor tempSuper1;
	        	
	        }
	        for(int j = i; j > 0; j--)
	        {
	        	temp2 = animalList.get(j);
	        	
	        }
	       
	        
	    }
		}
		return;
	}

}
