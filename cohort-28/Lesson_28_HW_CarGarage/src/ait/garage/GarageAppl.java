package ait.garage;

import ait.garage.dao.Garage;
import ait.garage.dao.GarageImpl;
import ait.garage.model.Car;

public class GarageAppl {
	public static void main(String[] args) {
		GarageImpl garage = new GarageImpl(4);
		garage.addCar(new Car("BTM7997", "E200","Mercedes", 1.8, "Silver"));
		garage.addCar(new Car("BTM7987", "316","BMW", 1.8, "Silver"));

		System.out.println("Autos in Garage: " + garage.getSize());
		System.out.println("==================================================================================================");
		//Car car = garage.findCarByRegNumber("BTM7997");
		//System.out.println(car);
		System.out.println("==================================================================================================");
		garage.printCars();




	}
}
