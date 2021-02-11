package jomily.anv.employees_skills.service;

import java.util.List;

import jomily.anv.employees_skills.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public void saveEmployee(Employee theEmployee);

	public Employee getEmployee(int theId);

	public void deleteEmployee(int theId);
}
