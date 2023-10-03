package schoolmanagements.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import schoolmanagements.dto.management;
import schoolmanagements.dto.teacher;
@WebServlet("/teachervalidate")
public class teacherverification extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("raghvendra");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Query q=em.createQuery("select a from teacher a where email=?1 and password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		
		List<teacher> m=q.getResultList();
		if(m.size()>0)
		{
			teacher t=m.get(0);
	        HttpSession hs=req.getSession();
	        hs.setAttribute("t1", t);
			RequestDispatcher rd=req.getRequestDispatcher("welcometeacher.html");
			rd.forward(req, resp);
		}
		else {
			PrintWriter pr=resp.getWriter();
			pr.write("login failed");
			RequestDispatcher rd=req.getRequestDispatcher("teacherlogin.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
	}
}
