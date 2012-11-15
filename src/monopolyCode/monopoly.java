package monopolyCode;


import java.util.ArrayList;
import java.util.Random;

public class monopoly {

	
	private player a,b,c,d;
	private Integer dice;
	private ArrayList<building> buildings;
	
	
	
	public monopoly(){
		dice = 0;
		buildings = new ArrayList<building>();
		//String nameofbuilding, Integer buyingPrice, Integer visiting penalty, Integer node, isitowned?
		//database
		
		//for example:
		building start = new building("Go" , 0, -200, 0, true); //this is go, so visiting penalty is negative number, giving people who visits here money.
		buildings.add(start);
		
		building bField = new building("Business Field", 60, 20, 1, false);
		buildings.add(bField);
		
		
		
		
	}

	
	public Integer dice(){
		Random number = new Random();
		int randomInt = number.nextInt(5) + 1;
		return randomInt;
	}

	
}
