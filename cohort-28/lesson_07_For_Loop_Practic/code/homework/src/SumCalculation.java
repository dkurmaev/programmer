import java.util.Scanner;
//программа, которая вычисляет сумму чисел от 1 до 1/n. n вводится с клавиатуры.
public class SumCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input n: ");
//Программа сначала запрашивает значение n с помощью класса Scanner
        int n = scanner.nextInt();
//Затем она инициализирует переменную sum суммой, равной нулю.
        double sum = 0;

// В цикле for происходит итерация от 1 до n, и на каждой итерации значение 1/i добавляется к сумме sum.
        for (int i = 1; i <= n; i++) {
// использование 1.0 / i, чтобы выполнить деление с плавающей точкой, чтобы результат был вещественным числом.
            sum += 1.0 / i;
        }

        System.out.println("Summ from 1 to 1/" + n + " is " + sum);
    }
}
