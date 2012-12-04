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
	for(int i = 0; i < 40; i++)
	{
		BoardValuesTop.add(0);
		BoardValuesLeft.add(0);
	}
	
	BoardValuesTop.set(0, 510);
	BoardValuesLeft.set(0, 590);
	BoardValuesTop.set(1, 510);
	BoardValuesLeft.set(1, 530);
	BoardValuesTop.set(2, 510);
	BoardValuesLeft.set(2, 478);
	BoardValuesTop.set(3, 510);
	BoardValuesLeft.set(3, 426);
	BoardValuesTop.set(4, 510);
	BoardValuesLeft.set(4, 374);
	BoardValuesTop.set(5, 510);
	BoardValuesLeft.set(5, 322);
	BoardValuesTop.set(6, 510);
	BoardValuesLeft.set(6, 270);
	BoardValuesTop.set(7, 510);
	BoardValuesLeft.set(7, 218);
	BoardValuesTop.set(8, 510);
	BoardValuesLeft.set(8, 166);
	BoardValuesTop.set(9, 510);
	BoardValuesLeft.set(9, 114);
	BoardValuesTop.set(10, 510);
	BoardValuesLeft.set(10, 62);
	BoardValuesTop.set(11, 455);
	BoardValuesLeft.set(11, 30);
	BoardValuesTop.set(12, 410);
	BoardValuesLeft.set(12, 30);
	BoardValuesTop.set(13, 365);
	BoardValuesLeft.set(13, 30);
	BoardValuesTop.set(14, 320);
	BoardValuesLeft.set(14, 30);
	BoardValuesTop.set(15, 275);
	BoardValuesLeft.set(15, 30);
	BoardValuesTop.set(16, 228);
	BoardValuesLeft.set(16, 30);
	BoardValuesTop.set(17, 183);
	BoardValuesLeft.set(17, 30);
	BoardValuesTop.set(18, 138);
	BoardValuesLeft.set(18, 30);
	BoardValuesTop.set(19, 93);
	BoardValuesLeft.set(19, 30);
	BoardValuesTop.set(20, 48);
	BoardValuesLeft.set(20, 30);
	BoardValuesTop.set(21, 23);
	BoardValuesLeft.set(21, 114);
	BoardValuesTop.set(22, 23);
	BoardValuesLeft.set(22, 166);
	BoardValuesTop.set(23, 23);
	BoardValuesLeft.set(23, 218);
	BoardValuesTop.set(24, 23);
	BoardValuesLeft.set(24, 270);
	BoardValuesTop.set(25, 23);
	BoardValuesLeft.set(25, 322);
	BoardValuesTop.set(26, 23);
	BoardValuesLeft.set(26, 374);
	BoardValuesTop.set(27, 23);
	BoardValuesLeft.set(27, 426);
	BoardValuesTop.set(28, 23);
	BoardValuesLeft.set(28, 478);
	BoardValuesTop.set(29, 23);
	BoardValuesLeft.set(29, 530);
	BoardValuesTop.set(30, 23);
	BoardValuesLeft.set(30, 585);
	BoardValuesTop.set(31, 93);
	BoardValuesLeft.set(31, 585);
	BoardValuesTop.set(32, 138);
	BoardValuesLeft.set(32, 585);
	BoardValuesTop.set(33, 183);
	BoardValuesLeft.set(33, 585);
	BoardValuesTop.set(34, 228);
	BoardValuesLeft.set(34, 585);
	BoardValuesTop.set(35, 275);
	BoardValuesLeft.set(35, 585);
	BoardValuesTop.set(36, 320);
	BoardValuesLeft.set(36, 585);
	BoardValuesTop.set(37, 365);
	BoardValuesLeft.set(37, 585);
	BoardValuesTop.set(38, 410);
	BoardValuesLeft.set(38, 585);
	BoardValuesTop.set(39, 455);
	BoardValuesLeft.set(39, 585);
}

public String getTop(Integer Top)
{
	return BoardValuesTop.get(Top).toString();
}

public String getLeft(Integer Left)
{
	return BoardValuesLeft.get(Left).toString();
}

public String get2Top(Integer Top)
{
	Integer temp = BoardValuesTop.get(Top);
	return temp.toString();
}

public String get2Left(Integer Left)
{
	Integer temp = BoardValuesLeft.get(Left) + 20;
	return temp.toString();
	
}

public String get3Top(Integer Top)
{
	Integer temp = BoardValuesTop.get(Top)+20;
	return temp.toString();
}

public String get3Left(Integer Left)
{
	return BoardValuesLeft.get(Left).toString();
}

public String get4Top(Integer Top)
{
	Integer temp = BoardValuesTop.get(Top)+20;
	return temp.toString();
}

public String get4Left(Integer Left)
{
	Integer temp = BoardValuesLeft.get(Left)+20;
	return temp.toString();
}

}