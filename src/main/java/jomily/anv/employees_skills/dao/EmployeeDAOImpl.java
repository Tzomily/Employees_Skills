package jomily.anv.employees_skills.dao;

import java.util.List;

import jomily.anv.employees_skills.entity.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class EmployeeDAOImpl implements EmployeeDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getEmployees() {
		Session currentSession = sessionFactory.getCurrentSession();

		// Query to sort by last name
		Query<Employee> theQuery = currentSession.createQuery("from Employee order by lastName", Employee.class);

		List<Employee> employees = theQuery.getResultList();

		return employees;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theEmployee);

	}

	@Override
	public Employee getEmployee(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Employee theEmployee = currentSession.get(Employee.class, theId);

		return theEmployee;
	}

	@Override
	public void deleteEmployee(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId ");
		theQuery.setParameter("employeeId", theId);

		theQuery.executeUpdate();
	}

	@Override
	public List<Employee> getEmployees(String lastName, String firstName) {
		Session currentSession = sessionFactory.getCurrentSession();

		// Query to sort by last name
		Query<Employee> theQuery = currentSession.createQuery("from Employee where lastName and fistName order by lastName", Employee.class);

		List<Employee> employees = theQuery.getResultList();

		return employees;
	}

	
}
