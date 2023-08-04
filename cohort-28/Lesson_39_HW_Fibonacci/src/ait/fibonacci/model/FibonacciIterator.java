package ait.fibonacci.model;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {
	private int quantity;              // Количество элементов последовательности, которые нужно сгенерировать
	private int currentPosition;       // Текущая позиция в последовательности
	private int previousPosition;       // Позиция предыдущего числа в последовательности
	private int currentNumber;          // Текущее число в последовательности

	// Конструктор, который принимает количество элементов последовательности, которые нужно сгенерировать
	public FibonacciIterator(int quantity) {
		this.quantity = quantity;
		currentPosition = 0;
		previousPosition = 0;
		currentNumber = 1;
	}

	// Метод, который возвращает true, если текущая позиция меньше количества элементов, которые нужно сгенерировать
	@Override
	public boolean hasNext() {
		return currentPosition < quantity;  
	}

	@Override
	public Integer next() {
		int result = currentNumber;          // Запоминаем текущее число, которое будет возвращено
		currentPosition++;                   // Увеличиваем текущую позицию
		currentNumber += previousPosition;    // Генерируем следующее число, складывая предыдущее и текущее число
		previousPosition = result;            // Обновляем предыдущую позицию
		return result;                        // Возвращаем текущее число
	}
}
