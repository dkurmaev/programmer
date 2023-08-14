package ait.elevator.task;

import ait.elevator.model.Elevator;

public class Truck implements Runnable {
    private int nRaces;
    private int capacity;
    private Elevator lenin;

    public Truck(int nRaces, int capacity, Elevator lenin) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.lenin = lenin;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            lenin.add(capacity);
        }
    }
}
