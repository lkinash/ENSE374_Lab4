
import java.util.*;

public class World {

	private static int size = 150;
	private SquareKm[][] area = new SquareKm[size][size];
	private int maxNumberOfType = 40;
	
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
		populateForPlant("grass", 0);
		populateForPlant("Tree/Shrub", 0);
		populateForPred("caterpillar", 1);
		populateForPred("grasshopper", 1);
		populateForPred("deer", 3);
		populateForPred("bluejay", 5);
		populateForPred("squirel", 3);
		populateForPred("mouse", 3);
		populateForPred("rabbit", 3);
		populateForSuper("hawk", 5);								
		populateForSuper("wolf", 3);
		populateForSuper("fox", 3);

		return;
	}
	
	public void populateForPlant(String animalName, int maxMoves)
	{
		int numberOf = promptUser(animalName);
		for(int i = 0; i < numberOf; i++)
		{
			int xCoordinate = randomGenerator();
			int yCoordinate = randomGenerator();
			area[xCoordinate][yCoordinate].addAnimalPlant(animalName, maxMoves);
		}
		return;
	}
	
	public void populateForPred(String animalName, int maxMoves)
	{
		int numberOf = promptUser(animalName);
		for(int i = 0; i < numberOf; i++)
		{
			int xCoordinate = randomGenerator();
			int yCoordinate = randomGenerator();
			area[xCoordinate][yCoordinate].addAnimalPred(animalName, maxMoves);
		}
		return;
	}
	
	public void populateForSuper(String animalName, int maxMoves)
	{
		int numberOf = promptUser(animalName);
		for(int i = 0; i < numberOf; i++)
		{
			int xCoordinate = randomGenerator();
			int yCoordinate = randomGenerator();
			area[xCoordinate][yCoordinate].addAnimalSuper(animalName, maxMoves);
		}
		return;
	}
	
	public void printAnimals()
	{
		for(int i = 0; i< size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				area[i][j].printAnimals(i+1, j+1);
			}
		}
		
		return;
	}
	
	public int promptUser(String animalName)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("How many " + animalName + " would you like to put in the world? ");
		int number = in.nextInt();
		in.nextLine();
		if(number > maxNumberOfType)
		{
			while(number >  maxNumberOfType)
			{
			System.out.print("That is more than the maximum number of " + animalName + " allowed, The maximum is " + maxNumberOfType + ", please enter a new number: ");
			number = in.nextInt();
			in.nextLine();
			}
		}
		return number;
	}
	
	public int randomGenerator()
	{
		Random rand = new Random();
		int number = rand.nextInt(size);
		return number;
	}
	
}
