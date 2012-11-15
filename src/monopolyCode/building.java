package monopolyCode;



public class building {
	private String buildingName;
	private Integer buildingNode;
	private Integer buyPrice;
	private Integer nobels;
	private Integer visitorPrice;
	private Boolean owned;
	public building(String name, Integer initialPrice, Integer vPrice, Integer node, boolean prop){
		buildingName = name;
		buyPrice = initialPrice;
		nobels = 0; //max 3
		visitorPrice = vPrice;
		buildingNode = node;
		owned = prop;
	}

	public void getnobel(){
		nobels++;
		visitorPrice = visitorPrice + 50;
	}
	
	
}
