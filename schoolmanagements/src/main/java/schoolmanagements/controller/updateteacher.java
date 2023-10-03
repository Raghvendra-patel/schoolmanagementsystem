package schoolmanagements.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import schoolmanagements.dto.teacher;
@WebServlet("/updatet")
public class updateteacher extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String subject=req.getParameter("subject");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		teacher s=new teacher();
		s.setId(Integer.parseInt(id));
		s.setName(name);
		s.setAge(Integer.parseInt(age));
		s.setEmail(email);
		s.setPassword(password);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("raghvendra");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.merge(s);
		et.commit();
		PrintWriter pw=resp.getWriter();
	    pw.write("welcome");
}
}
