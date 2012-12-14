package monopolyCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChanceTest {

	@Test
	public void test() {
		monopoly tg = new monopoly();
		
		
		tg.getPlayera().incrementLocation(2);
		tg.whosTurn();
	}

}
