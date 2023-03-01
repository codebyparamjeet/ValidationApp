package in.main.Controller;

import in.main.dao.Employeeimpl;

import in.main.dto.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registeration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Registeration() {
		// TODO Auto-generated constructor stub
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String empid = request.getParameter("empid");
		String ename = request.getParameter("ename");
		String eage = request.getParameter("eage");
		String emobile = request.getParameter("emobile");
		String eemail = request.getParameter("eemail");

		Employeeimpl employeeimpl = new Employeeimpl();

		Employee employee = new Employee();
		employee.setEmpid(empid);
		employee.setEname(ename);
		employee.setEage(eage);
		employee.setEmobile(emobile);
		employee.setEemail(eemail);

		String status = employeeimpl.addEmployee(employee);

		writer.println("<h1>" + status + "</h1>");

	}

}
