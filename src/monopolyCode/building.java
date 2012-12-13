package monopolyCode;



public class building {
	private String buildingName;
	private Integer buildingNode;
	private Integer buyPrice;
	private Integer nobels;
	private Integer visitorPrice;
	private Integer prop;
	private Boolean owned;
	public building(String name, Integer initialPrice, Integer vPrice, Integer node, Integer Prop){
		buildingName = name;
		buyPrice = initialPrice;
		nobels = 0; //max 3
		visitorPrice = vPrice;
		buildingNode = node;
		prop = Prop;
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
	
	public boolean returnOwned()
	{
		return owned;
	}
	
	public Integer buyPrice()
	{
		return buyPrice;
	}
	
	public String returnName()
	{
		return buildingName;
	}
}
