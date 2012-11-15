package monopolyCode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DiceServlet
 */
@WebServlet("/DiceServlet")
public class DiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		player player1 = (player) request.getSession(true).getAttribute("player1");
		Dice ourDice = (Dice) request.getSession(true).getAttribute("dice");
		
		
		player1.incrementLocation(ourDice.return_total());
		
		request.getSession().setAttribute("dice", ourDice);
		request.getSession().setAttribute("player1", player1);
		
		System.out.println(player1.returnLocation());
		
		getServletContext().getRequestDispatcher("/Monopoly.jsp").forward(request, response);
		
		
	}

}
