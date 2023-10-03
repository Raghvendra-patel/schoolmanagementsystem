package schoolmanagements.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import schoolmanagements.dto.assignment;
import schoolmanagements.dto.student;
@WebServlet("/adda")
public class addassignment extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid=req.getParameter("sid");
		String aid=req.getParameter("aid");
		String aname=req.getParameter("aname");
		String amarks=req.getParameter("amarks");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("raghvendra");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		student s=em.find(student.class,Integer.parseInt(sid));
		List<assignment> ass=s.getAssignments();
		
		assignment a=new assignment();
		a.setAid(Integer.parseInt(aid));
		a.setAname(aname);
		a.setAmarks(Integer.parseInt(amarks));
		
		ass.add(a);
		s.setAssignments(ass);
		
		et.begin();
		em.merge(s);
		et.commit();
	}
}
