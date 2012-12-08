package monopolyCode;



public class building {
	private String buildingName;
	private Integer buildingNode;
	private Integer buyPrice;
	private Integer nobels;
	private Integer visitorPrice;
	private Boolean owned;
	public building(String name, Integer initialPrice, Integer vPrice, Integer node, Integer prop){
		buildingName = name;
		buyPrice = initialPrice;
		nobels = 0; //max 3
		visitorPrice = vPrice;
		buildingNode = node;
		if(prop == 0){
		owned = false;
		}
		else{
			owned = true;
		}
	}

	public void getnobel(){
		nobels++;
		visitorPrice = visitorPrice + 50;
	}
	
	public Integer returnWhoOwn(){
		return prop; // 1 = a; 2 = b; 3 = c; 4 = d; 5 = neutral
	}
	
	public void changeProp(Integer who){
		prop = who;
		owned = true;
	}
	
	public Integer returnPenalty(){
		return visitorPrice;
	}
}
