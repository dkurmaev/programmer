package ait.garage.model;

import java.util.Objects;

public class Car {

	protected String regNumber;
	protected String model;
	protected String company;
	protected double engine;
	protected String color;

	public Car(String regNumber, String model, String company, double engine, String color) {
		this.regNumber = regNumber;
		this.model = model;
		this.company = company;
		this.engine = engine;
		this.color = color;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public String getModel() {
		return model;
	}


	public String getCompany() {
		return company;
	}



	public double getEngine() {
		return engine;
	}


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Car car = (Car) obj;
		return Objects.equals(regNumber, car.regNumber)
				&& Objects.equals(model, car.model)
				&& Objects.equals(company, car.company)
				&& engine == car.engine
				&& Objects.equals(color, car.color);
	}

	@Override
	public int hashCode() {
		return Objects.hash(regNumber, model, company, engine, color);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Car ");
		sb.append("regNumber = '").append(regNumber).append('\'');
		sb.append(", model = '").append(model).append('\'');
		sb.append(", company = '").append(company).append('\'');
		sb.append(", engine = ").append(engine);
		sb.append(", color = '").append(color).append('\'');
		return sb.toString();
	}

}
