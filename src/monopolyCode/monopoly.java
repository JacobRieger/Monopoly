package monopolyCode;

import java.util.ArrayList;
import java.util.Random;

public class monopoly {

	private player a = new player("a", true);
	private player b = new player("b", false);
	private player c = new player("c", false);
	private player d = new player("d", false);
	private Integer dice;
	private ArrayList<building> buildings;
	private boolean chance = false;
	private boolean treasure = false;

	public monopoly() {
		dice = 0;
		buildings = new ArrayList<building>();

		building empty = new building("Empty", 0, 0, 0, 5);

		for (int i = 0; i < 40; i++) {
			buildings.add(i, empty);
		}

		building start = new building("Go", 0, 0, 0, 5); //Changed Go, so people only
														    //get money when passing, not landing on it
		buildings.add(0, start);

		building bField = new building("Business Field", 60, 20, 1, 0);
		buildings.add(1, bField);

		// chest
		building chest1 = new building("Chest1", 0, 0, 2, 5);
		buildings.add(2, chest1);

		building fField = new building("Farrand Field", 60, 20, 3, 0);
		buildings.add(3, fField);

		// parking permit
		building parkingpermit = new building("parkingpermit", 200, 20, 4, 0);
		buildings.add(4, parkingpermit);

		// Jump
		building jump = new building("jump", 200, 30, 5, 0);
		buildings.add(5, jump);

		building Whealthcen = new building("Wardenburg Health Center", 100, 40,
				6, 0);
		buildings.add(6, Whealthcen);

		// chance
		building chance1 = new building("chance1", 0, 0, 7, 5);
		buildings.add(7, chance1);

		building bookstore = new building("CU Bookstore", 100, 40, 8, 0);
		buildings.add(8, bookstore);

		building museum = new building("CU Art Museum", 120, 50, 9, 0);
		buildings.add(9, museum);

		// jail
		// building jail = new building("jail", 0, 0, 10, 5);
		// buildings.add(10, jail);

		building visit = new building("Just Visiting", 0, 0, 11, 5);
		buildings.add(10, visit);

		building mathlib = new building("Math Library", 140, 60, 11, 0);
		buildings.add(11, mathlib);

		// parking permit
		building buypermit = new building("buy permit", 150, 60, 12, 0);
		buildings.add(12, buypermit);

		building musiclib = new building("Music Library", 140, 60, 13, 0);
		buildings.add(13, musiclib);

		building norlinlib = new building("Norlin Library", 160, 70, 14, 0);
		buildings.add(14, norlinlib);

		// buffbus
		building buffbus = new building("buffbus", 200, 75, 15, 0);
		buildings.add(15, buffbus);

		building brackett = new building("Brackett Hall", 180, 80, 16, 0);
		buildings.add(16, brackett);

		// chest
		building chest2 = new building("chest2", 0, 0, 17, 5);
		buildings.add(17, chest2);

		building crosman = new building("Crosman Hall", 180, 80, 18, 0);
		buildings.add(18, crosman);

		building aden = new building("Aden Hall", 200, 90, 19, 0);
		buildings.add(19, aden);

		// free parking
		building freeparking = new building("free parking", 0, 0, 20, 5);
		buildings.add(20, freeparking);

		building c4c = new building("C4C", 220, 100, 21, 0);
		buildings.add(21, c4c);

		// chance
		building chance2 = new building("chance2", 0, 0, 22, 5);
		buildings.add(22, chance2);

		building fhall = new building("Farrand Hall", 220, 100, 23, 0);
		buildings.add(23, fhall);

		building lhall = new building("Libby Hall", 240, 110, 24, 0);
		buildings.add(24, lhall);

		// HOP
		building HOP = new building("HOP", 200, 115, 25, 0);
		buildings.add(25, HOP);

		building folsom = new building("Folsom Stadium", 260, 120, 26, 0);
		buildings.add(26, folsom);

		building coors = new building("Coors Event Center", 260, 120, 27, 0);
		buildings.add(27, coors);

		// motorcycle permit
		building mpermit = new building("motorcycle permit", 150, 125, 28, 0);
		buildings.add(28, mpermit);

		building reccenter = new building("Rec Center", 280, 130, 29, 0);
		buildings.add(29, reccenter);

		// Go TO
		building gotojail = new building("Go to jail", 0, 0, 30, 5);
		buildings.add(30, gotojail);

		building engine = new building("Engineering Center", 300, 140, 31, 0);
		buildings.add(31, engine);

		building koelbel = new building("Koelbel Building", 300, 140, 32, 0);
		buildings.add(32, koelbel);

		// chest
		building chest3 = new building("chest3", 0, 0, 33, 5);
		buildings.add(33, chest3);

		building UMC = new building("University Memorial Center", 320, 150, 34,
				0);
		buildings.add(34, UMC);

		// stampede
		building stampede = new building("stampede", 200, 160, 35, 0);
		buildings.add(35, stampede);

		// chance
		building chance3 = new building("chance3", 0, 0, 36, 5);
		buildings.add(36, chance3);

		building willvil = new building("Williams Village", 350, 170, 37, 0);
		buildings.add(37, willvil);

		// parking ticket
		building parkingticket = new building("parking ticket", 120, 180, 38, 5);
		buildings.add(38, parkingticket);

		building bearcreek = new building("Bear Creek Apts", 400, 190, 39, 0);
		buildings.add(39, bearcreek);
	}

