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
																// here money.
		buildings.add(0, start);

		building bField = new building("Business Field", 60, 20, 1, 0);
		buildings.add(1, bField);

		// chest

		building fField = new building("Farrand Field", 60, 20, 3, 0);
		buildings.add(3, fField);
		
		// parking permit
		
		// Jump

		building Whealthcen = new building("Wardenburg Health Center", 100, 40,
				6, 0);
		buildings.add(6, Whealthcen);

		// chance

		building bookstore = new building("CU Bookstore", 100, 40, 8, 0);
		buildings.add(8, bookstore);

		building museum = new building("CU Art Museum", 120, 50, 9, 0);
		buildings.add(9, museum);

		building visit = new building("Just Visiting", 0, 0, 10, 5);
		buildings.add(10, visit);

		building mathlib = new building("Math Library", 140, 60, 11, 0);
		buildings.add(11, mathlib);

		// parking permit

		building musiclib = new building("Music Library", 140, 60, 13, 0);
		buildings.add(13, musiclib);

		building norlinlib = new building("Norlin Library", 160, 70, 14, 0);
		buildings.add(14, norlinlib);

		// buffbus

		building brackett = new building("Brackett Hall", 180, 80, 16, 0);
		buildings.add(16, brackett);

		// chance

		building crosman = new building("Crosman Hall", 180, 80, 18, 0);
		buildings.add(18, crosman);

		building aden = new building("Aden Hall", 200, 90, 19, 0);
		buildings.add(19, aden);

		building c4c = new building("C4C", 220, 100, 20, 0);
		buildings.add(20, c4c);

		// chance

		building fhall = new building("Farrand Hall", 220, 100, 22, 0);
		buildings.add(22, fhall);

		building lhall = new building("Libby Hall", 240, 110, 23, 0);
		buildings.add(23, lhall);

		// HOP

		building folsom = new building("Folsom Stadium", 260, 120, 25, 0);
		buildings.add(26, folsom);

		building coors = new building("Coors Event Center", 260, 120, 26, 0);
		buildings.add(27, coors);

		// motorcycle permit

		building reccenter = new building("Rec Center", 280, 130, 29, 0);
		buildings.add(29, reccenter);

		// Go TO

		building engine = new building("Engineering Center", 300, 140, 31,
				0);
		buildings.add(31, engine);

		building koelbel = new building("Koelbel Building", 300, 140, 32, 0);
		buildings.add(32, koelbel);

		// chest

		building UMC = new building("University Memorial Center", 320, 150, 34,
				0);
		buildings.add(34, UMC);

		// stampede
		// chance

		building willvil = new building("Williams Village", 350, 170, 37, 0);
		buildings.add(37, willvil);

		// parking ticket

		building bearcreek = new building("Bear Creek Apts", 400, 190, 39,
				0);
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
