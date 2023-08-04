package ait.equation.model;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    // Геттеры и сеттеры для полей a, b и c
    // Геттеры используются для получения значения приватного поля.
    // Они обычно имеют префикс "get" и возвращают значение поля определенного типа данных.
    public double getA() {
        return a;
    }
    // Сеттеры используются для установки значения приватного поля.
    // Они обычно имеют префикс "set" и принимают в качестве параметра новое значение, которое нужно присвоить полю.
    public void setA(double a) {
        this.a = a;
    }
    //Пример: QuadraticEquation equation = new QuadraticEquation(1, 2, 3);
    //double a = equation.getA(); // получение значения поля a
    //equation.setB(5); // установка нового значения для поля b
    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
    // Метод для отображения уравнения в консоли
    public void display() {
        System.out.println("Quadratic equation: " + a + "x^2 + " + b + "x + " + c + " = " + delta());
    }

    // Метод для вычисления дискриминанта
    public double delta() {
        return b * b - 4 * a * c;
    }


    // Метод для определения количества корней уравнения
    public int quantityRoots() {
        double delta = delta();
        return delta > 0 ? 2 : (delta == 0 ? 1 : 0); // Если delta больше 0, возвращается 2.
                                                     // Если delta равен 0, возвращается 1.
                                                     // В противном случае, когда delta меньше 0, возвращается 0.
    }


}

