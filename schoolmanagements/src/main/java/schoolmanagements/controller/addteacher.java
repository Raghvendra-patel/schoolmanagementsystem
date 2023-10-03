package schoolmanagements.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import schoolmanagements.dto.management;
import schoolmanagements.dto.student;
import schoolmanagements.dto.teacher;
@WebServlet("/teacher")
public class addteacher extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String subject=req.getParameter("subject");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		HttpSession h=req.getSession();
		management m=(management)h.getAttribute("manage");

		List<teacher> teachers= m.getTeachers();
		
        teacher t=new teacher();
		t.setId(Integer.parseInt(id));
		t.setName(name);
		t.setAge(Integer.parseInt(age));
		t.setEmail(email);
		t.setPassword(password);
		t.setSubject(subject);

		teachers.add(t);
		m.setTeachers(teachers);
		t.setManagements(m);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("raghvendra");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(m);
		et.commit();
		
		PrintWriter pr=resp.getWriter();
		pr.write("teacher data save");
		
		RequestDispatcher rd=req.getRequestDispatcher("adddata.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
}	
}
