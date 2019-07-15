<%@page import="com.zensar.Employee, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% List<Employee> employeesList = (List<Employee>)session.getAttribute("employeesList"); 
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String name = "";
		double salary = 0;%>
		
	<form action="updateEmployee?employeeId=<%=employeeId %>>">
		<table>
  			<tr>
    			<td>Employee ID: </td>
    			<td><input type="text" name="employeeId" value="<%=employeeId%>"/></td>
  			</tr>
  			<% for(Employee employee:employeesList)
  				if(employee.geteId()==employeeId) {
  					name = employee.getName();
  					salary = employee.getSalary();
  					break;
  				} %>
  			
  			<tr>
    			<td>Employee Name: </td>
    			<td><input type="text" name="employeeName" value="<%=name%>"/></td>
  			</tr>
  			<tr>
    			<td>Salary: </td>
    			<td><input type="text" name="salary" value="<%=salary%>"/></td>
  			</tr>
  			<tr>
    			<td><input type="submit" name="Submit"/></td>
    			<td><input type="reset" name="Reset"/></td>
  			</tr>
  		</table>
	</form>
</body>
</html>