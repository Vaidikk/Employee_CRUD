package com.zensar;

public class Test {

	public static void main(String[] args) throws Exception {
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		Employee e1 = new Employee(102, "Danny", 13000);
		
//		employeeDAO.addEmployee(e1);
		
		System.out.println(employeeDAO.getAllEmployees());
	}

}
