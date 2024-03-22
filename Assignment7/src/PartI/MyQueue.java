package PartI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.NoSuchElementException;

public class MyQueue<E> implements Queue<E> {

	private ArrayList<E> ar;

	public MyQueue() {
		ar = new ArrayList<E>();
	}

	@Override
	public int size() {
		return ar.size();
	}

	@Override
	public boolean isEmpty() {
		return ar.isEmpty();
	}

	@Override
	public boolean offer(E e) {
		ar.add(e);
		return true;
	}

	@Override
	public E remove() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		E e = ar.get(0);
		ar.remove(0);
		return e;
	}

	@Override
	public E poll() {
		if (isEmpty()) {
			return null;
		}
		E e = ar.get(0);
		ar.remove(0);
		return e;
	}

	@Override
	public E element() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return ar.get(0);
	}

	@Override
	public E peek() {
		if (isEmpty()) {
			return null;
		}
		return ar.get(0);
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'contains'");
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'iterator'");
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'toArray'");
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'toArray'");
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'remove'");
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'containsAll'");
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addAll'");
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'clear'");
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'add'");
	}

}
