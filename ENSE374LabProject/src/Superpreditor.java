import java.util.*;

public class Superpreditor extends Animal{

	private int daysLeft;
	private boolean eatsToday;
	
	public Superpreditor(String name, int maxMoves, int x, int y)
	{
		super(name, maxMoves, x, y);
		int daysLeft = 2;
		eatsToday = false;
	}
	
	public Superpreditor(String name, int maxMoves, int x, int y, int days)
	{
		super(name, maxMoves, x, y);
		int daysLeft = days;
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
		return eatsToday;
	}
	
	public void setEatsToday(boolean today)
	{
		eatsToday = today;
		return;
	}
	
}
