import java.util.*;

public class Preditor {

	private int daysLeft;
	private boolean canBeEatenBy[];
	private String type;
	private boolean eatenToday;
	private boolean eatsToday;
	
	public Preditor()
	{
		for(int i = 0; i < 11; i++)
			canBeEatenBy[i] = false;
		int daysLeft = 1000;
		type = null;
		eatenToday = false;
		eatsToday = false;
	}
	
	public void setDaysLeft(int daysLeft)
	{
		return;
	}

	public int getDaysLeft(int days)
	{
		return days;
	}
	
	public void setCanBeEatenBy(String name)
	{
		return;
	}
	
	public String getCanBeEatenBy(String name)
	{
		return name;
	}

	public void setType(String typeName)
	{
		type = typeName;					//sets the type of animal to the value passed in
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
	
	public void setEatenToday(boolean eatenToday)
	{
		return;
	}
	
	public boolean getEatsToday()
	{
		return true;
	}
	
	public void setEatsToday(boolean eatsToday)
	{
		return;
	}
	
	
}
