package monopolyCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void test() {


		player TP = new player("Test", true);
		
		assertEquals(TP.returnName(), "Test");
		assertEquals(TP.returnLocation(), (Integer)0);
		assertEquals((Integer)2000, TP.returnMoney());
		
		for(int i = 0; i < 41; i++)
		{
			
			if(i == 40)
			{
				assertEquals(TP.returnLocation(), (Integer)0);
			}
			else
			{
				assertEquals(TP.returnLocation(), (Integer)i);
			}
			TP.incrementLocation(1);
		}
		
		assertEquals(false,  TP.checkBroke());
		TP.addMoney(2000);
		assertEquals((Integer)0, TP.returnMoney());
		assertEquals(true, TP.checkBroke());
		
		
		
		
	}

}
