
public class LoadedDie2 extends Die // subclassing
{
	public LoadedDie2()
	{
		CrapsGame.println("  LoadedDie2's constructor called.");
	}

	public void roll() // can you see what this computes?
	{
		// call the inherited method to get lastRoll from parent Die parts

		int baseRoll = getLastRoll();

		if (baseRoll == 6)
			this.setLastRoll(1);
		else
			this.setLastRoll(baseRoll + 1);
	}

	public String toString()
	{
		return "A LoadedDie2 rolling 1,2,3,4,5,6 in sequence, and... ";
	}

}
