import java.util.*;

public class SquareKm {

	private ArrayList <Animal> animalList  = new ArrayList <Animal>() ;
	
	public void addAnimalSuper(String animalName, int maxMoves)
	{
		animalList.add(new Superpreditor(animalName, maxMoves));
		return;
	}
	
	public void addAnimalPred(String animalName, int maxMoves)
	{
		animalList.add(new Preditor(animalName, maxMoves));
		return;
	}
	
	public void addAnimalPlant(String animalName, int maxMoves)
	{
		animalList.add(new Plant(animalName, maxMoves));
		return;
	}
	
	public void deleteAnimal(Animal animalName)
	{
		animalList.remove(animalName);
		return;
	}
	
	public void printAnimals(int x, int y)
	{
		for (Animal temp : animalList) {
			System.out.println( x + ",  "+ y + "  contains: " + temp.getType() + ".");
		}
		return;
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
