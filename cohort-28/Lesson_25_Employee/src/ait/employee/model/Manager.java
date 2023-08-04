package ait.employee.model;
/**
  Класс Manager представляет собой менеджера, который является сотрудником.
  Он наследует класс Employee и добавляет дополнительные свойства и методы, специфичные для менеджеров.
 */

public class Manager extends Employee {
	private double baseSalary;   // Базовая зарплата менеджера
	private int grade;           // Уровень менеджера


	/**
	 Конструктор объекта Manager с указанными идентификатором, именем, фамилией, отработанными часами, базовой зарплатой и уровнем.
	 id          идентификатор менеджера
	 firstName   имя менеджера
	 lastName    фамилия менеджера
	 hours       количество отработанных часов менеджером
	 baseSalary  базовая зарплата менеджера
	 grade       уровень менеджера
	 */
	public Manager(int id, String firstName, String lastName, double hours, double baseSalary, int grade) {
		super(id, firstName, lastName, hours);
		this.baseSalary = baseSalary;
		this.grade = grade;
	}

	/**
	 Возвращает базовую зарплату менеджера.
	 базовая зарплата менеджера
	 */
	public double getBaseSalary() {
		return baseSalary;
	}

	/**
	 Устанавливает базовую зарплату менеджера.
	 baseSalary базовая зарплата менеджера
	 */
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	/**
	  Возвращает уровень менеджера.
	 уровень менеджера
	 */
	public int getGrade() {
		return grade;
	}

	/**
	Устанавливает уровень менеджера.
	grade уровень менеджера
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}
	/**
	 Вычисляет и возвращает зарплату менеджера.
	 Зарплата вычисляется путем сложения базовой зарплаты и произведения уровня и отработанных часов менеджера.
	  вычисленная зарплата менеджера
	 */
	@Override
	public double calcSalary() {
		double salary = baseSalary + grade * hours;
		return salary;
	}

}