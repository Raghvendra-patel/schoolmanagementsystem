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
import schoolmanagements.dto.student;

@WebServlet("/student")
public class addstudent extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String dob=req.getParameter("dob");
		String cno=req.getParameter("cno");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		HttpSession h=req.getSession();
		management m=(management)h.getAttribute("manage");
		List<student> students=m.getStudents();
		
		student s=new student();
		s.setId(Integer.parseInt(id));
		s.setName(name);
		s.setDob(dob);
		s.setMno(Integer.parseInt(cno));
		s.setEmail(email);
		s.setPassword(password);
		s.setManagements(m);
		
		students.add(s);
		m.setStudents(students);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("raghvendra");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.merge(m);
		et.commit();
		
		PrintWriter pr=resp.getWriter();
		pr.write("student data save");
		RequestDispatcher rd=req.getRequestDispatcher("adddata.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
		
	}
}
