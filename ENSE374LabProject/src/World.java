
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
				area[i][j] = new SquareKm(i, j);
			}
		}
	}
	
	public void runSim(int days)
	{
		userPopulate();
		printAnimals();
		for(int i = 0; i < days; i++)
		{
			System.out.println("Day number " + (i + 1) + ".");
			moveAnimals();
			printAnimals();
		}
	}
	
	public void userPopulate()
	{
		populateForPlant("grass");
		populateForPlant("Tree/Shrub");
		populateForPred("caterpillar");
		populateForPred("grasshopper");
		populateForPred("deer");
		populateForPred("bluejay");
		populateForPred("squirel");
		populateForPred("mouse");
		populateForPred("rabbit");
		populateForSuper("hawk");								
		populateForSuper("wolf");
		populateForSuper("fox");

		return;
	}
	
	public int maxMovesAnimal(String typeName)
	{
		if(typeName == "caterpillar")
			return 1;
		else if(typeName == "grasshopper")
			return 1;
		else if(typeName == "deer")
			return 3;
		else if(typeName == "bluejay")
			return 5;
		else if(typeName == "squirel")
			return 3;
		else if(typeName == "mouse")
			return 3;
		else if(typeName == "rabbit")
			return 3;
		else if(typeName == "hawk")
			return 5;
		else if(typeName == "wolf")
			return 3;
		else if(typeName == "fox")
			return 3;
		else
			return 0;
	}
	
	public void populateForPlant(String animalName)
	{
		int maxMoves = maxMovesAnimal(animalName);
		int numberOf = promptUser(animalName);
		for(int i = 0; i < numberOf; i++)
		{
			int xCoordinate = randomGenerator(size);
			int yCoordinate = randomGenerator(size);
			area[xCoordinate][yCoordinate].addAnimalPlant(animalName, maxMoves, xCoordinate, yCoordinate);
		}
		return;
	}
	
	public void populateForPred(String animalName)
	{
		int maxMoves = maxMovesAnimal(animalName);
		int numberOf = promptUser(animalName);
		for(int i = 0; i < numberOf; i++)
		{
			int xCoordinate = randomGenerator(size);
			int yCoordinate = randomGenerator(size);
			area[xCoordinate][yCoordinate].addAnimalPred(animalName, maxMoves, xCoordinate, yCoordinate);
		}
		return;
	}
	
	public void populateForSuper(String animalName)
	{
		int maxMoves = maxMovesAnimal(animalName);
		int numberOf = promptUser(animalName);
		for(int i = 0; i < numberOf; i++)
		{
			int xCoordinate = randomGenerator(size);
			int yCoordinate = randomGenerator(size);
			area[xCoordinate][yCoordinate].addAnimalSuper(animalName, maxMoves, xCoordinate, yCoordinate);
		}
		return;
	}
	
	public void printAnimals()
	{
		for(int i = 0; i< size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				area[i][j].printAnimals(i, j);
			}
		}
		
		return;
	}
	
	public int promptUser(String animalName)
	{
		Scanner in = new Scanner(System.in);
		/*System.out.print("How many " + animalName + " would you like to put in the world? ");
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
		}*/
		//return number;
		return 20;
	}
	
	public int randomGenerator(int max)
	{
		Random rand = new Random();
		int number = rand.nextInt(max);
		return number;
	}

	public void moveAnimals()
	{
		int populated, x, y, XandY, tempDays, maxMoves;
		String tempType, tempKind;
		for(int i = 0; i< size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				area[i][j].animalMove();
				populated = area[i][j].numberAnimals();
				for(int k = 0; k < populated ; k++)
				{
					//System.out.println("Populated: " + populated);
					XandY = area[i][j].checkMove(k);
					//System.out.println("XandY: " + XandY);
					if(XandY != -1)
					{
						//System.out.println(k);
						x = XandY/1000;
						y = XandY - (x * 1000);
						
						tempType = area[i][j].getAnimalType(k);
						tempKind = area[i][j].getAnimalKind(k);
						maxMoves = maxMovesAnimal(tempType);
						if(tempKind == "plant")
						{
							tempDays = 0;
							area[x][y].addAnimalPlant(tempType, maxMoves, x, y, tempDays);
						}
						else if(tempKind == "pred")
						{
							tempDays = area[i][j].getAnimalDaysLeft(k);
							area[x][y].addAnimalPred(tempType, maxMoves, x, y, tempDays);
						}
						else if(tempKind == "super")
						{
							tempDays = area[i][j].getAnimalDaysLeft(k);
							area[x][y].addAnimalSuper(tempType, maxMoves, x, y, tempDays);
						}
						
						//System.out.println("XandY: " + XandY + " i and j: " + i + ", " + j + "   x and y: "  + x + ", " + y + "    Type: " + tempType + "   maxMoves: " + maxMoves);
						
						
						area[i][j].deleteAnimal(k);
						populated--;
						k--;
						
					}
				}
				area[i][j].clearAnimalMove();
			}
		}
		
		return;
	}
	
}

