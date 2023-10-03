package schoolmanagements.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/selectrole")
public class selectrole extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String role=req.getParameter("role");
		if(role.equals("management"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("/managementvalidate");
			rd.forward(req, resp);
		}
		else if(role.equals("teacher"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("/teachervalidate");
			rd.forward(req, resp);
		}
		else 
		{
			RequestDispatcher rd=req.getRequestDispatcher("/studentvalidate");
			rd.forward(req, resp);
		}
	}
}
