package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.example.HibernateUtil;
import com.example.User;


/**
 * Servlet implementation class userAuth
 */
public class UserAuthentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAuthentication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: UA");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean found = false;
		
		PrintWriter out = response.getWriter();
		
		try {
			
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();
			
			List<User> list = session.createQuery("from User", User.class).list();
			
			for(User p : list) {
				if(p.getEmail().equals(email) && p.getPassword().equals(password)) {
					request.getSession().setAttribute("message", p.getName());
					response.sendRedirect("landing.jsp");
					found = true;
				}
			}
			
			if(!found) {
				out.println("<html><body>");
				out.println("Entered e-mail or password is incorrect.");
			}
			
			session.getTransaction().commit();
			session.close();
		
		} catch (Exception e) {
			throw e;
		}
		
		out.println("</body></html>");
	}

}
