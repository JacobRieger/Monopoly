package monopolyCode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BuycurrentServlet
 */
@WebServlet("/BuycurrentServlet")
public class BuycurrentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuycurrentServlet() {
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
		
		Integer Location = ourgame.getCurrentPlayer().returnLocation();
		if(!ourgame.returnBuildings().get(Location).returnOwned())
		{
			//System.out.println("Building Bought by" + ourgame.getCurrentPlayer().returnName());
			ourgame.buyCurrentLocation();
		}
		
		getServletContext().getRequestDispatcher("/Monopoly.jsp").forward(request, response);
		
	}

}