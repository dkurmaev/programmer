package ait.equation;

import ait.equation.model.QuadraticEquation;

/*
Создать класс QuadraticEquation в пакете ait.equation.model.
В этом классе определить поля private double a; private double b; private double c;.
Создать конструктор public QuadraticEquation(double a, double b, double c) для инициализации полей.
Создать геттеры и сеттеры. Создать метод public void display() для печати в консоль квадратного уравнения.
Создать методы public double delta() и public int quantityRoots()
для вычисления дискриминанта и колличества решений уранения соотвественно.
Создать клас EquationAppl в пакете ait.equation с методом main.
В методе main создать несколько экземпляров QuadraticEquation и вывести для каждого из них
результаты работы методов display, delta, quantityRoots.
 */

public class EquationAppl {
    public static void main(String[] args) {
        // Создание нескольких экземпляров QuadraticEquation
        QuadraticEquation equation1 = new QuadraticEquation(1, 2, 1);
        QuadraticEquation equation2 = new QuadraticEquation(2, 5, 2);
        QuadraticEquation equation3 = new QuadraticEquation(1, 2, 3);

        // Вывод результатов для каждого уравнения
        equation1.display();
        System.out.println("Delta = " + equation1.delta());
        System.out.println("Number of roots = " + equation1.quantityRoots());


        equation2.display();
        System.out.println("Delta = " + equation2.delta());
        System.out.println("Number of roots: " + equation2.quantityRoots());

        equation3.display();
        System.out.println("Delta = " + equation3.delta());
        System.out.println("Number of roots = " + equation3.quantityRoots());
    }
}
