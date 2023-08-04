package ait.employee.dao;

import ait.employee.model.Employee;

public interface Company {

	boolean addEmployee(Employee employee);

	Employee removeEmployee(int id);

	Employee findEmployee(int id);

	int quantity();

	double totalSalary();

	default double averageSalary() {
		return totalSalary() / size();
	}

	double totalSales();

	int size();

	void printEmployees();

	Employee[] findEmployeesHoursGreateThan(int hours);

	Employee[] findEmployeesHoursGreaterThan(int hours);

	Employee[] findEmployeesSalaryRange(int minSalary, int maxSalary);

	Employee[] findEmployeesSalaryBetween(double min, double max);
}