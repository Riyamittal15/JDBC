package net.session.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private loginDao logDao;

	public void init() {
		logDao = new loginDao();
	}

    public LoginServlet() {
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
		//doGet(request, response);
		String name = request.getParameter("fname");
		String password = request.getParameter("password");
		loginBean logBean = new loginBean();
		logBean.setUsername(name);
		logBean.setPassword(password);

		try {
			if (logDao.validate(logBean)) {
				//HttpSession session = request.getSession();
				// session.setAttribute("name",name);
				System.out.println("cre");
				response.sendRedirect("CreditDebit.jsp");//login success
			} else {
				HttpSession session = request.getSession();
				//session.setAttribute("user", name);
				System.out.println("Reg");
				response.sendRedirect("RegistrationForm1.jsp");//login failed
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
