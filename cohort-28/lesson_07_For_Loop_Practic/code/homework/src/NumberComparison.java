import java.util.Scanner;
//Ввести с клавиатуры 10 пар чисел. Cравнить числа в каждой паре и напечатать большие из них.
public class NumberComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//Цикл для ввода и сравнения чисел:
        for (int i = 1; i <= 10; i++) {
            System.out.println("Please enter a couple of numbers. #" + i + ":");
            System.out.print("The first number: ");
            int number1 = scanner.nextInt();
            System.out.print("The second number: ");
            int number2 = scanner.nextInt();

//В этой части кода используется тернарный оператор (?:), который сравнивает number1 и number2
// и присваивает большее из них значение переменной maxNumber:
            int maxNumber = number1 > number2 ? number1 : number2;
            System.out.println("Greater number: " + maxNumber);
        }
    }
}
