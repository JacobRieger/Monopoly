package monopolyCode;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayPlayerBuildings
 */
@WebServlet("/DisplayPlayerBuildings")
public class DisplayPlayerBuildings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayPlayerBuildings() {
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
		
		ourgame.getPlayerc().setShowBuildings(false);
		ourgame.getPlayera().setShowBuildings(true);
		ourgame.getPlayerb().setShowBuildings(false);
		ourgame.getPlayerd().setShowBuildings(false);
		
		request.getSession(true).setAttribute("ourgame", ourgame);
		getServletContext().getRequestDispatcher("/Monopoly.jsp").forward(request, response);
		
	}

}
