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
		
		monopoly ourgame = (monopoly) request.getSession(true).getAttribute("ourgame");
		
		Integer die1 = ourgame.dice();
		Integer die2 = ourgame.dice();
		
		if(!ourgame.getCurrentPlayer().hasRolled())
		{
			ourgame.getCurrentPlayer().incrementLocation(die1 + die2);
			ourgame.getCurrentPlayer().set_hasRolled(true);
		}
		

		request.getSession(true).setAttribute("ourgame", ourgame);
		
		getServletContext().getRequestDispatcher("/Monopoly.jsp").forward(request, response);
		
		
	}

}
