package monopolyCode;

public class background {
	
	private String imageFile;
	private String PlayerImage;
	
	
	public void set_image(String new_imageFile)
	{
		this.imageFile = new_imageFile;
	}
	
	public String get_image()
	{
		return imageFile;
	}
	
	public void set_player_image(String new_player_image)
	{
		this.PlayerImage = new_player_image;
	}
	
	public String get_player_image()
	{
		return PlayerImage;
	}
	
	public void createBoard()
	{
		this.set_image("monopoly-board.jpg");
		this.set_player_image("PlayerSpot.jpg");
	}
	

}
