package ait.employee.dao;

import ait.employee.model.Employee;

public class CompanyImpl implements Company {
	private final Employee[] employees;
	private int size;

	public CompanyImpl(int capacity) {
		employees = new Employee[capacity];
	}

	public boolean addEmployee(Employee employee) {
		if (employee == null || size == employees.length || findEmployee(employee.getId()) != null) {
			return false;
		}
		employees[size++] = employee;
		return true;
	}


	public Employee removeEmployee(int id) {
		for (int i = 0; i < size; i++) {
			if (employees[i].getId() == id) {
				Employee removedEmployee = employees[i];
				//employees[i] = employees[size - 1];
				//employees[size - 1] = null; // Clear the last position
				employees[i] = employees[--size];
				employees[size] = null;
				//	size--;
				return removedEmployee;
			}
		}
		return null;
	}

	public Employee findEmployee(int id) {
		for (int i = 0; i < size; i++) {
			if (employees[i].getId() == id) {
				return employees[i];
			}
		}
		return null;
	}

	public int quantity() {
		return size;
	}

	public double totalSalary() {
		double totalSalary = 0;
		for (int i = 0; i < size; i++) {
			totalSalary += employees[i].calcSalary();
		}
		return totalSalary;
	}

	public double averageSalary() {
		if (size == 0) {
			return 0;
		}
		return totalSalary() / size;
	}

	public double totalSales() {
		double totalSales = 0;
		for (int i = 0; i < size; i++) {
			totalSales += employees[i].getTotalSales();
		}
		return totalSales;
	}

	public int size() {
		return 0;
	}


	public void printEmployees() {
		for (int i = 0; i < size; i++) {
			System.out.println(employees[i]);
		}
	}

	public Employee[] findEmployeesHoursGreateThan(int hours) {
		return new Employee[0];
	}

	public Employee[] findEmployeesHoursGreaterThan(int hours) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (employees[i].getHours() > hours) {
				count++;
			}

		}
		Employee[] res = new Employee[count];
		for (int i = 0, j = 0; j < res.length; i++) {
			if (employees[i].getHours() > hours) {
				res[j++] = employees[i];
			}

		}

		return res;
	}

	public Employee[] findEmployeesSalaryRange(int minSalary, int maxSalary) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (employees[i].calcSalary() >= minSalary && employees[i].calcSalary() < maxSalary) {
				count++;
			}

		}
		Employee[] res = new Employee[count];
		for (int i = 0, j = 0; j < res.length; i++) {
			if (employees[i].calcSalary() >= minSalary && employees[i].calcSalary() < maxSalary) {
				res[j++] = employees[i];
			}

		}

		return res;
	}

	public Employee[] findEmployeesSalaryBetween(double min, double max) {
		return new Employee[0];
	}
}
