package com.zensar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeController extends HttpServlet{
	
	private List<Employee> employeesList;
	private HttpSession session = null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String urlViewAll = "/employee_crud/getAllEmployees";
		String urlUpdate = "/employee_crud/updateEmployee";
		String urlDelete = "/employee_crud/deleteEmployee";
		String urlAdd = "/employee_crud/addEmployee";
		session = request.getSession();
		System.out.println(request.getRequestURI());
		if(request.getRequestURI().equals(urlViewAll))
			viewAllEmployees(request, response);
		else if(request.getRequestURI().equals(urlUpdate))
			updateEmployee(request, response);
		else if(request.getRequestURI().equals(urlDelete))
			deleteEmployee(request, response);
		else if(request.getRequestURI().equals(urlAdd))
			addEmployee(request, response);
		
	}
	
	public void viewAllEmployees(HttpServletRequest request, HttpServletResponse response) {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		try {
			
			employeesList = employeeDAO.getAllEmployees();
			
			session.setAttribute("employeesList", employeesList);
			response.sendRedirect("viewAllEmployees.jsp");
			
			
		} catch (Exception e) {e.printStackTrace();}
	}

	public void addEmployee(HttpServletRequest request, HttpServletResponse response) {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String employeeName = request.getParameter("employeeName");
		double salary = Double.parseDouble(request.getParameter("salary"));
		
		System.out.println("eId: "+employeeId);
		System.out.println("eName: "+employeeName);
		System.out.println("salary: "+salary);
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		try {
			int result = employeeDAO.addEmployee(new Employee(employeeId, employeeName, salary));
			
			response.sendRedirect("success.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		viewAllEmployees(request, response);
	}
	
	public void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
		int employeeId = 0;
		employeeId = Integer.parseInt(request.getParameter("employeeId"));
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		try {
			employeeDAO.deleteEmployee(employeeId);
		} catch (Exception e) {e.printStackTrace();}
		
		viewAllEmployees(request, response);
	}
	
	public void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String employeeName = request.getParameter("employeeName");
		double salary = Double.parseDouble(request.getParameter("salary"));
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		try {
			employeeDAO.updateEmployee(new Employee(employeeId, employeeName, salary));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		viewAllEmployees(request, response);
	}

}
