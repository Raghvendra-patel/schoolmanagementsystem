package schoolmanagements.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import schoolmanagements.dto.management;
@WebServlet("/save")
public class savemanagement extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=req.getParameter("id");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		management m=new management();
		m.setId(Integer.parseInt(id));
		m.setEmail(email);
		m.setPassword(password);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("raghvendra");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(m);
		et.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.forward(req, resp);
	}
}
