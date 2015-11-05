import java.util.*;

public class Superpreditor {

	private int daysLeft;
	private String type;
	private boolean eatsToday;
	
	public Superpreditor()
	{
		int daysLeft = 1000;
		type = null;
		eatsToday = false;
	}
	
	
	public void setDaysLeft(int days)
	{
		daysLeft = days;
		return;
	}

	public int getDaysLeft(int daysLeft)
	{
		return daysLeft;
	}
	
	public void setType(String typeName)
	{
		type = typeName;					//sets the type of animal to the value passed in
		return;
	}
	
	public String getType()
	{
		return "true";
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
