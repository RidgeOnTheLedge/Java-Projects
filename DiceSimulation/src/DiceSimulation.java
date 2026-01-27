import java.util.Random;

public class DiceSimulation 
{	
	public static void main(String args[])
	{	
		Die[] dice = new Die[DieType.values().length];
		
		int index = 0;
		for(DieType type : DieType.values())
		{
			dice[index++] = new Die(type);
		}	
		
		setDieSuccessRate(dice);
		System.out.println();
		printPercentGain(dice);
		//printPercentGain(dice);
	}
	
	private static final int ROLL_COUNT = 100_000;
	private static void setDieSuccessRate(Die[] dice)
	{
		Random rand = new Random();
		
		for(int j = 0; j < dice.length; j++)
		{
			double successCount = 0;
			
			for(int i = 0; i < ROLL_COUNT; i++)
			{
				int sides = dice[j].getType().getSides();
				int die1 = rand.nextInt(sides) + 1;
				int die2 = rand.nextInt(sides) + 1;
				
				int difference = Math.abs(die1 - die2);
				
				if (difference <= dice[j].getType().getThreshold())
				{
					successCount++;
				}	
			}	
			
			// Average = successCount / rollCount) * 100
			dice[j].setSuccessRate((successCount / ROLL_COUNT) * 100);
			System.out.println(dice[j]);			
		}	
	}
	
	private static void printPercentGain(Die[] dice) 
	{
		double total = 0;
		for(int i = 0; i < dice.length - 1; i++)
		{
			double successDiff = Math.abs(dice[i + 1].getSuccessRate() - dice[i].getSuccessRate());
			total += successDiff;
			System.out.printf(
				    "From %s to %s gain %.1f%%%n",
				    dice[i].getType(),
				    dice[i + 1].getType(),
				    successDiff
				);
		}
		
		double gain = total / (dice.length - 1);
		System.out.printf("Average Die gain: %.1f%%%n", gain);
			
	}
}
