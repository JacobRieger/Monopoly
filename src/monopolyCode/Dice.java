package monopolyCode;

public class Dice {
	
	private Integer Die1;
	private Integer Die2;
	private Integer total;
	
	
	public Integer return_total()
	{
		total = 0;
		Die1 = 1 + (int)(Math.random() * ((6 - 1) + 1));
		Die2 = 1 + (int)(Math.random() * ((6 - 1) + 1));
		total = Die1 + Die2;
		return total;
	}
	
	public Integer get_Die1()
	{
		return Die1;
	}
	
	public Integer get_Die2()
	{
		return Die2;
	}

}
