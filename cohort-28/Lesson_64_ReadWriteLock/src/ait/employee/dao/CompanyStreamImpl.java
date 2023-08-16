package ait.employee.dao;

import ait.employee.model.Employee;
import ait.employee.model.SalesManager;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Predicate;

/*
В этом примере writeLock используется для методов, выполняющих операции записи, а readLock используется для методов,
выполняющих операции только для чтения. Это позволяет нескольким потокам выполнять чтение одновременно, но блокирует
доступ на запись во время чтения и записи.
 */

public class CompanyStreamImpl implements Company {
    private final Lock locker = new ReentrantLock();
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

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
        writeLock.lock();
        try {
            if (employees.size() == capacity) {
                return false;
            }
            return employees.add(employee);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public Employee removeEmployee(int id) {
        writeLock.lock();
        try {
            Employee victim = findEmployee(id);
            employees.remove(victim);
            return victim;
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public Employee findEmployee(int id) {
        readLock.lock();
        try {
            return employees.stream()
                    .filter(employee -> employee.getId() == id)
                    .findFirst()
                    .orElse(null);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public int quantity() {
        readLock.lock();
        try {
            return employees.size();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public double totalSalary() {
        readLock.lock();
        try {
            return employees.stream()
                    .mapToDouble(Employee::calcSalary)
                    .sum();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public double totalSales() {
        readLock.lock();
        try {
            return employees.stream()
                    .filter(employee -> employee instanceof SalesManager)
                    .mapToDouble(employee -> ((SalesManager) employee).getSalesValue())
                    .sum();
        } finally {
            readLock.unlock();
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
        writeLock.lock();
        try {
            return employees.stream()
                    .filter(predicate)
                    .toArray(Employee[]::new);
        } finally {
           writeLock.unlock();
        }
    }
}
