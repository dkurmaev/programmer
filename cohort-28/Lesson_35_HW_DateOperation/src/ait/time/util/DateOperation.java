package ait.time.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class DateOperation {
	public static void main(String[] args) {
		// Получаем дату рождения
		String birthDate = "23/09/1979";

		// Вычисляем и выводим возраст
		int age = DateOperation.getAge(birthDate);
		System.out.println("Age: " + age);

		// Исходный массив дат
		String[] dates = {"2000-12-01", "10/12/2000", "1970-08-12", "2010-10-05"};
		System.out.println("Original Dates:");

		// Перебираем исходный массив дат, парсим каждую дату и выводим ее
		for (int i = 0; i < dates.length; i++) {
			System.out.println(dateParse(dates[i]));
		}

		System.out.println("==========================================");

		// Сортируем массив дат и сохраняем отсортированные даты в новом массиве
		String[] sortedDates = sortStringDates(dates);
		System.out.println("Sorted Dates:");

		// Перебираем отсортированный массив дат, парсим каждую дату и выводим ее
		for (int i = 0; i < sortedDates.length; i++) {
			System.out.println(dateParse(sortedDates[i]));
		}

	}

	// Метод для вычисления возраста на основе даты рождения
	public static int getAge(String birthDate) {

		// Получаем текущую дату
		LocalDate today = LocalDate.now();
		System.out.println("Current Date today is: " + today);
		System.out.println("==========================================");

		// Парсим дату рождения и вычисляем возраст
		LocalDate danil = dateParse(birthDate);
		System.out.println("Danil date of birth:" + danil);
		long age = ChronoUnit.YEARS.between(danil, today);
		return (int) age;
	}

	// Метод для сортировки массива строковых дат в порядке возрастанияс с
	// использованием компаратора, основанного на методе dateParse(), и возвращает отсортированный массив.
	public static String[] sortStringDates(String[] dates) {

		// Создаем копию исходного массива
		String[] copy = Arrays.copyOf(dates, dates.length);
		// Сортируем копию массива с использованием лямбда-выражения для сравнения дат используем
		// лямбда-выражение (date1, date2) -> {...}, чтобы определить компаратор для сортировки массива copy.
		// Внутри лямбда-выражения мы инициализируем переменные localDate1 и localDate2,
		// используя метод dateParse(date), а затем сравниваем их с помощью compareTo()
		Arrays.sort(copy, (date1, date2) -> {
			LocalDate localDate1 = dateParse(date1);
			LocalDate localDate2 = dateParse(date2);
			return localDate1.compareTo(localDate2);
		});
		return copy;
	}


	// Метод для парсинга строки даты в объект LocalDate
	private static LocalDate dateParse(String date) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]");
		return LocalDate.parse(date, df);
	}
}
