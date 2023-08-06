package ait.employee.dao;

import ait.employee.model.Employee;

import java.util.ArrayList;
import java.util.function.Predicate;

public class CompanyArrayListAppl implements Company {

	public ArrayList<Employee> employees;

	public int capacity;

	public boolean addEmployee(Employee employee) {
		if (employees.size() < capacity) {
			employees.add(employee);
			return true;
		}

		return false;

	}

	public Employee removeEmployee(int id) {
		Employee victim = findEmployee(id);
		if (victim != null) {
			employees.remove(victim);
			return victim;
		}
		return null;
	}

	public Employee findEmployee(int id) {
		for (Employee employee : employees) {
			if (employee.getId() == id) {
				return employee;
			}
		}
		return null;
	}

	public int size() {
		return employees.size();

	}
	public int quantity() {
		return employees.size();
	}

	public double totalSalary() {
		double totalSalary = 0;
		for (Employee employee : employees) {
			totalSalary += employee.calcSalary();
		}
		return totalSalary;
	}


	public double averageSalary() {
		if (employees.size() > 0) {
			return totalSalary() / employees.size();
		}
		return 0;

	}

	public double totalSales() {
		return 0;
	}

//	@Override
//	public double totalSales() {
//		double totalSales = 0;
//		for (Employee employee : employees) {
//			if (employee instanceof SalesPerson) {
//				totalSales += ((SalesPerson) employee).getSales();
//			}
//		}
//
//		return 0;
//	}

	public void printEmployees() {
		for (Employee employee : employees) {
			System.out.println(employee);
		}

	}

	public Employee[] findEmployeesHoursGreateThan(int hours) {
		return new Employee[0];
	}

	public Employee[] findEmployeesHoursGreaterThan(int hours) {
		int count = 0;
		for (Employee employee : employees) {
			if (employee.getHours() > hours) {
				count++;
			}
		}
		Employee[] result = new Employee[count];
		int index = 0;
		for (Employee employee : employees) {
			if (employee.getHours() > hours) {
				result[index++] = employee;
			}
		}
		return result;

	}

	public Employee[] findEmployeesSalaryRange(int minSalary, int maxSalary) {
		int count = 0;
		for (Employee employee : employees) {
			if (employee.calcSalary() >= minSalary && employee.calcSalary() <= maxSalary) {
				count++;
			}
		}
		Employee[] result = new Employee[count];
		int index = 0;
		for (Employee employee : employees) {
			if (employee.calcSalary() >= minSalary && employee.calcSalary() <= maxSalary) {
				result[index++] = employee;
			}
		}
		return result;
	}
	public Employee[] findEmployeesSalaryBetween(double min, double max) {
		Predicate<Employee> predicate = new Predicate<>() {
			public boolean test(Employee t) {
				return t.calcSalary() >= min && t.calcSalary() < max;
			}
		};
		return findEmployeesByPredicate(predicate);
	}

	private Employee[] findEmployeesByPredicate(Predicate<Employee> batska) {
		int count = 0;
		for (Employee employee : employees) {
			if (batska.test(employee)) {
				count++;
			}
		}
		Employee[] res = new Employee[count];
		for (int i = 0, j = 0; j < res.length; i++) {
			if (batska.test(employees.get(i))) {
				res[j++] = employees.get(i);
			}
		}
		return res;
	}


}
