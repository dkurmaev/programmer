import java.util.Scanner;
//Найти произведение двузначных нечетных чисел кратных 13.
public class OddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int product = 1;

        System.out.print("Enter the number of number pairs: ");

// переменная pairsCount, которая определяет количество пар чисел, которые нужно ввести с клавиатуры.
        int pairsCount = scanner.nextInt();
//цикле for происходит ввод пар чисел с помощью scanner.nextInt()
        for (int i = 0; i < pairsCount; i++) {
            System.out.println("Please enter a couple of numbers. #" + (i + 1) + ":");
            System.out.print("First number: ");
            int number1 = scanner.nextInt();
            System.out.print("Second number: ");
            int number2 = scanner.nextInt();
//Для каждого числа проверяется, является ли оно двузначным нечетным числом, кратным 13.
            if (number1 % 13 == 0 && number1 % 2 != 0) {
                product *= number1;//Если это так, то оно умножается на переменную product.
            }

            if (number2 % 13 == 0 && number2 % 2 != 0) {
                product *= number2;//Если это так, то оно умножается на переменную product.
            }
        }

        System.out.println("Product of two-digit odd numbers divisible by 13: " + product);
    }
}
