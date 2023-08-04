package ait.car;

import ait.car.model.Car;

public class CarAppl {
    public static void main(String[] args) {
        Car car1 = new Car(" Toyota", " Camry", " Japan", " XLE", " 1ABC123", 2022, 25000.0,
                2.5, "Petrol", 180.0, 5000,  false);
        car1.display();
        car1.startEngine();
        car1.move();
        car1.stop();
        car1.updateMileage(6000);
        Engine engine1 = new Engine(" OTTO ", " BMW ", " Germany ", " 318i ", " 13213543424Ae", 1993, 1500,
                1.8, "Benzin", 180, 150000, true, "Schalter  ");
        engine1.display();
        engine1.startEngine();
        engine1.move();
        engine1.stop();
        engine1.changeMileage(300);
        Motorcycle motorcycle1 = new Motorcycle(" Suzuki", " Suzuki", " Japan", " XR3", " 544564313431g", 2023, 15000.0,
                1.5, "Disel", 150.0, 8000, true, "Sport  ");
        motorcycle1.display();
        motorcycle1.startEngine();
        motorcycle1.move();
        motorcycle1.stop();
        motorcycle1.changeMileage(150);
        ElectricCar electricCar1 = new ElectricCar(" Kawasaki", " Kawasaki", " Japan", " Z1", " V546413414651544", 2022, 35000.0,
                2.5, "Electric", 220.0, 12000, false,  500);

        electricCar1.display();
        electricCar1.startEngine();
        electricCar1.move();
        electricCar1.stop();
        electricCar1.changeMileage(400);



    }
}


