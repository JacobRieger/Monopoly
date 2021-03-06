<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="monopolyCode.monopoly" %>
<%@ page import="monopolyCode.background" %>
<%@ page import="monopolyCode.player" %>
<%@ page import="monopolyCode.building" %>
<%@ page import="monopolyCode.boardPosition" %>
<%@ page import="monopolyCode.MonopolyBoard" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Style-Type" content="text/css">

<%//background Board = (background) request.getSession(true).getAttribute("board"); 

boardPosition Positioning = (boardPosition) request.getSession(true).getAttribute("positioning");
background Board = (background) request.getSession(true).getAttribute("board");
monopoly ourgame = (monopoly) request.getSession(true).getAttribute("ourgame");


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
if(ourgame == null)
{
	ourgame = new monopoly();
	
}




request.getSession().setAttribute("board", Board);
request.getSession().setAttribute("ourgame", ourgame);

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
 	   top:<%out.println(Positioning.getTop(ourgame.getPlayera().returnLocation())+ "px;");%>
 	   left:<%out.println(Positioning.getLeft(ourgame.getPlayera().returnLocation())+ "px;");%>
 	   width:20px;
 	   height:20px;
 	   z-index:2;
 	   background-image: url(Monopoly_Images/One.png);
 }
 .playertwoPos{
  	   position:absolute;
  	   top:<%out.println(Positioning.get2Top(ourgame.getPlayerb().returnLocation())+ "px;");%>
  	   left:<%out.println(Positioning.get2Left(ourgame.getPlayerb().returnLocation())+ "px;");%>
  	   width:20px;
  	   height:20px;
  	   z-index:2;
  	   background-image: url(Monopoly_Images/Two.png);
 }
 
 .playerthreePos{
  	   position:absolute;
  	   top:<%out.println(Positioning.get3Top(ourgame.getPlayerc().returnLocation())+ "px;");%>
  	   left:<%out.println(Positioning.get3Left(ourgame.getPlayerc().returnLocation())+ "px;");%>
  	   width:20px;
  	   height:20px;
  	   z-index:2;
  	   background-image: url(Monopoly_Images/Three.png);
 }
 
 .playerfourPos{
  	   position:absolute;
  	   top:<%out.println(Positioning.get4Top(ourgame.getPlayerd().returnLocation())+ "px;");%>
  	   left:<%out.println(Positioning.get4Left(ourgame.getPlayerd().returnLocation())+ "px;");%>
  	   width:20px;
  	   height:20px;
  	   z-index:2;
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
 	   z-index = 3;
 }
 .RollDice{
 	   position:relative;
 	   top:120px;
 	   left:300px;
 }
 
 .SetNames{
 	   position:relative;
 	   top:400px;
 	   left:700px;
 
 }
 
 .BuildingsList{
 	   position:absolute;
 	   top:100px;
 	   left:1150px;
 	   z-index = 15;
 	   background-image: url(Monopoly_Images/ListBackground.jpeg);
 
 }
 
 .BuildingsButton{
 	   position:relative;
 	   top:-50px;
 	   left:5px;
 
 }
 
 .Chatlog{
 	   position:relative;
 	   top:100px;
 	   left:250px;
 }
 
 

 }
 

</style>

<title>Monopoly</title>
</head>
<body>
<% 

