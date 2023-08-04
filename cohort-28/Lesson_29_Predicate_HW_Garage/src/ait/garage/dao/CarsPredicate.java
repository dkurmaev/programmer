package ait.garage.dao;

import ait.garage.model.Car;

import java.util.function.Predicate;

public class CarsPredicate implements Predicate<Car> {

	private String model;

	public CarsPredicate(String model) {
		this.model = model;
	}

	@Override
	public boolean test(Car car) {
		return car.getModel() == model;
	}
}
