import java.util.Scanner;
//Бизнесмен взял ссуду m тысяч рублей в банке под 10% годовых.
// Через сколько лет его долг превысит s тысяч рублей, если за это время он не будет отдавать долг.
public class Loan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод суммы ссуды
        System.out.println("Введите сумму ссуды (€): ");
        double loanAmount = scanner.nextDouble();

        // Ввод процентной ставки
        System.out.println("Введите процентную ставку % : ");
        double interestRate = scanner.nextDouble();

        // Ввод целевого долга
        System.out.println("Введите целевой долг (€): ");
        double targetDebt = scanner.nextDouble();

        double debt = loanAmount; // Начальный долг равен сумме ссуды
        int years = 0; // Счетчик лет

        // Цикл для расчета времени, через которое долг превысит целевой долг
        while (debt <= targetDebt) {
            double interest = debt * (interestRate / 100); // Расчет суммы процентов
            debt += interest; // Прибавляем сумму процентов к текущему долгу
            years++; // Увеличиваем счетчик лет
        }

        // Вывод результата
        System.out.println("Долг превысит " + targetDebt + "€ - " + years + " лет");
    }
}
