package ait.tarakan.model;

import java.util.Random;

public class Tarakan extends Thread {
    private int number; // Номер таракана
    private int distance; // Дистанция забега
    private long finishTime; // Время, когда таракан финишировал
    private static final Random random = new Random(); // Генератор случайных чисел

    public Tarakan(int number, int distance) {
        this.number = number;
        this.distance = distance;
    }

    @Override
    public void run() {
        System.out.println("Tarakan #" + number + " is running"); // Выводим информацию о старте таракана
        for (int i = 0; i < distance; i++) {
            System.out.println("Tarakan #" + number + " has covered " + i + " meters"); // Выводим информацию о пройденной дистанции
            try {
                int sleepTime = 10 + random.nextInt(100); // Генерируем случайное время сна между итерациями
                Thread.sleep(sleepTime); // Приостанавливаем выполнение потока на заданное время
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Tarakan #" + number + " finished"); // Выводим информацию о финише таракана
        finishTime = System.currentTimeMillis(); // Записываем время финиша
    }

    public int getNumber() {
        return number;
    }

    public long getFinishTime() {
        return finishTime;
    }
}
