package com.zensar;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	
	public Connection createConnection() {
		
		Connection connection=null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mvc_test";
		String user = "root";
		String pass = "Temp1234";
		
		try {
			Class.forName(driver);
			System.out.println("driver loaded...");
			
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("connection established...");
			
		} catch (Exception e) {e.printStackTrace();}
		
		
		return connection;
	}
	
	public int addEmployee(Employee employee) throws Exception {
		
		Connection con = createConnection();
		String sql = "insert into employee values(?,?,?)";
		
		PreparedStatement pStatement = con.prepareStatement(sql);
		pStatement.setInt(1, employee.geteId());
		pStatement.setString(2, employee.getName());
		pStatement.setDouble(3, employee.getSalary());
		int result = pStatement.executeUpdate();
		
		con.close();
		return result;
	}
	
	public List<Employee> getAllEmployees() throws Exception{
		
		Connection con = createConnection();
		List<Employee> listEmployees = new ArrayList<>();
		String sql = "select * from employee";
		Employee employee;
		
		PreparedStatement pStatement = con.prepareStatement(sql);
		ResultSet rs = pStatement.executeQuery();
		while(rs.next()) {
			
			employee = new Employee();
			employee.seteId(rs.getInt("employeeId"));
			employee.setName(rs.getString("employeeName"));
			employee.setSalary(rs.getDouble("salary"));
			listEmployees.add(employee);
		}
		con.close();
		return listEmployees;
	}
	
	public int deleteEmployee(int employeeId) throws Exception {
		Connection con = createConnection();
		String sql = "delete from employee where employeeId=?";
		
		PreparedStatement pStatement = con.prepareStatement(sql);
		pStatement.setInt(1, employeeId);
		int result = pStatement.executeUpdate();
		return result;
	}
	
	public int updateEmployee(Employee employee) throws Exception {
		Connection con = createConnection();
		String sql = "update employee set employeeName = ?, salary = ? where employeeId=?";
		
		PreparedStatement pStatement = con.prepareStatement(sql);
		pStatement.setString(1, employee.getName());
		pStatement.setDouble(2, employee.getSalary());
		pStatement.setInt(3, employee.geteId());
		int result = pStatement.executeUpdate();
		return result;
	}
}
