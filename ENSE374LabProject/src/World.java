
import java.util.*;

public class World {

	private static int size = 150;
	private SquareKm[][] area = new SquareKm[size][size];
	private int maxNumberOfType = 2000;
	
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
	
	public void runSim()
	{
		int days = promptUser();
		
		for(int i = 0; i < days; i++)
		{
			System.out.println("Day number " + (i + 1) + ".");
			oneDay();
		}
	}
	
	public int promptUser()
	{
		Scanner in = new Scanner(System.in);
		int days = 15;
		System.out.print("Would you like to run the default simulation or populate the world on your own? Enter '1' for populate and '2' for default: ");
		int letter = in.nextInt();
		in.nextLine();
		if(letter == 1)
		{
			days = promptDays();
			userPopulate(true);
		}
		else if(letter == 2)
		{
			userPopulate(false);
		}
		else
		{
			while(letter != 1 || letter != 2)
			{
				System.out.print("That is not one of the choices, please enter a new letter. Enter '1' for populate and '2' for default:  ");
				letter = in.nextInt();
				in.nextLine();
			}
		}
		return days;
		
	}
	
	public void userPopulate(boolean prompt)
	{
		populateForPlant("grass", prompt);
		populateForPlant("Tree/Shrub", prompt);
		populateForPred("caterpillar", prompt);
		populateForPred("grasshopper", prompt);
		populateForPred("deer", prompt);
		populateForPred("bluejay", prompt);
		populateForPred("squirel", prompt);
		populateForPred("mouse", prompt);
		populateForPred("rabbit", prompt);								
		populateForSuper("wolf", prompt);
		populateForSuper("fox", prompt);
		populateForSuper("hawk", prompt);

		return;
	}
	
	public void oneDay()
	{

		Scanner in = new Scanner(System.in);
		
		moveAnimals();
		System.out.print("Would you like to print out all of the animals with their locations for this day? Enter '1' for yes and '2' no: ");
		int number = in.nextInt();
		in.nextLine();
		if(number ==1)
			printAnimals();
		for(int i = 0; i< size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				area[i][j].noFoodDay();
				area[i][j].checkEating();
				area[i][j].checkDies();
			}
		}

		countAnimals();
		
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
	
	public void populateForPlant(String animalName, boolean prompt)
	{
		int maxMoves = maxMovesAnimal(animalName);
		int numberOf = 0;
		if(prompt)
		{
			numberOf = promptUser(animalName);
		}
		else
		{
			numberOf = 1000;
		}	
		for(int i = 0; i < numberOf; i++)
		{
			int xCoordinate = randomGenerator(size);
			int yCoordinate = randomGenerator(size);
			area[xCoordinate][yCoordinate].addAnimalPlant(animalName, maxMoves, xCoordinate, yCoordinate, 2);
		}
		return;
	}
	
	public void populateForPred(String animalName, boolean prompt)
	{
		int maxMoves = maxMovesAnimal(animalName);
		int numberOf = 0;
		if(prompt)
		{
			numberOf = promptUser(animalName);
		}
		else
		{
			numberOf = 1000;
		}	
		for(int i = 0; i < numberOf; i++)
		{
			int xCoordinate = randomGenerator(size);
			int yCoordinate = randomGenerator(size);
			area[xCoordinate][yCoordinate].addAnimalPred(animalName, maxMoves, xCoordinate, yCoordinate, 5);
		}
		return;
	}
	
	public void populateForSuper(String animalName, boolean prompt)
	{
		int maxMoves = maxMovesAnimal(animalName);
		int numberOf = 0;
		if(prompt)
		{
			numberOf = promptUser(animalName);
		}
		else
		{
			numberOf = 1000;
		}	
		for(int i = 0; i < numberOf; i++)
		{
			int xCoordinate = randomGenerator(size);
			int yCoordinate = randomGenerator(size);
			area[xCoordinate][yCoordinate].addAnimalSuper(animalName, maxMoves, xCoordinate, yCoordinate, 8);
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
		//return 500;
	}
	
	public int promptDays()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("How many days would you like to simulate? ");
		int number = in.nextInt();
		in.nextLine();
		if(number > 100)
		{
			while(number >  100)
			{
			System.out.print("That is more than the maximum number of days allowed, The maximum is 100, please enter a new number: ");
			number = in.nextInt();
			in.nextLine();
			}
		}
	return number;
	}
	
	public int randomGenerator(int max)
	{
		Random rand = new Random();
		int number = rand.nextInt(max);
		return number;
	}

	public void countAnimals()
	{
		int count = 0;
		int plants = 0;
		for(int i = 0; i< size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				count += area[i][j].numberAnimals();
				plants += area[i][j].numberPlants();
			}
		}
		System.out.println("Animal count: " + (count-plants));
		System.out.println("Plant count: " + plants);
		
		return;
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
							//System.out.println("k is: " + k + "tempdays " + tempDays);
							area[x][y].addAnimalPred(tempType, maxMoves, x, y, tempDays);
						}
						else if(tempKind == "super")
						{
							tempDays = area[i][j].getAnimalDaysLeft(k);
							//System.out.println("tempdays" + tempDays);
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

