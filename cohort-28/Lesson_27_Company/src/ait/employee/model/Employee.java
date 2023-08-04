package ait.employee.model;

import java.util.Objects;

/**
 Абстрактный класс Employee представляет базовый класс для сотрудников.
 Он предоставляет общие свойства и методы для управления данными о сотрудниках.
 */
public abstract class Employee {
	protected final int id; // Идентификатор сотрудника
	protected String firstName; // Имя сотрудника
	protected String lastName; // Фамилия сотрудника
	protected double hours; // Количество отработанных часов сотрудником

	/**
	 Конструктор объекта Employee с указанным идентификатором, именем, фамилией и отработанными часами.
	 id        идентификатор сотрудника
	 firstName имя сотрудника
	 lastName  фамилия сотрудника
	 hours     количество отработанных часов сотрудником
	 */
	public Employee(int id, String firstName, String lastName, double hours) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hours = hours;
	}

	/**
	 Возвращает идентификатор сотрудника.
	 идентификатор сотрудника
	 */

	public int getId() {
		return id;
	}

	/**
	 Возвращает имя сотрудника.
	 имя сотрудника
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 Устанавливает имя сотрудника.
	 firstName имя сотрудника
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 Возвращает фамилию сотрудника.
	 фамилия сотрудника
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 Устанавливает фамилию сотрудника.
	 lastName фамилия сотрудника
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 Возвращает количество отработанных часов сотрудником.
	 количество отработанных часов сотрудником
	 */
	public double getHours() {
		return hours;
	}

	/**
	 Устанавливает количество отработанных часов сотрудником.
	 hours количество отработанных часов сотрудником
	 */
	public void setHours(double hours) {
		this.hours = hours;
	}

	/**
	 Сравнивает этот объект Employee с указанным объектом на равенство.
	 Возвращает true, если указанный объект также является Employee и имеет тот же идентификатор, иначе возвращает false.	 *
	 "o" объект, с которым сравнивается данный Employee на равенство
	 true, если указанный объект равен данному Employee, иначе false
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return id == employee.id;
	}

	/**
	 Возвращает хеш-код для данного объекта Employee.
	 Хеш-код основан на идентификаторе сотрудника.
	 хеш-код для данного объекта Employee
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/**
	 Возвращает строковое представление данного объекта Employee.
	 Строка содержит информацию об идентификаторе, имени, фамилии, отработанных часах и расчитанной зарплате сотрудника.
	 строковое представление данного объекта Employee
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Employee ");
		sb.append("id=").append(id);
		sb.append(", firstName='").append(firstName).append('\'');
		sb.append(", lastName='").append(lastName).append('\'');
		sb.append(", hours=").append(hours);
		sb.append(", salary=").append(calcSalary());
		return sb.toString();
	}

	public abstract double calcSalary(); //абстрактный метод calcSalary(), который должен быть реализован в подклассах для расчета зарплаты сотрудника.


	public abstract double getTotalSales(); //абстрактный метод getTotalSales(), который должен быть реализован в подклассах для расчета продаж.
}