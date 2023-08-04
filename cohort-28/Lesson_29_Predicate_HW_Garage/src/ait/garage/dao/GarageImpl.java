package ait.garage.dao;

import ait.garage.model.Car;

import java.util.function.Predicate;

public class GarageImpl implements Garage {

	private Car[] cars;
	private int size;
	private int capacity;

	public GarageImpl(int capacity) {
		this.capacity = capacity;
		cars = new Car[capacity];
	}

	@Override
	public boolean addCar(Car car) {
		if (car == null || size == capacity || findCarByRegNumber(car.getRegNumber()) != null) {
			return false;
		}
		cars[size++] = car;
		return true;
	}

	@Override
	public Car removeCar(String regNumber) {
		for (int i = 0; i < size; i++) {
			if (cars[i].getRegNumber().equals(regNumber)) {
				Car removedCar = cars[i];
				cars[i] = cars[--size];
				cars[size] = null;
				return removedCar;
			}
		}
		return null;
	}

	@Override
	public Car findCarByRegNumber(String regNumber) {
		for (int i = 0; i < size; i++) {
			if (cars[i].getRegNumber().equals(regNumber)) {
				return cars[i];
			}
		}
		return null;
	}

	@Override
	public Car[] findCarsByModel(String model) {
		return findCarsByPredicate(c -> c.getModel().equals(model));
	}

	@Override
	public Car[] findCarsByCompany(String company) {
		return findCarsByPredicate(c -> c.getCompany().equals(company));
	}

	@Override
	public Car[] findCarsByEngine(double min, double max) {
		return findCarsByPredicate(car -> car.getEngine() >= min && car.getEngine() < max);
	}

	@Override
	public Car[] findCarsByColor(String color) {
		return findCarsByPredicate(car -> car.getColor().equals(color));
	}

	@Override
	public int capacity() {
		return capacity;
	}

	public void printCars() {
		for (int i = 0; i < size; i++) {
			System.out.println(cars[i]);
		}
	}

	public int getSize() {
		return size;
	}

	private Car[] findCarsByPredicate(Predicate<Car> predicate) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (predicate.test(cars[i])) {
				count++;
			}
		}
		Car[] res = new Car[count];
		for (int i = 0, j = 0; j < res.length; i++) {
			if (predicate.test(cars[i])) {
				res[j++] = cars[i];
			}
		}
		return res;
	}
}
