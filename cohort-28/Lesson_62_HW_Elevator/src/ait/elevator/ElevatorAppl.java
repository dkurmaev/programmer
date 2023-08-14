package ait.elevator;

import ait.elevator.mode.Elevator;
import ait.elevator.task.Truck;

public class ElevatorAppl {
    private static final int N_TRACK = 4;
    private static final int N_RACES = 6;
    private static final int CAPACITY = 10;

    public static void main(String[] args) {
        Elevator elevator = new Elevator("'V. I. Lenin'");

        Truck[] trucks = new Truck[N_TRACK];
        for (int i = 0; i < trucks.length; i++) {
            if (i % 2 == 0) {
                trucks[i] = new Truck(N_RACES, CAPACITY, elevator, true);
            } else {
                trucks[i] = new Truck(N_RACES, CAPACITY, elevator, false);
            }
        }
        Thread[] threads = new Thread[N_TRACK];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(trucks[i]);
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(elevator);
        }
    }
}



