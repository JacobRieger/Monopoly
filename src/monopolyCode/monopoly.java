package monopolyCode;

import java.util.ArrayList;
import java.util.Random;

public class monopoly {

	private player a, b, c, d;
	private Integer dice;
	private ArrayList<building> buildings;

	public monopoly() {
		dice = 0;
		buildings = new ArrayList<building>();
		// String nameofbuilding, Integer buyingPrice, Integer visiting penalty,
		// Integer node, isitowned?
		// database

		// for example:
		building start = new building("Go", 0, -200, 0, true); // this is go, so
																// visiting
																// penalty is
																// negative
																// number,
																// giving people
																// who visits
																// here money.
		buildings.add(0, start);

		building bField = new building("Business Field", 60, 20, 1, false);
		buildings.add(1, bField);

		// chest

		building fField = new building("Farrand Field", 60, 20, 3, false);
		buildings.add(3, fField);
		
		// parking permit
		
		// Jump

		building Whealthcen = new building("Wardenburg Health Center", 100, 40,
				6, false);
		buildings.add(6, Whealthcen);

		// chance

		building bookstore = new building("CU Bookstore", 100, 40, 8, false);
		buildings.add(8, bookstore);

		building museum = new building("CU Art Museum", 120, 50, 9, false);
		buildings.add(9, museum);

		building visit = new building("Just Visiting", 0, 0, 10, true);
		buildings.add(10, visit);

		building mathlib = new building("Math Library", 140, 60, 11, false);
		buildings.add(11, mathlib);

		// parking permit

		building musiclib = new building("Music Library", 140, 60, 13, false);
		buildings.add(13, musiclib);

		building norlinlib = new building("Norlin Library", 160, 70, 14, false);
		buildings.add(14, norlinlib);

		// buffbus

		building brackett = new building("Brackett Hall", 180, 80, 16, false);
		buildings.add(16, brackett);

		// chance

		building crosman = new building("Crosman Hall", 180, 80, 18, false);
		buildings.add(18, crosman);

		building aden = new building("Aden Hall", 200, 90, 19, false);
		buildings.add(19, aden);

		building c4c = new building("C4C", 220, 100, 20, false);
		buildings.add(20, c4c);

		// chance

		building fhall = new building("Farrand Hall", 220, 100, 22, false);
		buildings.add(22, fhall);

		building lhall = new building("Libby Hall", 240, 110, 23, false);
		buildings.add(23, lhall);

		// HOP

		building folsom = new building("Folsom Stadium", 260, 120, 25, false);
		buildings.add(26, folsom);

		building coors = new building("Coors Event Center", 260, 120, 26, false);
		buildings.add(27, coors);

		// motorcycle permit

		building reccenter = new building("Rec Center", 280, 130, 29, false);
		buildings.add(29, reccenter);

		// Go TO

		building engine = new building("Engineering Center", 300, 140, 31,
				false);
		buildings.add(31, engine);

		building koelbel = new building("Koelbel Building", 300, 140, 32, false);
		buildings.add(32, koelbel);

		// chest

		building UMC = new building("University Memorial Center", 320, 150, 34,
				false);
		buildings.add(34, UMC);

		// stampede
		// chance

		building willvil = new building("Williams Village", 350, 170, 37, false);
		buildings.add(37, willvil);

		// parking ticket

		building bearcreek = new building("Bear Creek Apts", 400, 190, 39,
				false);
		buildings.add(39, bearcreek);
	}

	public Integer dice() {
		Random number = new Random();
		int randomInt = number.nextInt(5) + 1;
		return randomInt;
	}

	public void whosTurn() {
		if (a.checkTurn) {
			while (a.checkTurn) {
				if(buildings.get(a.reTurnLocation).returnOwned){
					a.addMoney(buildins.get(a.reTurnLocation).returnPenalty);
					endTurn();
				}
				else{
					endTurn();
				}
			}
		} else if (b.checkTurn) {
			while (b.checkTurn) {
				if(buildings.get(b.reTurnLocation).returnOwned){
					b.addMoney(buildins.get(b.reTurnLocation).returnPenalty);
					endTurn();
				}
				else{
					endTurn();
				}
			}
		} else if (c.checkTurn) {
			while (c.checkTurn) {
				if(buildings.get(c.reTurnLocation).returnOwned){
					c.addMoney(buildins.get(c.reTurnLocation).returnPenalty);
					endTurn();
				}
				else{
					endTurn();
				}
			}
		} else if (d.checkTurn) {
			while (d.checkTurn) {
				if(buildings.get(d.reTurnLocation).returnOwned){
					d.addMoney(buildins.get(d.reTurnLocation).returnPenalty);
					endTurn();
				}
				else{
					endTurn();
				}
			}
		}

	}
	
	public void endTurn(){
		if(a.checkTurn){
			a.turn = false;
			b.turn = true;
		}
		else if(b.checkTurn){
			b.turn = false;
			c.turn = true;
		}
		else if(c.checkTurn){
			c.turn = false;
			d.turn = true;
		}
		else if(d.checkTurn){
			d.turn = false;
			a.turn = true;
		}
	}
}
