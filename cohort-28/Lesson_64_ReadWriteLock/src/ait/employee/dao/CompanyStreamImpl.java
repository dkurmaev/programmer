package ait.employee.dao;

import ait.employee.model.Employee;
import ait.employee.model.SalesManager;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

public class CompanyStreamImpl implements Company {
    private final Lock locker = new ReentrantLock();
    private final Set<Employee> employees;
    private int capacity;

    public CompanyStreamImpl(int capacity) {
        this.capacity = capacity;
        employees = new HashSet<>();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if (employee == null) {
            return false;
        }
        locker.lock();
        try {
            if (employees.size() == capacity) {
                return false;
            }
            return employees.add(employee);
        } finally {
            locker.unlock();
        }
    }

    @Override
    public Employee removeEmployee(int id) {
        locker.lock();
        try {
            Employee victim = findEmployee(id);
            employees.remove(victim);
            return victim;
        } finally {
            locker.unlock();
        }
    }

    @Override
    public Employee findEmployee(int id) {
        locker.lock();
        try {
            return employees.stream()
                    .filter(employee -> employee.getId() == id)
                    .findFirst()
                    .orElse(null);
        } finally {
            locker.unlock();
        }
    }

    @Override
    public int quantity() {
        locker.lock();
        try {
            return employees.size();
        } finally {
            locker.unlock();
        }
    }

    @Override
    public double totalSalary() {
        locker.lock();
        try {
            return employees.stream()
                    .mapToDouble(Employee::calcSalary)
                    .sum();
        } finally {
            locker.unlock();
        }
    }

    @Override
    public double totalSales() {
        locker.lock();
        try {
            return employees.stream()
                    .filter(employee -> employee instanceof SalesManager)
                    .mapToDouble(employee -> ((SalesManager) employee).getSalesValue())
                    .sum();
        } finally {
            locker.unlock();
        }
    }

    @Override
    public void printEmployees() {
        locker.lock();
        try {
            employees.forEach(System.out::println);
        } finally {
            locker.unlock();
        }
    }

    @Override
    public Employee[] findEmployeesHoursGreaterThan(int hours) {
        return findEmployeesByPredicate(e -> e.getHours() >= hours);
    }

    @Override
    public Employee[] findEmployeesSalaryRange(int min, int max) {
        Predicate<Employee> predicate = employee -> employee.calcSalary() >= min && employee.calcSalary() < max;
        return employees.stream()
                .filter(predicate)
                .toArray(Employee[]::new);
    }

    private Employee[] findEmployeesByPredicate(Predicate<Employee> predicate) {
        locker.lock();
        try {
            return employees.stream()
                    .filter(predicate)
                    .toArray(Employee[]::new);
        } finally {
            locker.unlock();
        }
    }
}
