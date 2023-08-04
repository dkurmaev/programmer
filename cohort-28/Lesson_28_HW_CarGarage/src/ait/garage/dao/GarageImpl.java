package ait.garage.dao;

import ait.garage.model.Car;

public class GarageImpl implements Garage {

	private Car[] cars; // Массив для хранения автомобилей
	private int size; // Текущий размер гаража (количество автомобилей)
	private int capacity; // Максимальная вместимость гаража

	public GarageImpl(int capacity) {
		this.capacity = capacity;
		cars = new Car[capacity]; // Создание массива автомобилей с заданной вместимостью
	}

	@Override
	public boolean addCar(Car car) {
		// Проверка наличия места в гараже и отсутствия автомобиля с таким же регистрационным номером
		if (car == null || size == capacity || findCarByRegNumber(car.getRegNumber()) != null) {
			return false; // Возвращаем false, если автомобиль не может быть добавлен
		}
		cars[size++] = car; // Добавляем автомобиль в гараж и увеличиваем размер
		return true; // Возвращаем true, если автомобиль успешно добавлен
	}

	@Override
	public Car removeCar(String regNumber) {
		for (int i = 0; i < size; i++) {
			if (cars[i].getRegNumber().equals(regNumber)) {
				Car removedCar = cars[i];
				cars[i] = cars[--size]; // Заменяем удаляемый автомобиль последним автомобилем в массиве
				cars[size] = null; // Устанавливаем последний элемент массива как null
				return removedCar; // Возвращаем удаленный автомобиль
			}
		}
		return null; // Возвращаем null, если автомобиль с указанным регистрационным номером не найден
	}

	@Override
	public Car findCarByRegNumber(String regNumber) {
		for (int i = 0; i < size; i++) {
			if (cars[i].getRegNumber().equals(regNumber)) {
				return cars[i]; // Возвращаем найденный автомобиль
			}
		}
		return null; // Возвращаем null, если автомобиль с указанным регистрационным номером не найден
	}

	@Override
	public Car[] findCarsByModel(String model) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (cars[i].getModel().equals(model)) {
				count++;
			}
		}
		Car[] res = new Car[count];
		for (int i = 0, j = 0; i < size; i++) {
			if (cars[i].getModel().equals(model)) {
				res[j++] = cars[i];
			}
		}
		return res; // Возвращаем массив автомобилей с указанной моделью
	}

	@Override
	public Car[] findCarsByCompany(String company) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (cars[i].getCompany().equals(company)) {
				count++;
			}
		}
		Car[] res = new Car[count];
		for (int i = 0, j = 0; i < size; i++) {
			if (cars[i].getCompany().equals(company)) {
				res[j++] = cars[i];
			}
		}
		return res; // Возвращаем массив автомобилей с указанной компанией-производителем
	}

	@Override
	public Car[] findCarsByEngine(double min, double max) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (cars[i].getEngine() >= min && cars[i].getEngine() < max) {
				count++;
			}
		}
		Car[] res = new Car[count];
		for (int i = 0, j = 0; i < size; i++) {
			if (cars[i].getEngine() >= min && cars[i].getEngine() < max) {
				res[j++] = cars[i];
			}
		}
		return res; // Возвращаем массив автомобилей с указанным диапазоном объема двигателя
	}

	@Override
	public Car[] findCarsByColor(String color) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (cars[i].getColor().equals(color)) {
				count++;
			}
		}
		Car[] res = new Car[count];
		for (int i = 0, j = 0; i < size; i++) {
			if (cars[i].getColor().equals(color)) {
				res[j++] = cars[i];
			}
		}
		return res; // Возвращаем массив автомобилей с указанным цветом
	}

	@Override
	public int capacity() {
		return capacity; // Возвращаем максимальную вместимость гаража
	}

	public void printCars() {
		for (int i = 0; i < size; i++) {
			System.out.println(cars[i]);

		}
	}
	public int getSize() {
		return size;
	}
}
