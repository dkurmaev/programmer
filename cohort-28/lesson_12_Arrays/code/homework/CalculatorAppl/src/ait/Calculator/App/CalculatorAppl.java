package ait.Calculator.App;

import App.Rech.calculatorAppRech;

import java.util.Scanner;

public class CalculatorAppl {
    public static void main(String[] args) {

        //public class CalculatorAppl {
        //public static void main(String[] args) {
        //double x = 10.5;
        //double y = 5.5;

        // Вызов метода calculator с разными операциями
        // double result1 = calculator(x, y, "+");
        // System.out.println("Result of addition: " + result1);

        //  double result2 = calculator(x, y, "-");
        //System.out.println("Result of subtraction: " + result2);

        //double result3 = calculator(x, y, "*");
        //System.out.println("Result of multiplication: " + result3);

        //double result4 = calculator(x, y, "/");
        //System.out.println("Result of division: " + result4);

        //double result5 = calculator(x, y, "invalid");
        //System.out.println("Result of invalid operation: " + result5);
        // }
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number:");
        double x = scanner.nextDouble();

        System.out.println("Enter the second number:");
        double y = scanner.nextDouble();

        System.out.println("Enter the operation (+, -, *, /):");
        String oper = scanner.next();

        double result = calculatorAppRech.calculator(x, y, oper);
        System.out.println("Result: " + result);

    }
}



