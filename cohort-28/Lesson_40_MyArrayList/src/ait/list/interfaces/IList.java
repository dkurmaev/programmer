package ait.list.interfaces;

public interface IList<E> extends Iterable<E> {

	int size();

	default boolean isEmpty() {
		return size() == 0;
	}

	void clear();

	boolean contains(Object o);// Проверяет, содержится ли элемент в списке

	boolean add(E element);

	boolean remove(Object o);

	boolean add(int index, E element);

	E get(int index);

	int indexOf(Object o);

	int lastIndexOf(Object o);

	E remove(int index);

	E set(int index, E element);
}
