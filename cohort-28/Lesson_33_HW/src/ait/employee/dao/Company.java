package ait.employee.dao;

import ait.employee.model.Employee;

public interface Company {

    String NAME = "Ait";
    boolean addEmployee(Employee employee);

    Employee removeEmployee(int id);

    Employee findEmployee(int id);

    int quantity();

    double totalSalary();

    double avgSalary();

    double totalSales();

    //void printEmployees();

    void printEmployees(Employee[] employees);

    Employee[] findEmployeesHoursGreaterThan(int hours);

    Employee[] findEmployeesSalaryRange(int minSalary, int maxSalary);
}