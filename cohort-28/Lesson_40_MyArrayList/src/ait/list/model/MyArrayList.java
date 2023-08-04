package ait.list.model;

import ait.list.interfaces.IList;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements IList<E> {

	private Object[] elements;
	private int size;

	public MyArrayList() {
		this(10); // По умолчанию создаем массив размером 10
	}

	public MyArrayList(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);

		elements = new Object[initialCapacity];
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		Arrays.fill(elements, null);
		size = 0;
	}

	@Override
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	@Override
	public boolean add(E element) {
		ensureCapacity(size + 1);
		elements[size++] = element;
		return true;
	}

	private void ensureCapacity(int minCapacity) {
		if (minCapacity > elements.length) {
			int newCapacity = elements.length + (elements.length >> 1); // Увеличиваем на 50%
			if (newCapacity < minCapacity)
				newCapacity = minCapacity;
			elements = Arrays.copyOf(elements, newCapacity);
		}
	}

	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		if (index >= 0) {
			remove(index);
			return true;
		}
		return false;
	}

	@Override
	public boolean add(int index, E element) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

		ensureCapacity(size + 1);
		System.arraycopy(elements, index, elements, index + 1, size - index);
		elements[index] = element;
		size++;
		return true;
	}

	@Override
	public E get(int index) {
		chekIndex(index);
		return (E) elements[index];
	}

	private void chekIndex(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}

	@Override
	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null)
					return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (o.equals(elements[i]))
					return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		if (o == null) {
			for (int i = size - 1; i >= 0; i--) {
				if (elements[i] == null)
					return i;
			}
		} else {
			for (int i = size - 1; i >= 0; i--) {
				if (o.equals(elements[i]))
					return i;
			}
		}
		return -1;
	}

	@Override
	public E remove(int index) {
		chekIndex(index);
		E oldValue = (E) elements[index];
		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(elements, index + 1, elements, index, numMoved);
		elements[--size] = null;
		return oldValue;
	}

	@Override
	public E set(int index, E element) {
		chekIndex(index);
		E oldValue = (E) elements[index];
		elements[index] = element;
		return oldValue;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private int currentIndex = 0;

			@Override
			public boolean hasNext() {
				return currentIndex < size;
			}

			@Override
			public E next() {
				if (!hasNext())
					throw new IllegalStateException("No more elements");

				return (E) elements[currentIndex++];
			}
		};
	}


}
