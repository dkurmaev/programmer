***Задача 1.***
Создать класс ``QuadraticEquation`` в пакете ``ait.equation.model``. 
В этом классе определить поля ``private double a; private double b; private double c;``. 
Создать конструктор ``public QuadraticEquation(double a, double b, double c)`` для инициализации полей. Создать геттеры и сеттеры. Создать метод ``public void display()`` для печати в консоль квадратного уравнения. Создать методы ``public double delta()`` и ``public int quantityRoots()`` для вычисления дискриминанта и колличества решений уранения соотвественно.
Создать клас ``EquationAppl`` в пакете ``ait.equation`` с методом main. 
В методе main создать несколько экземпляров ``QuadraticEquation`` и вывести для каждого 
из них результаты работы методов display, delta, quantityRoots.