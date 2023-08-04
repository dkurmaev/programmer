package ait.computer;

import ait.computer.dao.ComputerShop;
import ait.computer.model.Computer;
import ait.computer.model.Laptop;
import ait.computer.model.Smartphone;

import java.util.Scanner;

public class ComputerAppl {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Создание объекта ComputerShop с емкостью  компьютеров
        ComputerShop computerShop = new ComputerShop(10);


        // Добавление компьютеров в магазин
        computerShop.addComputer(new Computer(1234556788, "Asus", "I7", 32, 2000)); // Некорректный Id
        Laptop laptop = new Laptop(123456789, "Lenovo", "I5", 1000, 2000, 6.5, 3.5);
        computerShop.addComputer(laptop);
        Smartphone smartphone = new Smartphone(123456787, "Samsung", "CortexA8", 16, 32, 10.5, 316, 5464684686L);
        computerShop.addComputer(smartphone);

        //  Scanner для чтения данных с консоли
        System.out.println("Enter information about the new computer");
        System.out.println("_________________________________________");
        System.out.print("Enter the new computer Barcode: ");
        long barCode = scanner.nextLong();
        scanner.nextLine(); // Чтение символа новой строки после чтения числа
        int barCode_Length = Computer.barCode_Length;
        if (String.valueOf(barCode).length() != Computer.barCode_Length) {
            System.out.println("Wrong Barcode!");
            return; // Прекращение выполнения программы
        }

        System.out.print("Enter the brand of the new computer: ");
        String brand = scanner.nextLine();

        System.out.print("Enter the CPU of the new computer: ");
        String cpu = scanner.nextLine();

        System.out.print("Enter the DDRAM of the new computer: ");
        int ddram = Integer.parseInt(scanner.nextLine());// преобразует считанную строку в целое число типа int.

        System.out.print("Enter the SSD of the new computer: ");
        int ssd = Integer.parseInt(scanner.nextLine());// преобразует считанную строку в целое число типа int.

        //System.out.print("Enter the Hours of the new computer: ");
        //int hours = Integer.parseInt(scanner.nextLine());//

        //System.out.print("Enter the Weight of the new computer: ");
        //int weight = Integer.parseInt(scanner.nextLine());//

        //System.out.print("Enter the Imei of the new computer: ");
        //int imei = Integer.parseInt(scanner.nextLine());//

        //Создание нового компьютера на основе введенных данных
        Computer newComputer = new Computer(barCode, brand, cpu, ddram, ssd);
        //Laptop newLaptop = new Laptop(barCode, brand, cpu, ddram, ssd, hours, weight);
        //Smartphone newSmartphone  = new Smartphone(barCode, brand, cpu, ddram, ssd, hours, weight, imei);


        // Добавление нового компьютера в магазин
        computerShop.addComputer(newComputer);
        System.out.println("=====================================================================================================================================================");


        // Вывод информации о компьютерах в магазине // Вывод информации о ёмкости магазина
        System.out.println("Computers in the shop:" + computerShop.getSize());
        computerShop.printComputers();
        System.out.println("=====================================================================================================================================================");


        // Поиск компьютера по заданному Id
        System.out.println("Computer with Id 123456789 was found: ");
        System.out.println(computerShop.findComputer(123456789));
        System.out.println("=====================================================================================================================================================");
        System.out.println("Computer with Id 123624789 was not found: ");
        System.out.println(computerShop.findComputer(123624789));
        System.out.println("=====================================================================================================================================================");

        // Добавление новых компьютеров в магазин
        Laptop laptop2 = new Laptop(123456123, "HP", "I3", 8, 100, 5, 5); // Корректный Id
        Laptop laptop1 = new Laptop(98745895, "HP", "I3", 8, 100, 5, 5); // Некорректный Id
        computerShop.addComputer(laptop1);
        computerShop.addComputer(laptop2);
        Smartphone smartphone1 = new Smartphone(568456787, "Samsung", "CortexA8", 16, 32, 10.5, 316, 5464684686L);
        computerShop.addComputer(smartphone1);
        Smartphone smartphone2 = new Smartphone(566956787, "Samsung", "CortexA8", 16, 32, 10.5, 316, 5464684686L);
        computerShop.addComputer(smartphone2);
        // Вывод обновленного списка компьютеров в магазине
        System.out.println("Computers in the shop after add: " + computerShop.getSize());
        computerShop.printComputers();
        System.out.println("====================================================================================================================================================");


        // Удаление компьютера по заданному Id
        System.out.println("Removing computer with Id 568456787");
        computerShop.removeComputer(568456787);
        System.out.println("====================================================================================================================================================");

        // Вывод обновленного списка компьютеров в магазине
        System.out.println("Computers in the shop after removal: " + computerShop.getSize());
        computerShop.printComputers();
        System.out.println("===================================================================================================================================================");

        // Вывод информации о ёмкости магазина после удаления
        System.out.println("Capacity of the shop after removal: " + computerShop.getSize());
        scanner.close();

    }
}


