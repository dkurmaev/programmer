package dankur.estimates;

import java.io.*;
import java.util.Scanner;

public class Estimates {
    public static void main(String[] args) {
        double estimates[];  // Массив для хранения оценок
        double menu;  // Переменная для выбора пункта меню
        int quantity;  // Количество оценок

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the quantity of estimates:");
        quantity = scanner.nextInt();  // Получаем количество оценок от пользователя

        estimates = new double[quantity];  // Инициализация массива с указанным количеством элементов

        while (true) {
            System.out.println("\nEstimates Menu");
            System.out.println("(1) Add Estimates");
            System.out.println("(2) Display Estimates (for loop)");
            System.out.println("(3) Display Estimates (foreach loop)");
            System.out.println("(4) Save Estimates to File");
            System.out.println("(5) Exit");
            System.out.println("Please enter your choice:");

            menu = scanner.nextDouble();  // Получаем выбор пользователя

            switch ((int) menu) {
                case 1 -> {
                    System.out.println("Please enter the estimates:");
                    for (int i = 0; i < quantity; i++) {
                        estimates[i] = scanner.nextDouble();  // Заполняем массив оценками, введенными пользователем
                    }
                }
                case 2 -> {
                    System.out.println("Displaying Estimates (for loop):");
                    for (int i = 0; i < quantity; i++) {
                        System.out.println(estimates[i]);  // Выводим оценки с использованием цикла for
                    }
                }
                case 3 -> {
                    System.out.println("Displaying Estimates (foreach loop):");
                    for (double estimate : estimates) {
                        System.out.println(estimate);  // Выводим оценки с использованием цикла foreach
                    }
                }
                case 4 -> {
                    System.out.println("Saving Estimates to File...");
                    saveEstimatesToFile(estimates);
                    System.out.println("Estimates saved to file.");
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    return;  // Выходим из программы
                }
                default -> System.out.println("Please enter a valid choice");
            }
        }
    }

    private static void saveEstimatesToFile(double[] estimates) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("estimates.txt"))) {
            for (double estimate : estimates) {
                writer.write(Double.toString(estimate));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
