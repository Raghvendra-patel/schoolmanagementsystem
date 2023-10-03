package schoolmanagements.controller;

import java.io.IOException;
import java.io.PrintWriter;

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

import schoolmanagements.dto.teacher;
@WebServlet("/removet")
public class removeteacher extends HttpServlet{
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=req.getParameter("id");
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("raghvendra");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		teacher t=em.find(teacher.class, Integer.parseInt(id));
		et.begin();
		em.remove(t);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("teacherremoved");
	}

}
