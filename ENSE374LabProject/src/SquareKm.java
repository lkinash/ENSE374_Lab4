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
	
	public int getNumberOFAnimal(Animal animalName)
	{
		int count = Collections.frequency(animalList, animalName);
		return count;
	}
	
	public void printAnimals(int x, int y)
	{
		for (Animal temp : animalList) {
			System.out.println( x + ",  "+ y + "  contains: " + temp.getType() + ".");
		}
		return;
	}
	
}
