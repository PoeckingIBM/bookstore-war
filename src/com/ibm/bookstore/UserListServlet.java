package com.ibm.bookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ibm.bookstore.model.*;

/**
 * Servlet implementation class UserListServlet
 */
@WebServlet("/list")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@PersistenceUnit
	EntityManagerFactory emf;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		
		Integer id;
		String idString = request.getParameter("id");
		
		try{
			id = Integer.parseInt(idString);
		}catch (NumberFormatException e) {
			id = null;
		}
		
		EntityManager em = emf.createEntityManager();
		
		List<User> users;
		
		if (id != null)
			users = em.createQuery("SELECT u FROM User u WHERE u.ID = :id", User.class).setParameter("id", id).getResultList();
		
		else {
			users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
		}
		
		PrintWriter pw = response.getWriter();
		
		for (User user : users) {
			pw.append(user.toString());
			pw.append("<br/>");
		}
	}

}
