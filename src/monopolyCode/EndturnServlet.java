package monopolyCode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EndturnServlet
 */
@WebServlet("/EndturnServlet")
public class EndturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EndturnServlet() {
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
		
		ourgame.getPlayera().set_hasRolled(false);
		ourgame.getPlayerb().set_hasRolled(false);
		ourgame.getPlayerc().set_hasRolled(false);
		ourgame.getPlayerd().set_hasRolled(false);
		ourgame.whosTurn();
		
		request.getSession(true).setAttribute("ourgame", ourgame);
		
		getServletContext().getRequestDispatcher("/Monopoly.jsp").forward(request, response);
		
	}

}
