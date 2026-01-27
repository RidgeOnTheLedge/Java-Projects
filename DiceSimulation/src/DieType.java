class Constants
{
	public final static int MAJOR_THRESH = 4;
}

public enum DieType
{	
	DisD100(100, 10), // Epic 2, Expert 5, Fair 10
	D100(100, 20), // Epic 5, Expert 10, Fair 20
	D20(20, Constants.MAJOR_THRESH),
	D16(16, Constants.MAJOR_THRESH),
	D12(12, Constants.MAJOR_THRESH),
	D10(10, Constants.MAJOR_THRESH),
	D8(8, Constants.MAJOR_THRESH),
	D6(6, Constants.MAJOR_THRESH),
	D4(4, Constants.MAJOR_THRESH);	

	private final int sides;
	private final int threshold;
	
	DieType(int sides, int threshold)
	{
		this.sides = sides;
		this.threshold = threshold;
	}
	
	public int getSides()
	{
		return sides;
	}
	
	public int getThreshold()
	{
		return threshold;
	}
}
