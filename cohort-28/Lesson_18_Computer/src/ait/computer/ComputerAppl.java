package ait.computer;

import ait.computer.model.Computer;
import ait.computer.model.Laptop;
import ait.computer.model.Smartphone;

public class ComputerAppl {
    public static void main(String[] args) {
        //double x = 3.1; // Создается переменная x типа double и ей присваивается значение 3.1.
        //int y = (int) x; // переменная y типа int, и в нее приводится значение переменной x путем явного приведения типа.
        // В результате значение y будет равно 3.

        Computer[] computers = new Computer[3];// Создается массив объектов типа Computer с размером 3.
        /*
        Создается объект типа Computer и присваивается первому элементу массива computers.

        Создается объект типа Laptop и присваивается второму элементу массива computers.
        Объект имеет дополнительные свойства, которые специфичны для ноутбука.

        Создается объект типа Smartphone и присваивается третьему элементу массива computers.
        Объект имеет дополнительные свойства, которые специфичны для смартфона.

        instanceof в Java используется для проверки, является ли объект экземпляром определенного класса или его подкласса.
         */

        computers[0] = new Computer("i5", 12, 512, "HP");
        computers[1] = new Laptop("i7", 16, 512, "Asus", 2.5, 2.1);
        computers[2] = new Smartphone("Snapdragon", 8, 128, "Samsung", 24, 0.15, 123456789098l);
        printArray(computers); //Вызывается метод printArray, который выводит на консоль информацию о каждом объекте в массиве computers.
        System.out.println("==========================================================================================================");
        int total = getTotalSSDCapacity(computers);//Вызывается метод getTotalSSDCapacity, который вычисляет и возвращает суммарную
        // емкость SSD для всех объектов в массиве computers. Результат сохраняется в переменной total.
        System.out.println("Total ssd capacity = " + total); //Выводится на консоль общая емкость SSD, полученная в предыдущем шаге.

        /*
        В данном примере проверяется, является ли объект computers[1] экземпляром класса Laptop.
        Если это так, то выполняются действия внутри блока кода, которые специфичны для объектов типа Laptop.
        Чтобы использовать свойства и методы, специфичные для Laptop, необходимо явно привести объект computers[1]
        к типу Laptop с помощью оператора приведения типа (Laptop).
         */
        if (computers[1] instanceof Laptop) {//Проверяется, является ли объект computers[1] экземпляром класса Laptop.
            // Если это так, выполняются определенные действия внутри блока кода.
            Laptop laptop = (Laptop) computers[1];
            System.out.println("Laptop Hours is: " + laptop.getHours());
            System.out.println("==========================================================================================================");
            laptop.setRam(20);//У объекта laptop изменяется значение свойства ram на 20.
            System.out.println(laptop);
            System.out.println(computers[1]);//Выводится на консоль информация о объекте laptop, используя его метод toString().
            System.out.println("==========================================================================================================");
        }
        if (computers[2] instanceof Laptop) {
            Laptop smartphone = (Laptop) computers[2];
            System.out.println("Smartphone Hours is: " + smartphone.getHours());
//          System.out.println(smartphone.getImei());
        }
        if (computers[0] instanceof Laptop) {
            Laptop computer = (Laptop) computers[0];
            System.out.println("Laptop Hours is: " + computer.getHours());
        }
        double totalHours = getTotalHours(computers);
        System.out.println("Total hours = " + totalHours);
    }

    public static int getTotalSSDCapacity(Computer[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += arr[i].getSsd();
        }
        return res;
    }

    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }
    }

    public static double getTotalHours(Computer[] arr) {
        double res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] instanceof Laptop) {
                Laptop laptop = (Laptop) arr[i];
                res += laptop.getHours(); //res = res + laptop.getHours();
            }
        }
        return res;
    }
}