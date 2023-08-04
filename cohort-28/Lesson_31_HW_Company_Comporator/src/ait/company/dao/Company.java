package ait.company.dao;

import ait.company.model.Employee;

public abstract interface Company {

	public abstract boolean addEmployee(Employee employee);

	public abstract Employee removeEmployee(String name);

	public abstract Employee findEmployee(String name);

	public abstract int getEmployeeQuantity();

	int getSize();

	public abstract void printEmployee();

	public abstract Employee[] findEmployeeByExperience(String name);

	public abstract Employee[] findEmployeeBySalaryLessThan2000 (String name);




}
