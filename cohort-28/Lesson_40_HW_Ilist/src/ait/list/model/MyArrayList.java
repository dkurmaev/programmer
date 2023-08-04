package ait.list.model;

import java.util.Arrays;
import java.util.Iterator;
import ait.list.interfaces.IList;

public class MyArrayList<E> implements IList<E> {
	private Object[] elements;
	private int size;

	public MyArrayList() {
//        elements = new Object[10];
		this(5);
	}

	public MyArrayList(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("Illegal capacity = " + initialCapacity);
		}
		elements = new Object[initialCapacity];
	}

	//O(1)
	@Override
	public int size() {
		return size;
	}

	//O(n)
	@Override
	public void clear() {
		//TODO
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	//O(1)
	@Override
	public boolean add(E element) {
		ensureCapacity();
		elements[size++] = element;
		return true;
	}

	private void ensureCapacity() {
		if (size == elements.length) {
			if (size == Integer.MAX_VALUE) {
				throw new OutOfMemoryError();
			}
			int newCapacity = elements.length + elements.length / 2;
			if (newCapacity < 0) {
				newCapacity = Integer.MAX_VALUE;
			}
			elements = Arrays.copyOf(elements, newCapacity);
		}
	}

	//O(n)
	@Override
	public boolean add(int index, E element) {
		//TODO
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		ensureCapacity();
		System.arraycopy(elements, index, elements, index + 1, size++ - index);
		elements[index] = element;
		return true;
	}

	//O(1)
	@Override
	public E get(int index) {
		checkIndex(index);
		return (E) elements[index];
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}


	//O(n)
	@Override
	public int indexOf(Object o) {
		if (o != null) {
			for (int i = 0; i < size; i++) {
				if (o.equals(elements[i])) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (o == elements[i]) {
					return i;
				}
			}
		}

		return -1;
	}

	//O(n)
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

	//O(n)
	@Override
	public E remove(int index) {
		//TODO
		checkIndex(index);
		E oldValue = (E) elements[index];
		int res = size - index - 1;
		if (res > 0)
			System.arraycopy(elements, index + 1, elements, index, res);
		elements[--size] = null;
		return oldValue;
	}


	//O(1)
	@Override
	public E set(int index, E element) {
		//TODO
		checkIndex(index);
		E res = (E) elements[index];
		elements[index] = element;
		return res;
	}


	//O(1)
	@Override
	public Iterator<E> iterator() {
		//TODO
		return new Iterator<E>() {
			int i = 0;
			@Override
			public boolean hasNext() {
				return i < size;
			}

			@Override
			public E next() {
				if (!hasNext())
					throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
				return (E) elements[i++];
			}
		};
	}
}