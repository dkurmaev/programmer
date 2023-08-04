package ait.shape.model;

import java.util.Objects;

public abstract class Shape {
	protected double side;

	public Shape(double side) {
		this.side = side;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}


	@Override
	public int hashCode() {
		return Objects.hash(side);
	}

	@Override
	public String toString() {
		return "Shape: " + "side = " + side;
	}

	public abstract double calcArea();

	public abstract double calcPerimeter();
}