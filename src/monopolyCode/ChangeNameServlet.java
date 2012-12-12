package monopolyCode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeNameServlet
 */
@WebServlet("/ChangeNameServlet")
public class ChangeNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		monopoly ourgame = (monopoly) request.getSession(true).getAttribute("ourgame");
		
		String Name1 = request.getParameter("user1");
		String Name2 = request.getParameter("user2");
		String Name3 = request.getParameter("user3");
		String Name4 = request.getParameter("user4");
		
		if(Name1 != null)
		{
			ourgame.getPlayera().setName(Name1);
		}
		if(Name2 != null)
		{
			ourgame.getPlayerb().setName(Name2);
		}
		if(Name3 != null)
		{
			ourgame.getPlayerc().setName(Name3);
		}
		if(Name4 != null)
		{
			ourgame.getPlayerd().setName(Name4);
			
		}
		
	
		getServletContext().getRequestDispatcher("/Monopoly.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		monopoly ourgame = (monopoly) request.getSession(true).getAttribute("ourgame");
		
	}

}
