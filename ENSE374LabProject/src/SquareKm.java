import java.util.*;

public class SquareKm {

	private ArrayList <Animal> animalList;
	
	public SquareKm()
	{
		animalList = null;
	}
	
	public void addAnimal(String animalName)
	{
		animalList.add(new Animal(animalName));
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
	
}
