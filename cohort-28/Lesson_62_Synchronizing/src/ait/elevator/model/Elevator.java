package ait.elevator.model;

public class Elevator {
    private String name;
    private int currentVolume;

    public Elevator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void add(int portion) {
        currentVolume += portion;
    }

    @Override
    public String toString() {
        return "Elevator " + name + " has " + currentVolume + " tonn";
    }
}
