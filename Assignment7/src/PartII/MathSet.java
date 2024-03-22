package PartII;

import java.util.HashSet;
import java.util.Set;

public class MathSet<E> extends HashSet<E> {

	public Set<E> intersection(Set<E> s2) {
		Set<E> result = new MathSet<E>();
		for (E e : this) {
			if (s2.contains(e)) {
				result.add(e);
			}
		}
		return result;
	}

	public Set<E> union(Set<E> s2) {
		Set<E> result = new MathSet<E>();
		result.addAll(this);
		result.addAll(s2);
		return result;
	}

	public <T> Set<Pair<E, T>> cartesianProduct(Set<T> s2) {
		Set<Pair<E, T>> result = new MathSet<Pair<E, T>>();
		for (E e : this) {
			for (T t : s2) {
				result.add(new Pair<E, T>(e, t));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// create two MathSet objects of the same type.
		// See if union and intersection works.
		MathSet<Integer> s1 = new MathSet<>();
		s1.add(1);
		s1.add(2);
		s1.add(3);
		s1.add(4);
		s1.add(5);

		MathSet<Integer> s2 = new MathSet<>();
		s2.add(3);
		s2.add(4);

		Set<Integer> result = s1.intersection(s2);
		System.out.println(result);

		// create another MathSet object of a different type
		// calculate the cartesian product of this set with one of the
		// above sets
		MathSet<String> s3 = new MathSet<>();
		s3.add("a");
		s3.add("b");

		Set<Pair<Integer, String>> result2 = s2.cartesianProduct(s3);
		System.out.println(result2);
	}
}
