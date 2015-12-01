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
	public void addAnimalSuper(String animalName, int maxMoves, int xCoordinate, int yCoordinate, int days)
	{
		animalList.add(new Superpreditor(animalName, maxMoves, xCoordinate, yCoordinate, days));
		return;
	}

	public void addAnimalPred(String animalName, int maxMoves, int xCoordinate, int yCoordinate, int days)
	{
		animalList.add(new Preditor(animalName, maxMoves, xCoordinate, yCoordinate, days));
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
			System.out.println( x + ",  "+ y + "  " + temp.getType() + ". ");
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
	
	public void clearAnimalMove()
	{
		for (Animal temp : animalList) {
			temp.setMoves(0);
			temp.setMovesDir(0);
		}
	}
	
	public void noFoodDay()
	{
		for (Animal temp : animalList) {
			if(temp instanceof Preditor) 
				{
					((Preditor)temp).setDaysLeft((((Preditor)temp).getDaysLeft() - 1));
					System.out.println((((Preditor)temp).getDaysLeft() ));
				}
			else if (temp instanceof Superpreditor)
				((Superpreditor)temp).setDaysLeft((((Superpreditor)temp).getDaysLeft() - 1));
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
		if(animalList.get(index) instanceof Preditor) 
			return ((Preditor)animalList.get(index)).getDaysLeft();
		
		else if (animalList.get(index) instanceof Superpreditor)
			return ((Superpreditor)animalList.get(index)).getDaysLeft();
		
		else
			return 0;
	}
	
	public void setAnimalDaysLeft(int index, int days)
	{
		Animal temp =  animalList.get(index); 
		if(temp instanceof Preditor) 
			((Preditor)temp).setDaysLeft(days);
		else if (temp instanceof Superpreditor)
			((Superpreditor)temp).setDaysLeft(days);

		return ;
	}
	
	public void checkDies()
	{
		for(int i = 0; i < animalList.size(); i++)
		{
			Animal temp =  animalList.get(i); 
			if(temp instanceof Preditor) 
			{
				if(((Preditor)temp).getDaysLeft() < 1)
				{
					System.out.println("At " + xCoor + ", " + yCoor + " a " + getAnimalType(i) + " died. ");
					deleteAnimal(i);
					i--;
				}
			}
			else if (temp instanceof Superpreditor)
			{
				if(((Superpreditor)temp).getDaysLeft() < 1)
				{
					System.out.println("At " + xCoor + ", " + yCoor + " a " + getAnimalType(i) + " died. ");
					deleteAnimal(i);
					i--;
				}
			}
		}
	}
	
	public void checkEating()
	{
		int num = animalList.size();
		boolean getsEaten = false;
		if(num > 1)
		{
			for(int i = 0; i < num; i++)
			{	
				Animal temp =  animalList.get(i);
				for(int j = i+1; j < num; j++)
				{
					Animal temp2 =  animalList.get(j);
					if(temp instanceof Plant) 
					{
						if(temp2 instanceof Preditor)
						{
							getsEaten = ((Plant)temp).getCanBeEatenBy(getAnimalType(j));
							if(getsEaten)
							{
								System.out.println("At " + xCoor + ", " + yCoor + " a " + getAnimalType(i) + " was eaten by " + getAnimalType(j) + ". ");
								deleteAnimal(i);
								num--;
								i--;
								((Preditor)temp2).setDaysLeft(2);
									}
						}
					}
					else if(temp instanceof Preditor) 
					{
						if(temp2 instanceof Superpreditor)
						{
							getsEaten = ((Preditor)temp).getCanBeEatenBy(getAnimalType(j));
							if(getsEaten)
							{
								System.out.println("At " + xCoor + ", " + yCoor + " a " + getAnimalType(i) + " was eaten by " + getAnimalType(j) + ". ");
								deleteAnimal(i);
								i--;
								num--;
								((Superpreditor)temp2).setDaysLeft(2);
							}
						}
					}
				}
			}
		}
		return;
	}

}
