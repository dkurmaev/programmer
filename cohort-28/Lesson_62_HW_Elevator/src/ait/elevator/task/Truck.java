package ait.elevator.task;

import ait.elevator.mode.Elevator;

public class Truck implements Runnable {
    int N_RACES;
    int CAPACITY;
    Elevator elevator;

    private boolean lock;

    public Truck(int n_RACES, int CAPACITY, Elevator elevator, boolean lock) {
        N_RACES = n_RACES;
        this.CAPACITY = CAPACITY;
        this.elevator = elevator;
        this.lock = lock;
    }


    @Override
    public void run() {
        for (int i = 0; i < N_RACES; i++) {
            synchronized (this) {//использует this в качестве монитора синхронизации доступа к элеватору
                elevator.add(CAPACITY / 2);
            }

        }

    }
}
