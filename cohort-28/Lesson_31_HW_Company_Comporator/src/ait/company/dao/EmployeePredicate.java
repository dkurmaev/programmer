package ait.company.dao;

import ait.company.model.Employee;

import java.util.function.Predicate;

public class EmployeePredicate implements Predicate<Employee> {

	private String name;

	public EmployeePredicate(String name){
		this.name = name;
	}


	@Override
	public boolean test(Employee employee) {
		return employee.getName(name) == name;
	}
}
