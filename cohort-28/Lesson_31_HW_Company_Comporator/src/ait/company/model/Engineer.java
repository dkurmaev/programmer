package ait.company.model;

public class Engineer extends Employee{

	private double baseSalary;

	private double experienceBonus;

	private double totalSalary;


	public Engineer(String name, int yearOfBirth, int experience, double baseSalary, double experienceBonus, double totalSalary) {
		super(name, yearOfBirth, experience);
		this.baseSalary = baseSalary;
		this.experienceBonus = experienceBonus;
		this.totalSalary = totalSalary;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public double getExperienceBonus() {
		return experienceBonus;
	}

	public void setExperienceBonus(double experienceBonus) {
		this.experienceBonus = experienceBonus;
	}

	public double getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}

	@Override
	public double calcSalary() {
		double totalSalary = baseSalary + experienceBonus;
		return totalSalary;
	}

	@Override
	public double experienceBonus() {
		double experienceBonus = getExperience() * 100;
		return experienceBonus;
	}
}
