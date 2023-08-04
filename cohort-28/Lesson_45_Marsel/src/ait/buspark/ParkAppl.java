package ait.buspark;

import ait.buspark.model.Bus;
import ait.buspark.model.Driver;
import ait.buspark.model.Passenger;

public class ParkAppl {
	public static void main(String[] args) {
		Bus bus = new Bus("A001AA");
		Bus bus2 = new Bus("A002AA");
		Driver roman = new Driver("Roman", "Popov", 12);
		roman.setBus(bus);
		Passenger oksana = new Passenger("Oksana");
		Passenger lena = new Passenger("Lena");
		Passenger timur = new Passenger("Timur");
		Passenger serhii = new Passenger("Serhii");
		Passenger volodymyr = new Passenger("Volodymyr");
		Passenger vrednyi = new Passenger("Vrednyi");
		oksana.goToBus(bus);
		lena.goToBus(bus);
		timur.goToBus(bus);
		serhii.goToBus(bus);
		volodymyr.goToBus(bus);
		roman.drive();
		vrednyi.goToBus(bus);
		volodymyr.goToBus(bus2);
		vrednyi.sayAbout();
		volodymyr.sayAbout();

//		Driver danil = new Driver("Danil", "Kurmayev", 19);
//		danil.setBus(bus);
//		danil.drive();
//		roman.setBus(bus);
//		bus.stop();
//		roman.drive();
	}
}
