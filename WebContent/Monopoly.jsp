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
.Mboard
{
display: block;
    margin-left: auto;
    margin-right: auto
} 
.Player1
{
display: block;
	margin-left: auto;
	margin-right: auto;
}
img {width:600px;}
</style>

<title>Monopoly</title>
</head>
<body>
<% 

background Board = (background) request.getSession(true).getAttribute("board");
Dice ourDice = (Dice) request.getSession(true).getAttribute("dice");
player player1 = (player) request.getSession(true).getAttribute("player1");

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
}



request.getSession().setAttribute("board", Board);
request.getSession().setAttribute("dice", ourDice);
request.getSession().setAttribute("player1", player1);

//The next lines generate the HTML to display this card:


out.println("<IMG STYLE=\"position: absolute;TOP:0px;LEFT:280px;WIDTH:700px;HEIGHT:600px\" SRC=\"Monopoly_Images/" + Board.get_image() + "\"/>");
//Player1
out.println("<IMG STYLE=\"position: absolute;TOP:40px;LEFT:100px;WIDTH:200px;HEIGHT:200px\" SRC=\"Monopoly_Images/" + Board.get_player_image() + "\"/>");
//Player2
out.println("<IMG STYLE=\"position: absolute;TOP:250px;LEFT:100px;WIDTH:200px;HEIGHT:200px\" SRC=\"Monopoly_Images/" + Board.get_player_image() + "\"/>");
//Player3
out.println("<IMG STYLE=\"position: absolute;TOP:40px;LEFT:950px;WIDTH:200px;HEIGHT:200px\" SRC=\"Monopoly_Images/" + Board.get_player_image() + "\"/>");
//Player4
out.println("<IMG STYLE=\"position: absolute;TOP:250px;LEFT:950px;WIDTH:200px;HEIGHT:200px\" SRC=\"Monopoly_Images/" + Board.get_player_image() + "\"/>");
String diceroll = ourDice.return_total().toString();

out.println("Player One Position");
out.println(player1.returnLocation());
out.println("Die:");
out.println(ourDice.get_Die1().toString());
out.println("Die:");
out.println(ourDice.get_Die2().toString());

%>

<FORM action="/Monopoly/DiceServlet" method="post">
<br>
<INPUT type="submit" name="Submit" value="Roll Dice">
</FORM>



</body>
</html>