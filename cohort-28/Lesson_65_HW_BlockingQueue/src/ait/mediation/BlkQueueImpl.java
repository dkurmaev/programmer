package ait.mediation;

import java.util.LinkedList;
import java.util.Queue;

public class BlkQueueImpl<T> implements BlkQueue<T> {
    private final int maxSize;   // Максимальный размер очереди
    private final Queue<T> queue; // Внутренняя реализация очереди

    public BlkQueueImpl(int maxSize) {
        this.maxSize = maxSize;    // Инициализируем максимальный размер
        this.queue = new LinkedList<>(); // Создаем очередь на базе LinkedList
    }

    @Override
    public synchronized void push(T message) {
        while (queue.size() >= maxSize) {
            try {
                wait(); // Ожидаем, если очередь полная
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        queue.offer(message); // Добавляем элемент в очередь
        notifyAll(); // Оповещаем ожидающие потоки
    }

    @Override
    public synchronized T pop() {
        while (queue.isEmpty()) {
            try {
                wait(); // Ожидаем, если очередь пуста
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        T message = queue.poll(); // Извлекаем элемент из очереди
        notifyAll(); // Оповещаем ожидающие потоки
        return message;
    }
}
