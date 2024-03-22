package PartIII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class SortFrequency {

	public static void sortByFrequency(ArrayList<Integer> ar) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : ar) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}

		List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
		list.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
		
		int index = 0;
		for (Entry<Integer, Integer> entry : list) {
			for (int i = 0; i < entry.getValue(); i++) {
				ar.set(index, entry.getKey());
				index++;
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			ar.add((int) (Math.random() * 10));
		}
		System.out.println(ar.toString());
		sortByFrequency(ar);
		System.out.println(ar.toString());
	}
}
