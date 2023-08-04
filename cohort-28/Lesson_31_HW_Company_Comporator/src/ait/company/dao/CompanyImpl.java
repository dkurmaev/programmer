package ait.company.dao;

import ait.company.model.Employee;

import java.util.function.Predicate;

public class CompanyImpl implements Company {
	private Employee[] employees;
	private int size;

	public CompanyImpl(Employee[] employees, int size) {
		this.employees = employees;
		this.size = size;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		if (employee == null || size == employees.length || findEmployee(employee.getName() != null) {
			return false;
		}
		employees[size++] = employee;
		return true;
	}

	@Override
	public Employee removeEmployee(String name) {
		for (int i = 0; i < size; i++) {
			if (employees[i].getName().equals(name)) {
				Employee removedEmployee = employees[i];
				employees[i] = employees[--size];
				employees[size] = null;
				return removedEmployee;
			}
		}
		return null;
	}

	@Override
	public Employee findEmployee(String name) {
		return null;
	}

	@Override
	public Employee findEmployee(Employee employee) {
		return findEmployeeByPredicate(e -> e.getName().equals(name));
	}

	@Override
	public int getEmployeeQuantity() {
		return getSize();
	}


	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void printEmployee() {
		for (int i = 0; i < size; i++) {
			System.out.println(employees[i]);
		}
	}

	@Override
	public Employee[] findEmployeeByExperience(String name) {
		return findEmployeeByPredicate(e -> e.getExperience() > experience);
	}

	@Override
	public Employee[] findEmployeeBySalaryLessThan2000(String name) {
		return findEmployeeByPredicate(e -> e.getSalary() < 2000);
	}




	@Override
	private Employee[] findEmployeeByPredicate(Predicate<Employee> predicate) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (predicate.test(employees[i])) {
				count++;
			}
		}
		Employee[] res = new Employee[count];
		for (int i = 0, j = 0; j < res.length; i++) {
			if (predicate.test(employees[i])) {
				res[j++] = employees[i];
			}
		}
		return res;
	}
}
