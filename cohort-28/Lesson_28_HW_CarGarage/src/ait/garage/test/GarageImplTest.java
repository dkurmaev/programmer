package ait.garage.test;

import ait.garage.dao.Garage;
import ait.garage.dao.GarageImpl;
import ait.garage.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageImplTest {

	Garage garage;
	Car[] cars;

	/*
	Метод setUp инициализирует объект garage типа GarageImpl с вместимостью 4 автомобиля и добавляет три автомобиля в гараж.
	 */
	@BeforeEach
	void setUp() {
		garage = new GarageImpl(4); // Создание объекта гаража с вместимостью 4 автомобиля
		cars = new Car[3];
		cars[0] = new Car("BTM7997", "E200","Mercedes", 1.8, "Silver");
		cars[1] = new Car("BTM9903", "318ti","BMW", 1.8, "Green-Blue");
		cars[2] = new Car("BTM7321", "Omega","Opel", 2.4,"Black");
		for (int i = 0; i < cars.length; i++) {
			garage.addCar(cars[i]); // Добавление автомобилей в гараж
		}
	}

	/*
	Метод addCar тестирует метод addCar класса GarageImpl.
	Проверяется возможность добавления автомобилей в гараж, включая случаи с null-автомобилем и автомобилем с существующим регистрационным номером.
	 */
	@Test
	void addCar() {
		assertFalse(garage.addCar(null)); // Проверка добавления null-автомобиля
		assertFalse(garage.addCar(cars[2])); // Проверка добавления автомобиля с существующим регистрационным номером
		Car car = new Car("BTM8998", "Sephia", "KIA", 1.4, "Grey");
		assertTrue(garage.addCar(car)); // Проверка успешного добавления нового автомобиля
		assertEquals(4, garage.capacity()); // Проверка вместимости гаража после добавления автомобиля
		car = new Car("BTM8968", "Sephia", "KIA", 1.4, "Grey");
		assertFalse(garage.addCar(car)); // Проверка невозможности добавления автомобиля из-за достижения максимальной вместимости
	}

	/*
	Метод removeCar тестирует метод removeCar класса GarageImpl.
	Проверяется возможность удаления существующего автомобиля, а также удаления несуществующего автомобиля и проверка результатов удаления.
	 */
	@Test
	void removeCar() {
		assertEquals(cars[1], garage.removeCar("BTM9903")); // Проверка удаления существующего автомобиля
		assertEquals(4, garage.capacity()); // Проверка вместимости гаража после удаления автомобиля
		assertNull(garage.removeCar("BTM9903")); // Проверка удаления несуществующего автомобиля
		assertNull(garage.findCarByRegNumber("BTM9903")); // Проверка поиска несуществующего автомобиля по регистрационному номеру
	}

	/*
	Метод findCarByRegNumber тестирует метод findCarByRegNumber класса GarageImpl.
	Проверяется возможность поиска автомобилей по регистрационному номеру, включая случай поиска несуществующего автомобиля.
	 */
	@Test
	void findCarByRegNumber() {
		assertEquals(cars[0], garage.findCarByRegNumber("BTM7997")); // Проверка поиска существующего автомобиля по регистрационному номеру
		assertNull(garage.findCarByRegNumber("BKU6596")); // Проверка поиска несуществующего автомобиля по регистрационному номеру
	}

	/*
	Методы findCarsByModel, findCarsByCompany и findCarsByColor тестируют соответствующие
	методы класса GarageImpl для поиска автомобилей по модели, компании-производителю и цвету.
	 */
	@Test
	void findCarsByModel() {
		Car[] actual = garage.findCarsByModel("318ti"); // Поиск автомобилей с указанной моделью
		Car[] expected = {cars[1]};
		assertArrayEquals(expected, actual); // Проверка соответствия ожидаемого и фактического массивов автомобилей
		assertArrayEquals(new Car[0],garage.findCarsByModel("Toyota")); // Проверка поиска автомобилей с несуществующей моделью

	}

	@Test
	void findCarsByCompany() {
		Car[] actual = garage.findCarsByCompany("Mercedes"); // Поиск автомобилей с указанной компанией-производителем
		Car[] expected = {cars[0]};
		assertArrayEquals(expected, actual); // Проверка соответствия ожидаемого и фактического массивов автомобилей
		assertArrayEquals(new Car[0],garage.findCarsByCompany("Toyota")); // Проверка поиска автомобилей с несуществующей компанией-производителем
	}

	@Test
	void findCarsByColor() {
		Car[] actual = garage.findCarsByColor("Green-Blue"); // Поиск автомобилей с указанным цветом
		Car[] expected = {cars[1]};
		assertArrayEquals(expected, actual); // Проверка соответствия ожидаемого и фактического массивов автомобилей
		assertArrayEquals(new Car[0],garage.findCarsByColor("Gold"));// Проверка поиска автомобилей с несуществующим цветом

	}
	@Test
	void findCarsByEngine(){
		Car[] actual = garage.findCarsByEngine(1.5, 2.0);
		Car[] expected = {cars[0], cars[1]};
		assertArrayEquals(expected, actual);

	}



}
