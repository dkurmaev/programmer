package ait.shape.model;


public class Circle extends Shape {
	public Circle(double radius) {
		super(radius);

	}

	@Override
	public double calcArea() {
		double area = Math.PI * side * side;
		return area;
	}

	@Override
	public double calcPerimeter() {
		double perimetr =  2 * Math.PI * side;
		return perimetr;
	}

	@Override
	public String toString() {
		return "Circle: " +  "side = " + side;
	}
}