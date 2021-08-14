package net.session.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class creditServlet
 */
@WebServlet("/credit")
public class creditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userID = request.getParameter("userID");
		Double camt=Double.parseDouble(request.getParameter("camt"));
		System.out.println( userID +" "+ camt);
		creditBean memberbean=new creditBean();
		memberbean.setUser(userID);
		memberbean.setCamt(camt);
		
		creditDao memberdao= new creditDao();
		if(memberdao.update(memberbean))
		{
			response.getWriter().print("updated");
		}
		else
		{
			response.getWriter().print("fail to update");
		}
	}

}
