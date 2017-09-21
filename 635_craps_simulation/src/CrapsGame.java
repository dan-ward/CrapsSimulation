// CrapsGame Class
public class CrapsGame
{
	private int point;
	private Dice dice;
	public static boolean showOutput = true;

	public static void println(String str)
	{
		if (showOutput)
			StdOut.println(str);
	}

	public CrapsGame()
	{
		dice = new Dice();
	}

	public CrapsGame(Die die1, Die die2)
	{
		dice = new Dice(die1, die2);
	}

	public boolean playOneGame(int[] wins, int[] losses)
	{
		int roundsPlayed = 1;

		// Roll the dice
		// Get the value of the roll as point
		// Print out this value as 'first roll'

		doFirstRoll();

		// If point is 7 or 11, announce an immediate win for player,
		// increment wins[steps], and return true indicating win
		
		if (point == 7 || point == 11)
		{
			return winForPlayer(wins, roundsPlayed);
		}
		else if (point==2 || point == 3 || point==12)
		{
			return lossForPlayer(losses, roundsPlayed);
		}

		// Else if point is 2, 3, or 12, announce an immediate loss for player,
		// increment losses[steps], and return false indicating loss

		// If not an immediate win nor loss, print out point
		// roll the dice over and over, keeping track of steps,
		// and printing each rolled value until either:

		// (a) The point is again rolled => a win for player:
		// update wins[] and return true

		// (b) 7 is rolled => a loss for player:
		// update losses[] and return false
		
		else // point rolled: keep going until point rerolled OR 7 rolled
		{
			println("Point is: " + point);
			
			int value = 0;
			do
			{
				dice.roll();
				roundsPlayed++;
				value = dice.getLastRoll();
				println("Next roll is: " + value);
			}
			while (gameIsNotOver(value));
				
			if (gotSeven(value))
			{
				// loss: record losses and return false
				println("You lose throwing a 7.");
				losses[roundsPlayed]++;
				return false;
			}
			else if (gotPoint(value))
			{
				// win: record wins and return false
				println("You win by throwing your point " + value);
				wins[roundsPlayed]++;
				return true;

			}
		}

		return false;
	}

	private boolean gotPoint(int value)
	{
		return value==point;
	}

	private boolean gotSeven(int value)
	{
		return value==7;
	}

	private boolean gameIsNotOver(int value)
	{
		return notSeven(value) && notPoint(value);
	}

	private boolean notSeven(int value)
	{
		//did not get 7
		return value != 7;
	}

	private boolean notPoint(int value)
	{
		//did not get point
		return value != point;
	}

	private boolean lossForPlayer(int[] losses, int roundsPlayed)
	{
		println("Loss for player with " + point);
		losses[roundsPlayed] = losses[roundsPlayed] + 1; // number of losses with exactly roundsPlayed # of rounds.
		return false;
	}

	private void doFirstRoll()
	{
		dice.roll();

		point = dice.getLastRoll();

		println("First roll is: " + dice.getLastRoll());
	}

	private boolean winForPlayer(int[] wins, int roundsPlayed)
	{
		println("Win for player with " + point);
		wins[roundsPlayed] = wins[roundsPlayed] + 1; // number of wins with exactly roundsPlayed # of rounds.
		return true;
	}

	public static void main(String[] args)
	{
		// play a game!
	}
}
