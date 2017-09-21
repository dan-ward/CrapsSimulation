
public class LoadedDie1 extends Die
{
	public LoadedDie1()
	{
		CrapsGame.println("  CrookedDie1's constructor called.");
		
	}

	public int getLastRoll() // this OVERRIDES Die's getLastRoll(), replacing
								// it!
	{
		return 3;  //Always return 3
	}

	public String toString() // this OVERRIDES Die's toString()
	{
		return "A LoadedDie1 always rolling 3, and... " + super.toString();
	}

}
