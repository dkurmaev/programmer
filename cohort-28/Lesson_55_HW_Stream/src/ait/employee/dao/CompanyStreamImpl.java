package ait.employee.dao;

import ait.employee.model.Employee;
import ait.employee.model.SalesManager;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
public class CompanyStreamImpl implements Company {
    private final Set<Employee> employees;
    private int capacity;
    public CompanyStreamImpl(int capacity) {
        this.capacity = capacity;
        employees = new HashSet<>();
    }
    // O(1)
    @Override
    public boolean addEmployee(Employee employee) {
        if (employee == null || employees.size() == capacity) {
            return false;
        }
        return employees.add(employee);
    }
    // O(n)
    @Override
    public Employee removeEmployee(int id) {
        Employee victim = findEmployee(id);
        employees.remove(victim);
        return victim;
    }
    // O(n)
    @Override
    public Employee findEmployee(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null);
    }
    // O(n)
    @Override
    public int quantity() {
        return employees.size();
    }
    // O(n)
    @Override
    public double totalSalary() {
        return employees.stream()
                .mapToDouble(Employee::calcSalary)
                .sum();
    }
    // O(n)
    @Override
    public double totalSales() {
        return employees.stream()
                .filter(employee -> employee instanceof SalesManager)
                .mapToDouble(employee -> ((SalesManager) employee).getSalesValue())
                .sum();
    }
    // O(n)
    @Override
    public void printEmployees() {
        employees.forEach(System.out::println);
    }
    // O(n)
    @Override
    public Employee[] findEmployeesHoursGreaterThan(int hours) {
        return employees.stream()
                .filter(employee -> employee.getHours() >= hours)
                .toArray(Employee[]::new);
    }

    // O(n)
    @Override
    public Employee[] findEmployeesSalaryRange(int min, int max) {
        Predicate<Employee> predicate = employee -> employee.calcSalary() >= min && employee.calcSalary() < max;
        return employees.stream()
                .filter(predicate)
                .toArray(Employee[]::new);
    }
    private Employee[] findEmployeesByPredicate(Predicate<Employee> predicate) {
        return employees.stream()
                .filter(predicate)
                .toArray(Employee[]::new);
    }

}