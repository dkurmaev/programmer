import java.util.Scanner;
//В сберкассу на трёхпроцентный вклад положили S рублей.Какой станет сумма вклада через N лет.
public class DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter deposit amount (S): ");
        double deposit = scanner.nextDouble();

        System.out.print("Enter number of years (N): ");
        int years = scanner.nextInt();

        double interestRate = 0.03; // 3% годовых
        for (int i = 1; i <= years; i++) {
            deposit += deposit * interestRate;
        }

        System.out.println("Deposit after " + years + " years: " + deposit + " €");
    }
}
