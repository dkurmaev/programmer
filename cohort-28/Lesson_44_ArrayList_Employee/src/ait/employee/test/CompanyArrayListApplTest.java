package ait.employee.test;

import ait.employee.dao.Company;
import ait.employee.dao.CompanyArrayListAppl;
import ait.employee.dao.CompanyImpl;
import ait.employee.model.Employee;
import ait.employee.model.Manager;
import ait.employee.model.SalesManager;
import ait.employee.model.WageEmployee;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


public class CompanyArrayListApplTest {

	Company company;
	Employee[] firm;


	@BeforeEach
	void setUp() {
		company = new CompanyImpl(5);
		firm = new Employee[4];
		firm[0] = new Manager(1000, "John", "Smith", 160, 5000, 5);
		firm[1] = new WageEmployee(2000, "Ann", "Smith", 160, 15);
		firm[2] = new SalesManager(3000, "Peter", "Jackson", 160, 25000, 0.1);
		firm[3] = new SalesManager(4000, "Rabindranat", "Anand", 80, 20000, 0.1);
		for (Employee employee : firm) {
			company.addEmployee(employee);

		}
	}

	@org.junit.jupiter.api.Test
	void addEmployee() {
		assertFalse(company.addEmployee(null));
		assertFalse(company.addEmployee(firm[1]));
		Employee employee = new SalesManager(5000, "Rabindranat", "Anand", 80, 20000, 0.1);
		assertTrue(company.addEmployee(employee));
		assertEquals(5, company.quantity());
		employee = new SalesManager(6000, "Rabindranat", "Anand", 80, 20000, 0.1);
		assertFalse(company.addEmployee(employee));
	}

	@Test
	public void testRemoveEmployee() {
		Employee employee1 = new Employee(1, "John", 40, 25.0);
		company.addEmployee(employee1);

		Employee removedEmployee = company.removeEmployee(1);
		assertNotNull(removedEmployee);
		assertEquals(1, company.size());
	}

	@Test
	public void testFindEmployee() {
		Employee employee1 = new Employee(1, "John", 40, 25.0);
		company.addEmployee(employee1);

		Employee foundEmployee = company.findEmployee(1);
		assertNotNull(foundEmployee);
		assertEquals("John", foundEmployee.getName());
	}

	@Test
	public void testTotalSalary() {
		Employee employee1 = new Employee(1, "John", 40, 25.0);
		Employee employee2 = new Employee(2, "Alice", 35, 30.0);
		company.addEmployee(employee1);
		company.addEmployee(employee2);

		double expectedTotalSalary = 40 * 25.0 + 35 * 30.0;
		assertEquals(expectedTotalSalary, company.totalSalary(), 0.001);
	}

	@Test
	public void testAverageSalary() {
		Employee employee1 = new Employee(1, "John", 40, 25.0);
		Employee employee2 = new Employee(2, "Alice", 35, 30.0);
		company.addEmployee(employee1);
		company.addEmployee(employee2);

		double expectedAverageSalary = (40 * 25.0 + 35 * 30.0) / 2;
		assertEquals(expectedAverageSalary, company.averageSalary(), 0.001);
	}

	// Add more tests for other methods as needed
}
