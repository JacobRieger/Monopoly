package monopolyCode;

import java.util.ArrayList;

public class player {

	private Integer money;
	private Integer currentLocation;
	private String playerName;
	private ArrayList<building> landProperty;
	private ArrayList<Integer> treasureProperty;
	private Integer netAsset;
	private Boolean jail;
	public player(String pName) {
		money = 2000;
		currentLocation = 0;
		playerName = pName;
		landProperty = new ArrayList<building>();
		treasureProperty = new ArrayList<Integer>();
		netAsset = money;
	}
	

	public Integer returnMoney() {
		return money;
	}

	public Integer returnLocation() {
		return currentLocation;
	}

	public String returnName() {
		return playerName;
	}

	public Integer returnAsset() {
		return netAsset;
	}
	
	public void incrementLocation(Integer diceroll)
	{
		if(diceroll + this.currentLocation < 39)
		{
			this.currentLocation = this.currentLocation + diceroll;
		}
		else
		{
			for(int i = 0; i < diceroll; i++)
			{
				if(this.currentLocation == 39)
				{
					this.currentLocation = 0;
				}
				else
				{
					this.currentLocation = this.currentLocation + 1;
				}
			}
		}
	}

	public Boolean pOwned(Integer location) {

		if (landProperty.contains(location)) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean tOwned(Integer number){
		if(treasureProperty.contains(number)){
			return true;
		}
		else{
			return false;
		}
	}
	public Boolean isJail(){
		if(jail){
			return true;
		}
		else {
			return false;
		}
	}

}
