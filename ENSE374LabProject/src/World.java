
import java.util.*;

public class World {

	private static int size = 150;
	private SquareKm area[][];
	
	public World()
	{
		for(int i = 0; i< size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				area[i][j] = new SquareKm();
			}
		}
	}
	
	public void userPopulate()
	{
		populateFor("grass");
		populateFor("Tree/Shrub");
		populateFor("caterpillar");
		populateFor("grasshopper");
		populateFor("deer");
		populateFor("bluejay");
		populateFor("squirel");
		populateFor("mouse");
		populateFor("rabbit");
		populateFor("hawk");								
		populateFor("wolf");
		populateFor("fox");

		return;
	}
	
	public void populateFor(String animalName)
	{
		int numberOf = promptUser(animalName);
		for(int i = 0; i < numberOf; i++)
		{
			int xCoordinate = randomGenerator();
			int yCoordinate = randomGenerator();
			area[xCoordinate][yCoordinate].addAnimal(animalName);
		}
		return;
	}
	
	public void printAnimals()
	{
		
		return;
	}
	
	public int promptUser(String animalName)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("How many " + animalName + " would you like to put in the world? ");
		int number = in.nextInt();
		in.nextLine();
		return number;
	}
	
	public int randomGenerator()
	{
		Random rand = new Random();
		int number = rand.nextInt(size);
		return number;
	}
	
}
