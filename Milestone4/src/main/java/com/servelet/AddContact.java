package com.servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.Dbconnect;
import com.dao.ContactDao;
import com.entity.Contact;

@WebServlet("/addContact")
public class AddContact extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int userId=Integer.parseInt(req.getParameter("userid"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phno=req.getParameter("phno");
		
		System.out.println(userId+" "+name+" "+email+" "+phno);
		Contact c=new Contact(name,email,phno,userId);
		
		ContactDao dao=new ContactDao(Dbconnect.getConn());
		
		HttpSession session=req.getSession();
		boolean f=dao.saveContact(c);
		if(f)
		{
			session.setAttribute("succMsg","Your contact saved");
			resp.sendRedirect("addcontact.jsp");
		}else {
			session.setAttribute("failedMsg","Failed");
			resp.sendRedirect("addcontact.jsp");
		}
		
	}

	
}
