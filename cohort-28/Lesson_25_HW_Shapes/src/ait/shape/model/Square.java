package ait.shape.model;

public class Square extends Shape {
	public Square(double side) {
		super(side);
	}

	@Override
	public double calcArea() {
		double area = side * side;
		return area;
	}

	@Override
	public double calcPerimeter() {
		double perimetr = 4 * side;
		return perimetr;
	}

	@Override
	public String toString() {
		return "Square: " +	"side = " + side;
	}
}