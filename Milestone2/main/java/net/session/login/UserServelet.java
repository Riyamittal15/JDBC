package net.session.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.session.login.Member;
import net.session.login.RegisterDao;

/**
 * Servlet implementation class UserServelet
 */
@WebServlet("/Register")
public class UserServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RegisterDao userDao= new RegisterDao();
		String name=request.getParameter("fname");
		String email=request.getParameter("email");
		String phoneNumber=(request.getParameter("phone"));
		String password=request.getParameter("password");

		Member user=new Member( name, email, phoneNumber, password);
		
		String result = userDao.insert(user);
		response.getWriter().print(result);
		
		response.sendRedirect("CreditDebit.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
