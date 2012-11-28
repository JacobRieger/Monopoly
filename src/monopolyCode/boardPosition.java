package monopolyCode;

import java.util.ArrayList;

public class boardPosition {
	
	ArrayList<Integer> BoardValuesTop;
	ArrayList<Integer> BoardValuesLeft;
	

public boardPosition()
{
	BoardValuesTop = new ArrayList<Integer>();
	BoardValuesLeft = new ArrayList<Integer>();
}
	
public void SetBoardValues()
{
	Integer Top = 0;
	Integer Left = 0;
	
	for(int i = 0; i < 40; i++)
	{
		BoardValuesTop.add(i,Top);
		BoardValuesLeft.add(i,Left);
	}
}

public String getTop(Integer Top)
{
	return BoardValuesTop.get(Top).toString();
}

public String getLeft(Integer Left)
{
	return BoardValuesLeft.get(Left).toString();
}

	


}