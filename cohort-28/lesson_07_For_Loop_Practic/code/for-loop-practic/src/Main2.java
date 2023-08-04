import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Sum from 1 to n , n - input from user");
        // подсчитать сумму всех чисел до введенного n (n- это натуральное числа)
        // Алгоритм
        // 1 + 2 + ....... + 999 + 1000
        // 1 + 1000 = 1001, 2 + 999 = 1001, таких пар = 500
        // 500 * 1001 = 500500

        Scanner scanner = new Scanner(System.in);
             System.out.print("Input N: ");
             int n = scanner.nextInt(); // принимаем число с клавиатуры ( get number from user )

        int sum = 0;

        for (int i = 1; i <= n; i++) { //
            sum += i; //

            }

        System.out.println("Sum the numbers: " + n + " = " + sum);
    }
}
