package com.servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.Dbconnect;
import com.dao.UserDao;
import com.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		
		UserDao dao=new UserDao(Dbconnect.getConn());
		User u=dao.loginUser(email,pass);
		
		HttpSession session=req.getSession();
		
		if(u!=null)
		{
			session.setAttribute("user", u);
			resp.sendRedirect("index.jsp");
			//System.out.println("User is available"+u);
		}else {
			session.setAttribute("invalidMsg", "Invalid Email and password");
			resp.sendRedirect("index.jsp");
			System.out.println("User is not available"+u);
		}
	}

}
