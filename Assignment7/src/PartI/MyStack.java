package PartI;

import java.util.ArrayList;

public class MyStack<E> {

	private ArrayList<E> ar;

	private int top = -1;

	public MyStack() {
		ar = new ArrayList<E>();
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public E peek() {
		if (isEmpty()) {
			return null;
		}
		return ar.get(top);
	}

	public void push(E e) {
		ar.add(e);
		top++;
	}

	public E pop() {
		if (isEmpty()) {
			return null;
		}
		E e = ar.get(top);
		ar.remove(top);
		top--;
		return e;
	}

	public int search(E e) {
		for (int i = 0; i <= top; i++) {
			if (ar.get(i).equals(e)) {
				return i + 1;
			}
		}
		return -1;
	}

}
