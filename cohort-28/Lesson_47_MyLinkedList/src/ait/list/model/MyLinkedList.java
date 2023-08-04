package ait.list.model;
import ait.list.interfaces.IList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements IList<E> {
	private Node<E> first;
	private Node<E> last;
	private int size;

	//O(1)
	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		first = null;
		last = null;
		size = 0;
	}

	//O(1)
	@Override
	public boolean add(E element) {
		Node<E> newNode = new Node<>(last, element, null);
		if (last != null) {
			last.next = newNode;
		} else {
			first = newNode;
		}
		last = newNode;
		size++;
		return true;
	}

	// O(n), O(1)
	@Override
	public boolean add(int index, E element) {
		if (index == size) {
			return add(element);
		}
		Node<E> node = getNodeByIndex(index);
		Node<E> newNode = new Node<>(node.prev, element, node);
		node.prev = newNode;
		if (index != 0) {
			newNode.prev.next = newNode;
		} else {
			first = newNode;
		}
		size++;
		return true;
	}

	//O(n)
	@Override
	public E get(int index) {
		Node<E> node = getNodeByIndex(index);
		return node.data;
	}

	private Node<E> getNodeByIndex(int index) {
		checkIndex(index);
		Node<E> node;
		if (index < size / 2) {
			node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
		} else {
			node = last;
			for (int i = size - 1; i > index; i--) {
				node = node.prev;
			}
		}
		return node;
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index);
		}
	}

	//O(n)
	@Override
	public int indexOf(Object o) {
		int index = 0;
		if (o != null) {
			for (Node<E> node = first; node != null; node = node.next, index++) {
				if (o.equals(node.data)) {
					return index;
				}
			}
		} else {
			for (Node<E> node = first; node != null; node = node.next, index++) {
				if (o == node.data) {
					return index;
				}
			}
		}
		return -1;
	}

	//O(n)
	@Override
	public int lastIndexOf(Object o) {
		int index = size - 1;
		if (o != null) {
			for (Node<E> node = last; node != null; node = node.prev, index--) {
				if (o.equals(node.data)) {
					return index;
				}
			}
		} else {
			for (Node<E> node = last; node != null; node = node.prev, index--) {
				if (o == node.data) {
					return index;
				}
			}
		}
		return -1;
	}

	@Override
	public E remove(int index) {
		Node<E> node = getNodeByIndex(index);
		E removed = node.data;
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			first = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			last = node.prev;
		}
		node.prev = null;
		node.next = null;
		node.data = null;
		size--;
		return removed;
	}

	@Override
	public E set(int index, E element) {
		Node<E> node = getNodeByIndex(index);
		E replacedElement = node.data;
		node.data = element;
		return replacedElement;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private Node<E> currentNode = first;

			@Override
			public boolean hasNext() {
				return currentNode != null;
			}

			@Override
			public E next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				E data = currentNode.data;
				currentNode = currentNode.next;
				return data;
			}
		};
	}
}
