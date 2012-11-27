<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="monopolyCode.MonopolyBoard" %>
<%@ page import="monopolyCode.background" %>
<%@ page import="monopolyCode.Dice" %>
<%@ page import="monopolyCode.player" %>
<%@ page import="monopolyCode.building" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Style-Type" content="text/css">
<style>

.Board{
	   position:absolute;
	   top:0px;
	   left:280px;
	   width:700px;
	   height:600px;
	   background-image:url(Monopoly_Images/monopoly-board.jpg);
}

.One {
	   position: absolute;
	   top:40px;
	   left:100px;
       width:200px; 
       height:200px; 
       background-image:url(Monopoly_Images/PlayerSpot.jpg);
 	 }

.Two {
 	   position:absolute;
 	   top:250px;
 	   left:100px;
 	   width:200px;
 	   height:200px;
 	   background-image: url(Monopoly_Images/PlayerSpot.jpg);
 	 }
 .Three{
 	   position:absolute;
 	   top:40px;
 	   left:950px;
 	   width:200px;
 	   height:200px;
 	   background-image: url(Monopoly_Images/PlayerSpot.jpg);
 }
 .Four{
 	   position:absolute;
 	   top:250px;
 	   left:950px;
 	   width:200px;
 	   height:200px;
 	   background-image: url(Monopoly_Images/PlayerSpot.jpg);
 }
 
 .PlayerName{
 	   position:relative;
 	   top:10px;
 	   left:10px;
 }
 
 .PlayerMoney{
 	   position:relative;
 	   top:135px;
 	   left:60px;
 }
 
 .Dice{
 	   position:absolute;
 
 }
 

</style>

<title>Monopoly</title>
</head>
<body>
<% 

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
//The next lines generate the HTML to display this card:

//Board
out.println("<div class=\"Board\"> </div>");
//Player1
out.println("<div class=\"One\"> <div class = \"PlayerName\"> Player 1 <div class=\"PlayerMoney\">" + player1.returnMoney().toString() + "</div> </div> </div>");
//Player2
out.println("<div class=\"Two\"> <div class = \"PlayerName\"> Player 2 <div class=\"PlayerMoney\">" + player2.returnMoney().toString() + "</div> </div> </div>");
//Player3
out.println("<div class=\"Three\"> <div class = \"PlayerName\"> Player 3 <div class=\"PlayerMoney\">" + player3.returnMoney().toString() + "</div> </div></div>");
//Player4
out.println("<div class=\"Four\"> <div class = \"PlayerName\"> Player 4 <div class=\"PlayerMoney\">" + player1.returnMoney().toString() + "</div> </div> </div>");

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