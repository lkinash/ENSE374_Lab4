

public class Superpreditor extends Animal{

	private int daysLeft;
	private boolean eatsToday;
	
	public Superpreditor(String name, int maxMoves, int x, int y, int days)
	{
		super(name, maxMoves, x, y);
		setDaysLeft(days);
		eatsToday = false;
	}
	
	public void setDaysLeft(int days)
	{
		daysLeft = days;
		return;
	}

	public int getDaysLeft()
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
