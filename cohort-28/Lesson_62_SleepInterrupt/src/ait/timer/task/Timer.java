package ait.timer.task;

import java.time.LocalTime;

public class Timer implements Runnable {
    long clockPeriod = 1;

    public long getClockPeriod() {
        return clockPeriod;
    }

    public void setClockPeriod(int clockPeriod) {
        this.clockPeriod = clockPeriod;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(clockPeriod * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
