package ait.shape;

import ait.shape.model.Shape;
import ait.shape.model.Circle;
import ait.shape.model.Square;
import ait.shape.model.Rectangle;

public class ShapeAppl {
	public static void main(String[] args) {
		// Создаем массив объектов типа Shape
		Shape[] shapes = new Shape[4];
		shapes[0] = new Circle(6.5);        // Создаем объект Circle и сохраняем его в массив
		shapes[1] = new Circle(9.6);        // Создаем другой объект Circle и сохраняем его в массив
		shapes[2] = new Rectangle(8.0);     // Создаем объект Rectangle и сохраняем его в массив
		shapes[3] = new Square(2.0);        // Создаем объект Square и сохраняем его в массив
		printArray(shapes);                 // Выводим информацию о каждом элементе массива
		double totalAllArea = totalArea(shapes);         // Вычисляем общую площадь всех фигур
		System.out.println("Total area of all shapes: " + totalAllArea);
		double totalAllPer = totalPerimeter(shapes);     // Вычисляем общий периметр всех фигур
		System.out.println("Total perimeter of all shapes: " + totalAllPer);
		double totalCircle = totalCircleArea(shapes);    // Вычисляем общую площадь всех кругов
		System.out.println("Total area of circles: " + totalCircle);
		double circle1Area = circleArea(shapes[0]);      // Вычисляем площадь первого круга
		System.out.println("Area of circle 1: " + circle1Area);
		double circle2Area = circleArea(shapes[1]);      // Вычисляем площадь второго круга
		System.out.println("Area of circle 2: " + circle2Area);
		double rectangleArea = rectangleArea(shapes[2]); // Вычисляем площадь прямоугольника
		System.out.println("Area of rectangle: " + rectangleArea);
		double squareArea = squareArea(shapes[3]);       // Вычисляем площадь квадрата
		System.out.println("Area of square: " + squareArea);
	}

	// Метод для вычисления площади круга
	private static double circleArea(Shape shape) {
		return shape.calcArea();
	}

	// Метод для вычисления площади прямоугольника
	private static double rectangleArea(Shape shape) {
		return shape.calcArea();
	}

	// Метод для вычисления площади квадрата
	private static double squareArea(Shape shape) {
		return shape.calcArea();
	}

	// Метод для вычисления общей площади всех фигур
	private static double totalArea(Shape[] shapes) {
		double totalArea = 0;
		for (int i = 0; i < shapes.length; i++) {
			if (shapes[i] != null) {
				totalArea += shapes[i].calcArea();
			}
		}
		return totalArea;
	}

	// Метод для вычисления общего периметра всех фигур
	private static double totalPerimeter(Shape[] shapes) {
		double totalPerimeter = 0;
		for (int i = 0; i < shapes.length; i++) {
			if (shapes[i] != null) {
				totalPerimeter += shapes[i].calcPerimeter();
			}
		}
		return totalPerimeter;
	}

	// Метод для вычисления общей площади всех кругов
	private static double totalCircleArea(Shape[] shapes) {
		double circleArea = 0;
		for (int i = 0; i < shapes.length; i++) {
			if (shapes[i] != null && shapes[i] instanceof Circle) {
				circleArea += shapes[i].calcArea();
			}
		}
		return circleArea;
	}

	// Метод для вывода информации о каждом элементе массива
	public static void printArray(Object[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				System.out.println(arr[i]);
			}
		}
	}
}
