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

	public monopoly() {
		dice = 0;
		buildings = new ArrayList<building>();
		
		building empty = new building("Empty", 0,0,0,5);
		
		for(int i = 0; i < 40; i++)
		{
			buildings.add(i, empty);
		}

		building start = new building("Go", 0, -200, 0, 5); // this is go, so
																// visiting
																// penalty is
																// negative
																// number,
																// giving people
																// who visits
		buildings.add(0, start);

		building bField = new building("Business Field", 60, 20, 1, 0);
		buildings.add(1, bField);

		// chest
		building.chest1 = new building("Chest1", 0, 0, 2, 0);
		buildings.add(2, chest1);

		building fField = new building("Farrand Field", 60, 20, 3, 0);
		buildings.add(3, fField);
		
		// parking permit
		building.parkingpermit = new building("parkingpermit", 200, 20, 4, 0);
		buildings.add(4, parkingpermit);
		
		// Jump
		building.jump = new building("jump", 200, 30, 5, 0);
		buildinds.add(5, jump);

		building Whealthcen = new building("Wardenburg Health Center", 100, 40,
				6, 0);
		buildings.add(6, Whealthcen);

		// chance
		building.chance1 = new building("chance1", 0, 0, 7, 0);
		buildings.add(7, chance1);

		building bookstore = new building("CU Bookstore", 100, 40, 8, 0);
		buildings.add(8, bookstore);

		building museum = new building("CU Art Museum", 120, 50, 9, 0);
		buildings.add(9, museum);
		
		//jail
		building jail = new building("jail", 0, 0, 10, 0);
		buildings.add(10, jail);

		building visit = new building("Just Visiting", 0, 0, 11, 5);
		buildings.add(11, visit);

		building mathlib = new building("Math Library", 140, 60, 12, 0);
		buildings.add(12, mathlib);

		// parking permit
		building buypermit = new building("buy permit", 150, 60, 13, 0);
		buildings.add(13, buypermit);

		building musiclib = new building("Music Library", 140, 60, 14, 0);
		buildings.add(14, musiclib);

		building norlinlib = new building("Norlin Library", 160, 70, 15, 0);
		buildings.add(15, norlinlib);

		// buffbus
		building buffbus = new building("buffbus", 200, 75, 16, 0);
		buildings.add(16, buffbus);

		building brackett = new building("Brackett Hall", 180, 80, 17, 0);
		buildings.add(17, brackett);

		// chest
		building chest2 = new building("chest2", 0, 0, 18, 0);
		buildings.add(18, chest2);
		

		building crosman = new building("Crosman Hall", 180, 80, 19, 0);
		buildings.add(19, crosman);

		building aden = new building("Aden Hall", 200, 90, 20, 0);
		buildings.add(20, aden);
		
		//free parking
		building freeparking = new building("free parking", 0, 0, 21, 0);
		buildings.add(21, freeparking);

		building c4c = new building("C4C", 220, 100, 22, 0);
		buildings.add(22, c4c);

		// chance
		building chance2 = new building("chance2", 0, 0, 23, 0);
		buildings.add(23, chance2);

		building fhall = new building("Farrand Hall", 220, 100, 24, 0);
		buildings.add(24, fhall);

		building lhall = new building("Libby Hall", 240, 110, 25, 0);
		buildings.add(25, lhall);

		// HOP
		building HOP = new builindg("HOP", 200, 115, 26, 0);
		buildings.add(26, HOP);

		building folsom = new building("Folsom Stadium", 260, 120, 27, 0);
		buildings.add(27, folsom);

		building coors = new building("Coors Event Center", 260, 120, 28, 0);
		buildings.add(28, coors);

		// motorcycle permit
		building mpermit = new building("motorcycle permit", 150, 125, 29, 0);
		buildings.add(29, mpermit);

		building reccenter = new building("Rec Center", 280, 130, 30, 0);
		buildings.add(30, reccenter);

		// Go TO
		building gotojail = new building("Go to jail", 0, 0, 31, 0);
		buildings.add(31, gotojail);

		building engine = new building("Engineering Center", 300, 140, 32,
				0);
		buildings.add(32, engine);

		building koelbel = new building("Koelbel Building", 300, 140, 33, 0);
		buildings.add(33, koelbel);

		// chest
		building chest3 - new building("chance3", 0, 0, 34, 0);
		buildings.add(34, chest3);

		building UMC = new building("University Memorial Center", 320, 150, 35,
				0);
		buildings.add(35, UMC);

		// stampede
		building stampede = new building("stampede", 200, 160, 36, 0);
		buildings.add(36, stampede);
		
		// chance
		building chance3 = new building("chance3", 0, 0, 37, 0);
		buildings.add(37, chance3);
		
		building willvil = new building("Williams Village", 350, 170, 38, 0);
		buildings.add(38, willvil);

		// parking ticket
		building parkingticket = new building("parking ticket", 120, 180, 39, 0);
		buildings.add(39, parkingticket);

		building bearcreek = new building("Bear Creek Apts", 400, 190, 40,
				0);
		buildings.add(40, bearcreek);
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
				if(buildings.get(a.returnLocation()).returnOwned()){//check if current a's location is owned property
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
				if(buildings.get(b.returnLocation()).returnOwned()){
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
				if(buildings.get(c.returnLocation()).returnOwned()){
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
				if(buildings.get(d.returnLocation()).returnOwned()){
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
	
	public void endTurn(){
		if(a.checkTurn()){
			a.set_status(false);
			b.set_status(true);
		}
		else if(b.checkTurn()){
			b.set_status(false);
			c.set_status(true);
		}
		else if(c.checkTurn()){
			c.set_status(false);
			d.set_status(true);
		}
		else if(d.checkTurn()){
			d.set_status(false);
			a.set_status(true);
		}
	}
	
	public player getCurrentPlayer()
	{
		if(a.checkTurn()) return a;
		if(b.checkTurn()) return b;
		if(c.checkTurn()) return c;
		if(d.checkTurn()) return d;
		
		System.out.println("Error in getCurrentPlayer");
		return a;
	}
	
	public void buyCurrentLocation()
	{
		player current = getCurrentPlayer();
		building currentb = buildings.get(current.returnLocation());
		Integer Price = currentb.buyPrice();
		
		
		if(!currentb.returnOwned() && current.returnMoney() > Price)
		{
			if(current.returnName() == "a")
			{
				currentb.changeProp(1);
			}
			if(current.returnName() == "b")
			{
				currentb.changeProp(2);
			}
			if(current.returnName() == "c")
			{
				currentb.changeProp(3);
			}
			if(current.returnName() == "d")
			{
				currentb.changeProp(4);
			}
			current.addMoney(Price);
			current.addBuilding(currentb);
		}
	}
	
	public ArrayList<building> returnBuildings()
	{
		return buildings;
	}
	
	public player getPlayera()
	{
		return a;
	}
	public player getPlayerb()
	{
		return b;
	}
	public player getPlayerc()
	{
		return c;
	}
	public player getPlayerd()
	{
		return d;
	}
	
	
	
}
