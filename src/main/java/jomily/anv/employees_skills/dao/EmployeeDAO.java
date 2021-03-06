package jomily.anv.employees_skills.dao;

import java.util.List;

import jomily.anv.employees_skills.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployees();

	public void saveEmployee(Employee theEmployee);

	public Employee getEmployee(int theId);
	
	public List<Employee> getEmployees(String lastName);

	public void deleteEmployee(int theId);
}