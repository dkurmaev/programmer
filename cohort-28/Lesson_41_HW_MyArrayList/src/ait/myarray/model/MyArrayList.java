package ait.myarray.model;

import ait.myarray.MyList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<E> implements MyList<E> {
	private static final int DEFAULT_CAPACITY = 10;
	private Object[] elements;
	private int size;

	public MyArrayList() {
		this.elements = new Object[DEFAULT_CAPACITY];
		this.size = 0;
	}

	public MyArrayList(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);

		this.elements = new Object[initialCapacity];
		this.size = 0;
	}

	//O(1)
	@Override
	public int size() {
		return size;
	}

	//O(n)
	@Override
	public void clear() {
		Arrays.fill(elements, null);
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(E element) {
		return indexOf(element) >= 0;
	}

	//O(1)
	@Override
	public boolean add(E element) {
		ensureCapacity(size + 1);
		elements[size++] = element;
		return true;
	}

	//O(n)
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

	//O(1)
	@Override
	public E get(int index) {
		checkIndex(index);
		return (E) elements[index];
	}

	//O(n)
	@Override
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null)
					return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i]))
					return i;
			}
		}
		return -1;
	}

	//O(n)
	@Override
	public int lastIndexOf(E element) {
		if (element == null) {
			for (int i = size - 1; i >= 0; i--) {
				if (elements[i] == null)
					return i;
			}
		} else {
			for (int i = size - 1; i >= 0; i--) {
				if (element.equals(elements[i]))
					return i;
			}
		}
		return -1;
	}

	//O(n)
	@Override
	public E remove(int index) {
		checkIndex(index);
		E oldValue = (E) elements[index];
		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(elements, index + 1, elements, index, numMoved);
		elements[--size] = null;
		return oldValue;
	}

	//O(n)
	@Override
	public boolean remove(E element) {
		int index = indexOf(element);
		if (index >= 0) {
			remove(index);
			return true;
		}
		return false;
	}


	//O(1)
	@Override
	public E set(int index, E element) {
		checkIndex(index);
		E oldValue = (E) elements[index];
		elements[index] = element;
		return oldValue;
	}

	private void ensureCapacity(int minCapacity) {
		if (minCapacity > elements.length) {
			int newCapacity = elements.length + (elements.length >> 1);
			if (newCapacity < minCapacity)
				newCapacity = minCapacity;
			elements = Arrays.copyOf(elements, newCapacity);
		}
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private int index = 0;

			@Override
			public boolean hasNext() {
				return index < size;
			}

			@Override
			public E next() {
				if (!hasNext())
					throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
				return (E) elements[index++];
			}
		};
	}

	//O(n^2) - Bubble sort, O(n*log(n)) - Quick sort
	@Override
	public void sort() {
		Arrays.sort((E[]) elements, 0, size, Comparator.comparing(Object::toString));
	}
}