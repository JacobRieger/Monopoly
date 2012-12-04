<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="monopolyCode.MonopolyBoard" %>
<%@ page import="monopolyCode.background" %>
<%@ page import="monopolyCode.Dice" %>
<%@ page import="monopolyCode.player" %>
<%@ page import="monopolyCode.building" %>
<%@ page import="monopolyCode.boardPosition" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Style-Type" content="text/css">

<%//background Board = (background) request.getSession(true).getAttribute("board"); 

boardPosition Positioning = (boardPosition) request.getSession(true).getAttribute("positioning");
background Board = (background) request.getSession(true).getAttribute("board");
Dice ourDice = (Dice) request.getSession(true).getAttribute("dice");
player player1 = (player) request.getSession(true).getAttribute("player1");
player player2 = (player) request.getSession(true).getAttribute("player2");
player player3 = (player) request.getSession(true).getAttribute("player3");
player player4 = (player) request.getSession(true).getAttribute("player4");


if(Board == null)
{
	Board = new background();
	Board.createBoard();
}
if(Positioning == null)
{
	Positioning = new boardPosition();
	Positioning.SetBoardValues();
}
if(ourDice == null)
{
	ourDice = new Dice();
}

if(player1 == null)
{
	player1 = new player("Player One");	
	player2 = new player("Player Two");
	player3 = new player("Player Three");
	player4 = new player("Player Four");
}



request.getSession().setAttribute("board", Board);
request.getSession().setAttribute("dice", ourDice);
request.getSession().setAttribute("player1", player1);
request.getSession().setAttribute("player2", player2);
request.getSession().setAttribute("player3", player3);
request.getSession().setAttribute("player4", player4);

%>

<style>

.Board{
	   position:absolute;
	   top:0px;
	   left:280px;
	   width:700px;
	   height:600px;
	   z-index: 1;
	   background-image:url(Monopoly_Images/monopoly-board.jpg);
}

.One {
	   position: absolute;
	   top:40px;
	   left:100px;
       width:200px; 
       height:200px;
       z-index: 2;
       background-image:url(Monopoly_Images/PlayerSpot.jpg);
 	 }

.Two {
 	   position:absolute;
 	   top:250px;
 	   left:100px;
 	   width:200px;
 	   height:200px;
 	   z-index: 2;
 	   background-image: url(Monopoly_Images/PlayerSpot.jpg);
 	 }
 .Three{
 	   position:absolute;
 	   top:40px;
 	   left:950px;
 	   width:200px;
 	   height:200px;
 	   z-index: 2;
 	   background-image: url(Monopoly_Images/PlayerSpot.jpg);
 }
 .Four{
 	   position:absolute;
 	   top:250px;
 	   left:950px;
 	   width:200px;
 	   height:200px;
 	   z-index: 2;
 	   background-image: url(Monopoly_Images/PlayerSpot.jpg);
 }
 
 .playeronePos{
 	   position:absolute;
 	   top:<%out.println(Positioning.getTop(player1.returnLocation())+ "px;");%>
 	   left:<%out.println(Positioning.getLeft(player1.returnLocation())+ "px;");%>
 	   width:20px;
 	   height:20px;
 	   z-index:10;
 	   background-image: url(Monopoly_Images/One.png);
 }
 .playertwoPos{
  	   position:absolute;
  	   top:<%out.println(Positioning.get2Top(player2.returnLocation())+ "px;");%>
  	   left:<%out.println(Positioning.get2Left(player2.returnLocation())+ "px;");%>
  	   width:20px;
  	   height:20px;
  	   z-index:10;
  	   background-image: url(Monopoly_Images/Two.png);
 }
 
 .playerthreePos{
  	   position:absolute;
  	   top:<%out.println(Positioning.get3Top(player3.returnLocation())+ "px;");%>
  	   left:<%out.println(Positioning.get3Left(player3.returnLocation())+ "px;");%>
  	   width:20px;
  	   height:20px;
  	   z-index:10;
  	   background-image: url(Monopoly_Images/Three.png);
 }
 
 .playerfourPos{
  	   position:absolute;
  	   top:<%out.println(Positioning.get4Top(player4.returnLocation())+ "px;");%>
  	   left:<%out.println(Positioning.get4Left(player4.returnLocation())+ "px;");%>
  	   width:20px;
  	   height:20px;
  	   z-index:10;
  	   background-image: url(Monopoly_Images/Four.png);
 }
 
 .PlayerName{
 	   position:relative;
 	   top:133px;
 	   left:70px;
 }
 
 
 .PlayerMoney{
 	   position:relative;
 	   top:144px;
 	   left:70px;
 }
 
 .Dice{
 	   position:relative;
 	   top:100px;
 	   left:300px;
 }
 
 

 }
 

</style>

<title>Monopoly</title>
</head>
<body>
<% 


//The next lines generate the HTML to display this card:

//Board
out.println("<div class=\"Board\">");
out.println("<div class=\"Dice\">" + ourDice.get_Die1()+ "|||" + ourDice.get_Die2() + "</div>");
out.println("<div class=\"playeronePos\"> </div>");
out.println("<div class=\"playertwoPos\"> </div>");
out.println("<div class=\"playerthreePos\"> </div>");
out.println("<div class=\"playerfourPos\"> </div>");
out.println("</div>");
//Player1
out.println("<div class=\"One\">");
out.println("<div class = \"PlayerName\">" + player1.returnName() + "</div>");
out.println("<div class=\"PlayerMoney\">" + player1.returnMoney().toString() + " </div>");
out.println("</div>");
//Player2
out.println("<div class=\"Two\">");
out.println("<div class = \"PlayerName\">" + player2.returnName() + "</div>");
out.println("<div class=\"PlayerMoney\">" + player2.returnMoney().toString() + " </div>");
out.println("</div>");
//Player3
out.println("<div class=\"Three\">");
out.println("<div class = \"PlayerName\">" + player3.returnName() + "</div>");
out.println("<div class=\"PlayerMoney\">" + player3.returnMoney().toString() + " </div>");
out.println("</div>");
//Player4
out.println("<div class=\"Four\">");
out.println("<div class = \"PlayerName\">" + player4.returnName() + "</div>");
out.println("<div class=\"PlayerMoney\">" + player4.returnMoney().toString() + " </div>");
out.println("</div>");
String diceroll = ourDice.return_total().toString();


/*
out.println("Player One Position");
out.println(player1.returnLocation());
out.println("Die:");
out.println(ourDice.get_Die1().toString());
out.println("Die:");
out.println(ourDice.get_Die2().toString());
*/
%>

<FORM action="/Monopoly/DiceServlet" method="post">
<br>
<INPUT type="submit" name="Submit" value="Roll Dice">
</FORM>



</body>
</html>