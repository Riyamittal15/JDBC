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

import javax.servlet.http.HttpServlet;


@WebServlet("/update")
public class EditContact extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int cid=Integer.parseInt(req.getParameter("cid"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phno=req.getParameter("phno");
		
		Contact c=new Contact();
		c.setId(cid);
		c.setName(name);
		c.setEmail(email);
		c.setPhno(phno);
		//System.out.println(name+" "+email+" "+phno);
		ContactDao dao=new ContactDao(Dbconnect.getConn());
		HttpSession session=req.getSession();
		boolean f=dao.updateContact(c);
		if(f)
		{
			session.setAttribute("succMsg","Your contact updated");
			resp.sendRedirect("viewcontact.jsp");
		}else {
			session.setAttribute("failedMsg","Failed");
			resp.sendRedirect("editcontact.jsp?cid="+cid);
			
		}
	}
	
	
}