//Our Board div starts here
out.println("<div class=\"Board\">");
out.println("<div class=\"Dice\">" +  "Current Player is " + ourgame.getCurrentPlayer().returnName() + "</div>");
if(ourgame.getChance())
{
	out.println("<div class=\"Chatlog\">" + ourgame.getChatlog() + "</div>");
	ourgame.setChance(false);
}
if(ourgame.getTreasure())
{
	out.println("<div class=\"Chatlog\">" + ourgame.getChatlog() +  "</div>");
	ourgame.setTreasure(false);
}
out.println("<div class=\"RollDice\">");
//Code that decides whether or not to show the Buy button
if(!ourgame.returnBuildings().get(ourgame.getCurrentPlayer().returnLocation()).returnOwned())
{
	out.println("<FORM action=\"/Monopoly/BuycurrentServlet\" method=\"post\">");
	out.println("<br>");
	out.println("<INPUT type=\"submit\" name=\"Submit\" value= \"BUY PROPERTY\">");
	out.println("</FORM>");
}
//Code that decides whether or not to show the RollDice button
if(!ourgame.getCurrentPlayer().hasRolled())
{
	out.println("<FORM action=\"/Monopoly/DiceServlet\" method=\"post\">");
	out.println("<br>");
	out.println("<INPUT type=\"submit\" name=\"Submit\" value= \"Roll Dice\">");
	out.println("</FORM>");
}
else
{
	//If you can't roll or buy, you can only end your turn
	out.println("<FORM action=\"/Monopoly/EndturnServlet\" method=\"post\">");
	out.println("<br>");
	out.println("<INPUT type=\"submit\" name=\"Submit\" value= \"End Turn\">");
	out.println("</FORM>");
}

out.println("</div>");

out.println("<div class=\"SetNames\">");
if(!ourgame.getPlayera().returnSetName())
{
	out.println("<form name=\"input\" action=\"/Monopoly/ChangeNameServlet\" method=\"get\">");
	out.println("Player1: <input type=\"text\" name=\"user1\">");
	out.println("<input type=\"submit\" value=\"Submit\">");
	out.println("</form>");
}
if(!ourgame.getPlayerb().returnSetName())
{
	out.println("<form name=\"input\" action=\"/Monopoly/ChangeNameServlet\" method=\"get\">");
	out.println("Player2: <input type=\"text\" name=\"user2\">");
	out.println("<input type=\"submit\" value=\"Submit\">");
	out.println("</form>");
}
if(!ourgame.getPlayerc().returnSetName())
{
	out.println("<form name=\"input\" action=\"/Monopoly/ChangeNameServlet\" method=\"get\">");
	out.println("Player3: <input type=\"text\" name=\"user3\">");
	out.println("<input type=\"submit\" value=\"Submit\">");
	out.println("</form>");
}
if(!ourgame.getPlayerd().returnSetName())
{
	out.println("<form name=\"input\" action=\"/Monopoly/ChangeNameServlet\" method=\"get\">");
	out.println("Player4: <input type=\"text\" name=\"user4\">");
	out.println("<input type=\"submit\" value=\"Submit\">");
	out.println("</form>");
}
out.println("</div>");
//Player Pieces on the board
out.println("<div class=\"playeronePos\"> </div>");
out.println("<div class=\"playertwoPos\"> </div>");
out.println("<div class=\"playerthreePos\"> </div>");
out.println("<div class=\"playerfourPos\"> </div>");
out.println("</div>");
//Player1
out.println("<div class=\"One\">");
out.println("<div class = \"PlayerName\">" + ourgame.getPlayera().returnName() + "</div>");
out.println("<div class=\"PlayerMoney\">" + ourgame.getPlayera().returnMoney().toString() + " </div>");
out.println("<div class=\"BuildingsButton\">");
out.println("<FORM action=\"/Monopoly/DisplayPlayerBuildings\" method=\"post\">");
out.println("<br>");
out.println("<INPUT type=\"submit\" name=\"Player1Buildings\" value= \"Show Buildings\">");
out.println("</FORM>");
out.println("</div>");
out.println("</div>");
//Player2
out.println("<div class=\"Two\">");
out.println("<div class = \"PlayerName\">" + ourgame.getPlayerb().returnName() + "</div>");
out.println("<div class=\"PlayerMoney\">" + ourgame.getPlayerb().returnMoney().toString() + " </div>");
out.println("<div class=\"BuildingsButton\">");
out.println("<FORM action=\"/Monopoly/DisplayPlayer2Buildings\" method=\"post\">");
out.println("<br>");
out.println("<INPUT type=\"submit\" name=\"Player2Buildings\" value= \"Show Buildings\">");
out.println("</FORM>");
out.println("</div>");
out.println("</div>");
//Player3
out.println("<div class=\"Three\">");
out.println("<div class = \"PlayerName\">" + ourgame.getPlayerc().returnName() + "</div>");
out.println("<div class=\"PlayerMoney\">" + ourgame.getPlayerc().returnMoney().toString() + " </div>");
out.println("<div class=\"BuildingsButton\">");
out.println("<FORM action=\"/Monopoly/DisplayPlayer3Buildings\" method=\"post\">");
out.println("<br>");
out.println("<INPUT type=\"submit\" name=\"Player3Buildings\" value= \"Show Buildings\">");
out.println("</FORM>");
out.println("</div>");
out.println("</div>");
//Player4
out.println("<div class=\"Four\">");
out.println("<div class = \"PlayerName\">" + ourgame.getPlayerd().returnName() + "</div>");
out.println("<div class=\"PlayerMoney\">" + ourgame.getPlayerd().returnMoney().toString() + " </div>");
out.println("<div class=\"BuildingsButton\">");
out.println("<FORM action=\"/Monopoly/DisplayPlayer4Buildings\" method=\"post\">");
out.println("<br>");
out.println("<INPUT type=\"submit\" name=\"Player4Buildings\" value= \"Show Buildings\">");
out.println("</FORM>");
out.println("</div>");
out.println("</div>");

