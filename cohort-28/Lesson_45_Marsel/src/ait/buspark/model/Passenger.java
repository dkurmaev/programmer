package ait.buspark.model;

public class Passenger {

	private String name;

	private Bus bus;

	private boolean inBus;

	public Passenger(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void goToBus(Bus bus) {
		if (inBus) {
			System.err.println(this.name + ": Я уже в автобусе");
			return;
		}
		if (bus == null) {
			System.err.println(this.name + ": Нельзя положить null-автобус");
			return;
		}
		if (bus.isGoing()) {
			System.err.println(this.name + ": я не буду запрыгивать в едущий автобус!");
			return;
		}
		if (bus.isFull()) {
			System.err.println(this.name + ": Автобус полон!");
			return;
		}
		this.bus = bus;
		bus.addPassenger(this);// положим в автобус себя
		this.inBus = true;

	}

	public void sayAbout() {
		if (inBus) {
			System.out.println("Пассажир " + name + " ура я в автобусе " + bus.getNumber());
		}else {
			System.err.println("Пассажир " + name + " стою жду автобуса");
		}
	}
}
