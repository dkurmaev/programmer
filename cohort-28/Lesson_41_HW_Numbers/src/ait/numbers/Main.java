package ait.numbers;

import java.util.ArrayList;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();
		Random random = new Random();

		// Заполнение массива/списка случайными числами от 1 до 10
		for (int i = 0; i < 100; i++) {
			int randomNumber = random.nextInt(10) + 1;
			numbers.add(randomNumber);
		}

		// Подсчет пар элементов, равных друг другу
		int countPairs = 0;
		for (int i = 0; i < numbers.size(); i++) {
			int currentNumber = numbers.get(i);
			for (int j = i + 1; j < numbers.size(); j++) {
				int nextNumber = numbers.get(j);
				if (currentNumber == nextNumber) {
					countPairs++;
				}
			}
		}

		System.out.println("Полученный список: " + numbers);
		System.out.println("Количество пар элементов, равных друг другу: " + countPairs);
	}
}

