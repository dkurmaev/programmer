package ait.multithreading;

import ait.multithreading.task.MyTaskImplements;

public class MultiTAppl {
    public static final int MAX = 10;

    public static void main(String[] args) {
        System.out.println("Main thread started");
        MyTaskImplements task1 = new MyTaskImplements("TaskImplements", MAX);
        Thread thread = new Thread(task1);
        thread.start();
        for (int i = 0; i < MAX; i++) {
            System.out.println("Main thread, count = " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Main thread stopped");
    }

}

