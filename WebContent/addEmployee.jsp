<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addEmployee">
		<table>
  			<tr>
    			<td>Employee ID: </td>
    			<td><input type="text" name="employeeId"/></td>
  			</tr>
  			<tr>
    			<td>Employee Name: </td>
    			<td><input type="text" name="employeeName"/></td>
  			</tr>
  			<tr>
    			<td>Salary: </td>
    			<td><input type="text" name="salary"/></td>
  			</tr>
  			<tr>
    			<td><input type="submit" name="Submit"/></td>
    			<td><input type="reset" name="Reset"/></td>
  			</tr>
  		</table>
	</form>
</body>
</html>