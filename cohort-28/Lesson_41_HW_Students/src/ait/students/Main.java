package ait.students;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> studentNames = new ArrayList<>();

		System.out.print("Введите размер списка: ");
		int size = scanner.nextInt();

		// Очистка буфера после ввода числа
		scanner.nextLine();

		for (int i = 0; i < size; i++) {
			System.out.print("Введите фамилию студента: ");
			String name = scanner.nextLine();
			// Добавление фамилии в начало списка
			studentNames.add(0, name);
		}

		System.out.println("Получившийся список:");
		for (String name : studentNames) {
			System.out.println(name);
		}
	}
}
