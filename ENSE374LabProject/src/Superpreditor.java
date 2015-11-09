import java.util.*;

public class Superpreditor extends Animal{

	private int daysLeft;
	private boolean eatsToday;
	
	public Superpreditor()
	{
		int daysLeft = 1000;
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
	
	public boolean getEatsToday()
	{
		return true;
	}
	
	public void setEatsToday(boolean eatsToday)
	{
		return;
	}
	
}