	public Integer dice() {
		Random number = new Random();
		int randomInt = number.nextInt(5) + 1;
		return randomInt;
	}

	public void whosTurn() {
		if (a.checkTurn()) {//check whos turn it is
			if(a.isJail())
			{
				endTurn();
			}
			else{
			while (a.checkTurn()) {//when a's turn is not over
				if(a.returnLocation() == 30)//jail system
				{
					a.OopsJail();
				}
				else if(a.returnLocation() == 2 || a.returnLocation() == 17 || a.returnLocation() == 33)//treasure
				{
					System.out.println("Inside WhosTurn");
					Integer luck;
					luck = dice();
					if(luck == 1)
					{
						a.recieveMoney(200);
					}
					else if(luck == 2)
					{
						a.addMoney(150);
					}
					else if(luck == 3)
					{
						a.recieveMoney(300);
						b.addMoney(100);
						c.addMoney(100);
						d.addMoney(100);
					}
					else if(luck == 4)
					{
						a.addMoney(150);
						b.recieveMoney(150);
					}
					else if(luck == 5)
					{
						a.addMoney(150);
						c.recieveMoney(150);
					}
					else if(luck == 6)
					{
						a.addMoney(150);
						d.recieveMoney(150);
					}
					treasure = true;
					endTurn();
				}
				else if(a.returnLocation() == 7 || a.returnLocation() == 22 || a.returnLocation() == 36)//chance
				{
					Integer luck;
					luck = dice();
					if(luck == 1)
					{
						a.switchMoney(b);
					}
					else if(luck == 2)
					{
						a.switchMoney(c);
					}
					else if(luck == 3)
					{
						a.switchMoney(d);
					}
					else if(luck == 4)
					{
						a.OopsJail();
					}
					else if(luck == 5)
					{
						a.incrementLocation(2);
					}
					else if(luck == 6)
					{
						a.incrementLocation(-2);
					}
					chance = true;
					endTurn();
				}
				else if(buildings.get(a.returnLocation()).returnOwned()){//check if current a's location is owned property
					a.addMoney(buildings.get(a.returnLocation()).returnPenalty()); //a sends in money
					//then gives the money to whoever that owns the property.
					if(buildings.get(a.returnLocation()).returnWhoOwn() == 1){
						a.recieveMoney(buildings.get(a.returnLocation()).returnPenalty());
					}
					else if(buildings.get(a.returnLocation()).returnWhoOwn() == 2){
						b.recieveMoney(buildings.get(a.returnLocation()).returnPenalty());
					}
					else if(buildings.get(a.returnLocation()).returnWhoOwn() == 3){
						c.recieveMoney(buildings.get(a.returnLocation()).returnPenalty());
					}
					else if(buildings.get(a.returnLocation()).returnWhoOwn() == 4){
						d.recieveMoney(buildings.get(a.returnLocation()).returnPenalty());
					}
					
					if(a.checkBroke()){
						a.gameover();
					}
					
					endTurn();
				}
				else if(!buildings.get(a.returnLocation()).returnOwned()){
					//if property is not owned
					
					//we need button to give choice to player if they want to buy the property
					
					endTurn();
				}
			}
			}
		} else if (b.checkTurn()) {
			if(b.isJail())
			{
				endTurn();
			}
			else{
			while (b.checkTurn()) {
				if(b.returnLocation() == 30)
				{
					b.OopsJail();
				}
				else if(b.returnLocation() == 2 || b.returnLocation() == 17 || b.returnLocation() == 33)
				{
					Integer luck;
					luck = dice();
					if(luck == 1)
					{
						b.recieveMoney(200);
					}
					else if(luck == 2)
					{
						b.addMoney(150);
					}
					else if(luck == 3)
					{
						b.recieveMoney(300);
						a.addMoney(100);
						c.addMoney(100);
						d.addMoney(100);
					}
					else if(luck == 4)
					{
						b.addMoney(150);
						a.recieveMoney(150);
					}
					else if(luck == 5)
					{
						b.addMoney(150);
						c.recieveMoney(150);
					}
					else if(luck == 6)
					{
						b.addMoney(150);
						d.recieveMoney(150);
					}
					treasure = true;
					endTurn();
				}
				else if(b.returnLocation() == 7 || b.returnLocation() == 22 || b.returnLocation() == 36)
				{
					Integer luck;
					luck = dice();
					if(luck == 1)
					{
						b.switchMoney(a);
					}
					else if(luck == 2)
					{
						b.switchMoney(c);
					}
					else if(luck == 3)
					{
						b.switchMoney(d);
					}
					else if(luck == 4)
					{
						b.OopsJail();
					}
					else if(luck == 5)
					{
						b.incrementLocation(2);
					}
					else if(luck == 6)
					{
						b.incrementLocation(-2);
					}
					chance = true;
					endTurn();
				}
			else if(buildings.get(b.returnLocation()).returnOwned()){
					b.addMoney(buildings.get(b.returnLocation()).returnPenalty());
					if(buildings.get(b.returnLocation()).returnWhoOwn() == 1){
						a.recieveMoney(buildings.get(b.returnLocation()).returnPenalty());
					}
					else if(buildings.get(b.returnLocation()).returnWhoOwn() == 2){
						b.recieveMoney(buildings.get(b.returnLocation()).returnPenalty());
					}
					else if(buildings.get(b.returnLocation()).returnWhoOwn() == 3){
						c.recieveMoney(buildings.get(b.returnLocation()).returnPenalty());
					}
					else if(buildings.get(b.returnLocation()).returnWhoOwn() == 4){
						d.recieveMoney(buildings.get(b.returnLocation()).returnPenalty());
					}
					
					if(b.checkBroke()){
						b.gameover();
					}
					endTurn();
				}
				else{
					endTurn();
				}
			}
			}
		} else if (c.checkTurn()) {
			if(c.isJail())
			{
				endTurn();
			}
			else{
			while (c.checkTurn()) {

				if(c.returnLocation() == 30)
				{
					c.OopsJail();
				}
				else if(c.returnLocation() == 2 || c.returnLocation() == 17 || c.returnLocation() == 33)
				{
					Integer luck;
					luck = dice();
					if(luck == 1)
					{
						c.recieveMoney(200);
					}
					else if(luck == 2)
					{
						c.addMoney(150);
					}
					else if(luck == 3)
					{
						c.recieveMoney(300);
						b.addMoney(100);
						a.addMoney(100);
						d.addMoney(100);
					}
					else if(luck == 4)
					{
						c.addMoney(150);
						b.recieveMoney(150);
					}
					else if(luck == 5)
					{
						c.addMoney(150);
						a.recieveMoney(150);
					}
					else if(luck == 6)
					{
						c.addMoney(150);
						d.recieveMoney(150);
					}
					treasure = true;
					endTurn();
				}
				else if(c.returnLocation() == 7 || c.returnLocation() == 22 || c.returnLocation() == 36)
				{
					Integer luck;
					luck = dice();
					if(luck == 1)
					{
						c.switchMoney(b);
					}
					else if(luck == 2)
					{
						c.switchMoney(a);
					}
					else if(luck == 3)
					{
						c.switchMoney(d);
					}
					else if(luck == 4)
					{
						c.OopsJail();
					}
					else if(luck == 5)
					{
						c.incrementLocation(2);
					}
					else if(luck == 6)
					{
						c.incrementLocation(-2);
					}
					chance = true;
					endTurn();
				}
			else if(buildings.get(c.returnLocation()).returnOwned()){
					c.addMoney(buildings.get(c.returnLocation()).returnPenalty());
					if(buildings.get(c.returnLocation()).returnWhoOwn() == 1){
						a.recieveMoney(buildings.get(c.returnLocation()).returnPenalty());
					}
					else if(buildings.get(c.returnLocation()).returnWhoOwn() == 2){
						b.recieveMoney(buildings.get(c.returnLocation()).returnPenalty());
					}
					else if(buildings.get(c.returnLocation()).returnWhoOwn() == 3){
						c.recieveMoney(buildings.get(c.returnLocation()).returnPenalty());
					}
					else if(buildings.get(c.returnLocation()).returnWhoOwn() == 4){
						d.recieveMoney(buildings.get(c.returnLocation()).returnPenalty());
					}
					if(c.checkBroke()){
						c.gameover();
					}
					endTurn();
				}
				else{
					endTurn();
				}
			}
			}
		} else if (d.checkTurn()) {
			if(d.isJail())
			{
				endTurn();
			}
			else{
			while (d.checkTurn()) {
	
				if(d.returnLocation() == 30)
				{
					d.OopsJail();
				}
				else if(d.returnLocation() == 2 || d.returnLocation() == 17 || d.returnLocation() == 33)
				{
					Integer luck;
					luck = dice();
					if(luck == 1)
					{
						d.recieveMoney(200);
					}
					else if(luck == 2)
					{
						d.addMoney(150);
					}
					else if(luck == 3)
					{
						d.recieveMoney(300);
						b.addMoney(100);
						c.addMoney(100);
						a.addMoney(100);
					}
					else if(luck == 4)
					{
						d.addMoney(150);
						b.recieveMoney(150);
					}
					else if(luck == 5)
					{
						d.addMoney(150);
						c.recieveMoney(150);
					}
					else if(luck == 6)
					{
						d.addMoney(150);
						a.recieveMoney(150);
					}
					treasure = true;
					endTurn();
				}
				else if(d.returnLocation() == 7 || d.returnLocation() == 22 || d.returnLocation() == 36)
				{
					Integer luck;
					luck = dice();
					if(luck == 1)
					{
						d.switchMoney(b);
					}
					else if(luck == 2)
					{
						d.switchMoney(c);
					}
					else if(luck == 3)
					{
						d.switchMoney(a);
					}
					else if(luck == 4)
					{
						d.OopsJail();
					}
					else if(luck == 5)
					{
						d.incrementLocation(2);
					}
					else if(luck == 6)
					{
						d.incrementLocation(-2);
					}
					chance = true;
					endTurn();
				}
				else if(buildings.get(d.returnLocation()).returnOwned()){
					d.addMoney(buildings.get(d.returnLocation()).returnPenalty());
					if(buildings.get(d.returnLocation()).returnWhoOwn() == 1){
						a.recieveMoney(buildings.get(d.returnLocation()).returnPenalty());
					}
					else if(buildings.get(c.returnLocation()).returnWhoOwn() == 2){
						b.recieveMoney(buildings.get(d.returnLocation()).returnPenalty());
					}
					else if(buildings.get(c.returnLocation()).returnWhoOwn() == 3){
						c.recieveMoney(buildings.get(d.returnLocation()).returnPenalty());
					}
					else if(buildings.get(c.returnLocation()).returnWhoOwn() == 4){
						d.recieveMoney(buildings.get(d.returnLocation()).returnPenalty());
					}
					if(d.checkBroke()){
						d.gameover();
					}
					endTurn();
				}
				else{
					endTurn();
				}
			}
			}
		}

	}

