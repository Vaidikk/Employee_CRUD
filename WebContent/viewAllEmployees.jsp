<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.zensar.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>List of all Employees</h2>
	<% List<Employee> employeesList = (List<Employee>)session.getAttribute("employeesList"); %>
	<table>
		<th>Employee Id</th>
		<th>Name</th>
		<th>Salary</th>
		<% for(Employee employee:employeesList){ %>
		<tr>
			<td> <%=employee.geteId() %> </td>
			<td> <%=employee.getName() %> </td>
			<td> <%=employee.getSalary() %> </td>
			<td> <a href="deleteEmployee?employeeId=<%=employee.geteId() %>">Delete</a></td>
			<td> <a href="updateEmployee.jsp?employeeId=<%=employee.geteId() %>">Update</a></td>
		</tr>
		<%} %>
	</table>
</body>
</html>