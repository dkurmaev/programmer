import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите натуральное число n: ");
        int n = scanner.nextInt();

        int factorial = calculateFactorial(n);

        System.out.println("Факториал числа " + n + " равен " + factorial);
    }
//метод, который получает на вход n и вычисляет n! = 1 * 2 * 3 *... * n. factorial
    public static int calculateFactorial(int n) {
        int factorial = 1;
//После ввода натурального числа n с клавиатуры, программа вычислит факториал числа n и выведет результат.
        for (int i = 1; i <= n; i++) {
            factorial *= i;
//Программа будет проверять каждое значение n на переполнение памяти и выводить сообщение только при первом обнаружении переполнения.
            if (factorial < 0) {
                System.out.println("Переполнение памяти при n = " + i);
                break;
            }

        }
        return factorial;
    }
}