	public void endTurn() {
		if (a.checkTurn()) {
			a.set_status(false);
			b.set_status(true);
		} else if (b.checkTurn()) {
			b.set_status(false);
			c.set_status(true);
		} else if (c.checkTurn()) {
			c.set_status(false);
			d.set_status(true);
		} else if (d.checkTurn()) {
			d.set_status(false);
			a.set_status(true);
		}
	}

	public player getCurrentPlayer() {
		if (a.checkTurn())
			return a;
		if (b.checkTurn())
			return b;
		if (c.checkTurn())
			return c;
		if (d.checkTurn())
			return d;

		System.out.println("Error in getCurrentPlayer");
		return a;
	}

	public void buyCurrentLocation() {
		player current = getCurrentPlayer();
		building currentb = buildings.get(current.returnLocation());
		Integer Price = currentb.buyPrice();

		if (!currentb.returnOwned() && current.returnMoney() > Price) {
			if (current.equals(this.getPlayera())) {
				currentb.changeProp(1);
			}
			if (current.equals(this.getPlayerb())) {
				currentb.changeProp(2);
			}
			if (current.equals(this.getPlayerc())) {
				currentb.changeProp(3);
			}
			if (current.equals(this.getPlayerd())) {
				currentb.changeProp(4);
			}
			current.addMoney(Price);
			current.addBuilding(currentb);
		}
	}

	public void ChangeCurrentPlayerName(String newName) {
		player current = this.getCurrentPlayer();

		current.setName(newName);
	}

	public ArrayList<building> returnBuildings() {
		return buildings;
	}

	public player getPlayera() {
		return a;
	}

	public player getPlayerb() {
		return b;
	}

	public player getPlayerc() {
		return c;
	}

	public player getPlayerd() {
		return d;
	}
	
	public void setChance(boolean set)
	{
		chance = set;
	}
	
	public void setTreasure(boolean set)
	{
		treasure = set;
	}
	
	public boolean getChance()
	{
		return chance;
	}
	
	public boolean getTreasure()
	{
		return treasure;
	}

}
