package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.example.HibernateUtil;
import com.example.User;

/**
 * Servlet implementation class userRegistration
 */
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistration() {
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
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		try {
			
			session.beginTransaction();
			
			User user = new User();
			
			if((!name.isEmpty() && !email.isEmpty() && !password.isEmpty())) {
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				out.println("Welcome " + name + "! You're account has been registered!<br><br>");
				out.println("Click <a href='index.jsp'>here</a> to go back to login screen");
				session.save(user);
			}else {
				out.println("Invalid Entry. All fields must be filled.<br><br>");
				out.println("Click <a href='registration.jsp'>here</a> to go back");
			}
			
		}catch (Exception e) {
			
			throw e;
		
		}finally {
			
			session.close();
		}
		
		out.println("</body></html>");
	}

}
