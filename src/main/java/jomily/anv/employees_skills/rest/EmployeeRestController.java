package jomily.anv.employees_skills.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jomily.anv.employees_skills.entity.Employee;
import jomily.anv.employees_skills.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

	// autowire the EmployeeService
	@Autowired
	private EmployeeService employeeService;

	// add mapping for GET/employees
	@GetMapping
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	// add mapping for GET/employees/{employeeId}
	@GetMapping("/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.getEmployee(employeeId);
		
		if(theEmployee==null) {
			throw new EmployeeNotFoundException("Customer id not found - "+employeeId);
		}
		return theEmployee;
	}

	// add mapping for POST /employees -add a new employee
	@PostMapping
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		// set id to 0 just in case an id is passed... forcing insert instead of update
		theEmployee.setId(0);

		employeeService.saveEmployee(theEmployee);
		return theEmployee;
	}

	// add mapping for PUT /employees -update employee
	@PutMapping
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		employeeService.saveEmployee(theEmployee);
		return theEmployee;
	}

	// add mapping for DELETE / employees/{employeeId}
	@DeleteMapping("/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.getEmployee(employeeId);
		
		if(theEmployee==null) {
			throw new EmployeeNotFoundException("Customer id not - "+employeeId);
		}
		employeeService.deleteEmployee(employeeId);
		return "Deleted Employee id- " + employeeId;
	}

}