out.println("<div class=\"BuildingsList\">");
if(ourgame.getPlayera().returnShowBuildings())
{
	ArrayList<building> buildings = ourgame.getPlayera().returnBuildingList();
	out.println("<ol>");
	if(buildings.size() == 0)
	{
		out.println("<li> Nothing Owned by " + ourgame.getPlayera().returnName());
	}
	for(int i = 0; i < buildings.size(); i++)
	{
		out.println("<li>" + buildings.get(i).returnName() + "</li>");
	}
	out.println("</ol>");
	ourgame.getPlayera().setShowBuildings(false);
}
if(ourgame.getPlayerb().returnShowBuildings())
{
	ArrayList<building> buildings = ourgame.getPlayerb().returnBuildingList();
	out.println("<ol>");
	if(buildings.size() == 0)
	{
		out.println("<li> Nothing Owned by " + ourgame.getPlayerb().returnName());
	}
	for(int i = 0; i < buildings.size(); i++)
	{
		out.println("<li>" + buildings.get(i).returnName() + "</li>");
	}
	out.println("</ol>");
	ourgame.getPlayerb().setShowBuildings(false);
}
if(ourgame.getPlayerc().returnShowBuildings())
{
	ArrayList<building> buildings = ourgame.getPlayerc().returnBuildingList();
	out.println("<ol>");
	if(buildings.size() == 0)
	{
		out.println("<li> Nothing Owned by " + ourgame.getPlayerc().returnName());
	}
	for(int i = 0; i < buildings.size(); i++)
	{
		out.println("<li>" + buildings.get(i).returnName() + "</li>");
	}
	out.println("</ol>");
	ourgame.getPlayerc().setShowBuildings(false);
}
if(ourgame.getPlayerd().returnShowBuildings())
{
	ArrayList<building> buildings = ourgame.getPlayerd().returnBuildingList();
	out.println("<ol>");
	if(buildings.size() == 0)
	{
		out.println("<li> Nothing Owned by " + ourgame.getPlayerd().returnName());
	}
	for(int i = 0; i < buildings.size(); i++)
	{
		out.println("<li>" + buildings.get(i).returnName() + "</li>");
	}
	out.println("</ol>");
	ourgame.getPlayerd().setShowBuildings(false);
}

out.println("</div>");


%>


<FORM action="/Monopoly/ResetGameServlet" method="post">
<br>
<INPUT type="submit" name="Submit" value= "RESET">
</FORM>



</body>
</html>