// Вводится шестизначное число (номер автобусного билета). Определите,
// является ли этот билет "счастливым"
// (сумма первых трех цифр равна сумме трех последних цифр).

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // включаем Scanner
        System.out.println("Input number (positive and integer)");
        int number = scanner.nextInt(); // read data from keyboard
        int number1= number/1000; // get 3 first digits
        number = number % 1000; // rest 3 last digits

        int sum1 = sumTicket(number); // call method
        int sum2 = sumTicket(number1); // call method
        System.out.println("Left part of Ticket " + number1);
        System.out.println("Right part of Ticket " + number);
        System.out.println("Summa Right is " + sum1);
        System.out.println("Summa Left is " + sum2);
        if (sum1==sum2) {
            System.out.println("Ticket is happy! ");
        } else {
            System.out.println("Ticket is unhappy( ");
        }
    }
    //_______________Method________________
    public static int sumTicket(int num) {
        int sum = 0;
        int count= 0;
        while (count < 3){
            sum = sum + num % 10;
            num = num / 10;
            count++;
        }
        return sum;
    }
    //___________end of Method________________
}