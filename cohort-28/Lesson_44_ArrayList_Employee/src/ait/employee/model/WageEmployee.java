package ait.employee.model;

/**
 Класс WageEmployee представляет собой сотрудника, оплачиваемого почасово.
 Он наследует класс Employee и добавляет дополнительное свойство и методы, специфичные для сотрудников, оплачиваемых почасово.
 */
public class WageEmployee extends Employee {
	private double wage; // Почасовая ставка сотрудника

	/**
	 Конструктор объекта WageEmployee с указанными идентификатором, именем, фамилией, отработанными часами и почасовой ставкой.	 *
	 id         идентификатор сотрудника
	 firstName  имя сотрудника
	 lastName   фамилия сотрудника
	 hours      количество отработанных часов сотрудником
	 wage       почасовая ставка сотрудника
	 */
	public WageEmployee(int id, String firstName, String lastName, double hours, double wage) {
		super(id, firstName, lastName, hours);
		this.wage = wage;
	}

	/**
	 Возвращает почасовую ставку сотрудника.
	 почасовая ставка сотрудника
	 */
	public double getWage() {
		return wage;
	}

	/**
	 Устанавливает почасовую ставку сотрудника.
	 wage почасовая ставка сотрудника
	 */
	public void setWage(double wage) {
		this.wage = wage;
	}



	public double calcSalary() {
		double salary = hours * wage;
		return salary;
	}

	@Override
	public double getTotalSales() {
		return 0;
	}

}