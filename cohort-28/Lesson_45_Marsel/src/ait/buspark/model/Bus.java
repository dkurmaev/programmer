package ait.buspark.model;

import java.util.ArrayList;

public class Bus {

	private final int MAX_PASSENGERS = 5; // максимальное количество пассажиров

	private String number;

	private Driver driver; // водитель

	private ArrayList<Passenger> passengers; // пассажиры

	private boolean isGoing; // true - если автобус едет, false - если автобус стоит
	//private Passenger[] passengers; // пассажиры

	public Bus(String number) {
		this.setNumber(number);
		this.passengers = new ArrayList<Passenger>();
	}

	/**
	 * Метод, который позволяет автобусу положить водителя
	 * Метод проверяет, чтобы водитель не был null, и при этом метод освобождает предыдущего водителя, если он был
	 *
	 * @param driver новый водитель
	 */
	void setDriver(Driver driver) {
		if (isGoing) { // если автобус едет - менять водителя нельзя
			System.err.println("На ходу водителя не меняют");
			return;
		}
		if (driver != null) { // проверяем, а не null-ли новый водитель
			if (this.driver != null) { // проверим, а не было ли предыдущего водителя
				System.out.println("Освобождаем " + this.driver.getFirstName());
				this.driver.free(); // если он был - освобождаем его от работы
			}
			System.out.println("Водителем автобуса <" + number + "> стал " + driver.getFirstName());
			this.driver = driver; // назначаем нового водителя
		} else { // если новый водитель - null
			// сообщаем об ошибке - нельзя класть null водителя
			throw new IllegalArgumentException("Нельзя положить null-водителя");
		}
	}

	/**
	 * Метод, который позволяет ехать автобусу
	 */
	void go() {
		if (this.isGoing) {
			// если автобус уже едет - не можем поехать еще раз
			System.err.println("Автобус уже едет");
			return; // останавливаем работу метода go, все, что дальше в этом методе - выполняться не будет
		}
		if (this.driver == null) {
			System.err.println("У автобуса нет водителя, поехать не можем");
		} else {
			System.out.println("Автобус под управлением " + driver.getFirstName() + " поехал");
			this.isGoing = true;
			for(Passenger passenger : passengers) {
				passenger.sayAbout();
			}
		}
	}
	/**
	 * Останавливает автобус
	 */
	public void stop() {
		System.out.println("Автобус <" + number + "> остановился");
		isGoing = false;
	}

	void addPassenger(Passenger passenger) {
		if (passenger == null) {
			System.err.println("Нельзя добавить null-пассажира");
			return;
		}
		if (isGoing) {
			System.err.println("Нельзя добавлять пассажиров на ходу");
			return;
		}
		if (passengers.size() < MAX_PASSENGERS) {
			System.out.println("Пассажир " + passenger.getName() + " сел в автобус");
			this.passengers.add(passenger);
		}

	}

	public void setNumber(String number) {
		if (number != null && !number.equals("")) {
			this.number = number;
		} else {
			this.number = "DEFAULT";
		}
	}

	public String getNumber() {
		return number;
	}

	public boolean isGoing() {
		return isGoing;
	}
	public boolean isFull() {
		return passengers.size() >= MAX_PASSENGERS;
	}
}