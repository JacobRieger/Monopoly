package monopolyCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class MonopolyTest {

	@Test
	public void test() {
		
		monopoly tg = new monopoly();
		boardPosition test = new boardPosition();
		test.SetBoardValues();
		
		Integer dice = tg.dice();
		
		assertEquals(tg.getPlayera(), tg.getCurrentPlayer());
		tg.getCurrentPlayer().incrementLocation(1);
		tg.getPlayerb().incrementLocation(1);
		tg.getPlayerc().incrementLocation(1);
		tg.getPlayerd().incrementLocation(1);
		tg.buyCurrentLocation();
		assertEquals(1, tg.getCurrentPlayer().returnBuildingList().size());
		tg.whosTurn();
		tg.whosTurn();
		tg.whosTurn();
		tg.whosTurn();
		tg.whosTurn();
		assertEquals(tg.getPlayerb(), tg.getCurrentPlayer());
		
		tg.getCurrentPlayer().incrementLocation(2);
		tg.getPlayera().incrementLocation(2);
		tg.getPlayerc().incrementLocation(2);
		tg.getPlayerd().incrementLocation(2);
		tg.buyCurrentLocation();
		assertEquals(tg.getPlayerb(), tg.getCurrentPlayer());
		assertEquals(1, tg.getCurrentPlayer().returnBuildingList().size());
		tg.whosTurn();
		tg.whosTurn();
		tg.whosTurn();
		tg.whosTurn();
		tg.whosTurn();
		assertEquals(tg.getPlayerc(), tg.getCurrentPlayer());
		tg.getCurrentPlayer().incrementLocation(3);
		tg.getPlayera().incrementLocation(3);
		tg.getPlayerb().incrementLocation(3);
		tg.getPlayerd().incrementLocation(3);
		tg.buyCurrentLocation();
		assertEquals(1, tg.getCurrentPlayer().returnBuildingList().size());
		tg.whosTurn();
		tg.whosTurn();
		tg.whosTurn();
		tg.whosTurn();
		tg.whosTurn();
		assertEquals(tg.getPlayerd(), tg.getCurrentPlayer());
		tg.getCurrentPlayer().incrementLocation(3);
		tg.getPlayera().incrementLocation(3);
		tg.getPlayerb().incrementLocation(3);
		tg.getPlayerd().incrementLocation(3);
		tg.buyCurrentLocation();
		tg.whosTurn();
		tg.whosTurn();
		tg.whosTurn();
		tg.whosTurn();
		tg.whosTurn();
		assertEquals(1, tg.getCurrentPlayer().returnBuildingList().size());
		
		
	}

}
