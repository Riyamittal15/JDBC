package com.servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.entity.User;
import com.dao.UserDao;
import com.conn.Dbconnect;

/**
 * Servlet implementation class RegisterSevlet
 */
@WebServlet("/register")
public class RegisterSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterSevlet() {
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
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		User u=new User(name,email,password);
		
		UserDao dao = new UserDao(Dbconnect.getConn());
		
		boolean f=dao.userRegister(u);
		
		HttpSession session=request.getSession();
		if(f)
		{
			session.setAttribute("succ","User Register Successfully");
			response.sendRedirect("register.jsp");
			//System.out.println("Success");
		}
		else {
			session.setAttribute("error","User Registration failed");
			response.sendRedirect("register.jsp");
			//System.out.println("Fail");
		}
		
	}

}
