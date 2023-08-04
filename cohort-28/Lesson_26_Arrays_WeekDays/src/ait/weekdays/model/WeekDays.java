package ait.weekdays.model;

import java.util.Arrays;

public class WeekDays {
	public static void main(String[] args) {
		String[] daysOfWeek = new String[7];
		// Заполняем массив
		daysOfWeek[0] = "Monday";
		daysOfWeek[1] = "Tuesday";
		daysOfWeek[2] = "Wednesday";
		daysOfWeek[3] = "Thursday";
		daysOfWeek[4] = "Friday";
		daysOfWeek[5] = "Saturday";
		daysOfWeek[6] = "Sunday";
		printArray(daysOfWeek);
		System.out.println("============================================================");

		for (int i = 0; i < daysOfWeek.length; i++) {
			String temp = daysOfWeek[i]; // Сохраняем первый элемент (Понедельник) во временной переменной
			daysOfWeek[i] = daysOfWeek[6]; // Заменяем первый элемент на последний (Воскресенье)
			daysOfWeek[6] = temp; // Заменяем последний элемент на сохраненный первый (Понедельник)

		}

		printArray(daysOfWeek);
	}

	public static void printArray(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr));
		}
	}
}
