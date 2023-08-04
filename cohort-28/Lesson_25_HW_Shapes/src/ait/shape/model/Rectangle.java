package ait.shape.model;

public class Rectangle extends Shape {
	public Rectangle(double side) {
		super(side);
	}

	@Override
	public double calcArea() {
		double area = (Math.sqrt(3) / 4) * side * side;
		return area;
	}

	@Override
	public double calcPerimeter() {
		double perimetr = 3 * side;
		return perimetr;
	}

	@Override
	public String toString() {
		return "Rectangle: " + "side = " + side;
	}
}