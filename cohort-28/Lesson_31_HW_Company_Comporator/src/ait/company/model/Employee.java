package ait.company.model;

import java.util.Objects;

public abstract class Employee {
	private String name;
	private int yearOfBirth;
	private int experience;

	private int salary = 5000;

	public Employee(String name, int yearOfBirth, int experience, int salary) {
		this.name = name;
		this.yearOfBirth = yearOfBirth;
		this.experience = experience;
		this.salary = salary;
	}

	public String getName(String name) {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Employee " + "name = " + name + ", yearOfBirth = " + yearOfBirth + ", experience = " + experience;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return yearOfBirth == employee.yearOfBirth && experience == employee.experience && Objects.equals(name, employee.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, yearOfBirth, experience);
	}

	public abstract double calcSalary();

	public abstract double experienceBonus();


	public int getSalary() {
		return 0;
	}
}

