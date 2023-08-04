package ait.myarray;


public interface MyList<E> extends Iterable<E> {
	int size();
	void clear();
	boolean isEmpty();
	boolean contains(E element);
	boolean add(E element);
	boolean add(int index, E element);
	E get(int index);
	int indexOf(E element);
	int lastIndexOf(E element);
	E remove(int index);
	boolean remove(E element);
	E set(int index, E element);

	void sort();
}



