package ait.employee.dao;

import ait.employee.model.Employee;
import ait.employee.model.SalesManager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CompanyArrayListImpl implements Company {

	List<Employee> employees;
	int capacity;

	public CompanyArrayListImpl(int capacity) {
		employees = new ArrayList<>();
		this.capacity = capacity;
	}

	//O(n)
	@Override
	public boolean addEmployee(Employee employee) {
		if (employee == null || employees.size() == capacity || findEmployee(employee.getId()) != null) {
			return false;
		}
		employees.add(employee);
		return true;
	}

	//O(n)
	@Override
	public Employee removeEmployee(int id) {
		Employee victim = findEmployee(id);
		if (victim != null) {
			employees.remove(victim);
			return victim;
		}
		return null;
	}

	//O(n)
	@Override
	public Employee findEmployee(int id) {
		for (Employee employee : employees) {
			if (employee.getId() == id) {
				return employee;
			}
		}
		return null;
	}

	//O(n)
	@Override
	public double totalSalary() {
		double sum = 0;
		for (Employee employee : employees) {
			sum = sum + employee.calcSalary();
		}
		return sum;
	}

	//O(n)
	@Override
	public double totalSales() {
		double sum = 0;
		for (Employee employee : employees) {
			if (employee instanceof SalesManager) {
				SalesManager sm = (SalesManager) employee;
				sum += sm.getSalesValue();
			}
		}
		return sum;
	}

	//O(1)
	@Override
	public int quantity() {
		return employees.size();
	}

	//O(n)
	@Override
	public void printEmployees() {
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	@Override
	public Employee[] findEmployeesHoursGreaterThan(int hours) {
		return findEmployeesByPredicate(e -> e.getHours() >= hours);
	}

	//O(n)
	@Override
	public Employee[] findEmployeesSalaryRange(int min, int max) {
		Predicate<Employee> predicate = new Predicate<>() {
			@Override
			public boolean test(Employee t) {
				return t.calcSalary() >= min && t.calcSalary() < max;
			}
		};
		return findEmployeesByPredicate(predicate);
	}

	private Employee[] findEmployeesByPredicate(Predicate<Employee> batska) {
		List<Employee> res = new ArrayList<>();
		for (Employee employee : employees) {
			if (batska.test(employee)) {
				res.add(employee);
			}

		}
		return res.toArray(new Employee[0]);
	}

}
