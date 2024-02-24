package arraylists;
import java.util.ArrayList;

import fruit.*;

public class FruitArraylist {

	public static void printFruitArrayList(ArrayList<Fruit> fruitArrayList) {
		for (Fruit f : fruitArrayList) {
			System.out.println(f);
		}
	}

	public static void printAvgLemonSourness(ArrayList<Fruit> fruitArrayList) {
		int count = 0;
		double totalSourness = 0;
		for (Fruit f : fruitArrayList) {
			if (f instanceof Lemon) {
				count++;
				totalSourness += ((Lemon) f).getSourness();
			}
		}
		System.out.printf("Average Lemon Sourness: %f\n\n", totalSourness / count);
	}

	public static Apple findFirstRottenGreenApple(ArrayList<Fruit> fruitArrayList) {
		for (Fruit f : fruitArrayList) {
			if (f instanceof Apple && f.isRotten() && f.getColor().equals("green")) {
				return (Apple) f;
			}
		}
		System.out.println("No rotten green apples found");
		return null;
	}

	public static void removeMatchedFruits(ArrayList<Fruit> fruitArrayList, Apple rottenGreenApple) {
		for (int i = 0; i < fruitArrayList.size(); i++) {
			Fruit fruit_i = fruitArrayList.get(i);
			if (fruit_i.equals(rottenGreenApple)) {
				System.out.println("Removing rotten green apple: " + fruit_i);
				fruitArrayList.remove(i);
				i--;
			}
		}
	}

	public static void main(String[] args) {
		
		// this ArrayList MUST be parameterized
		ArrayList<Fruit> fruitArrayList = new ArrayList<Fruit>();

		fruitArrayList.add(new Apple("sweet", "crisp", "red", false));
		fruitArrayList.add(new Apple("tart", "soft", "green", true));
		fruitArrayList.add(new Apple("sweet", "soft", "green", true));
		fruitArrayList.add(new Apple("tart", "soft", "green", true));
		
		for (int i=0; i<3; i++) {
			fruitArrayList.add(new Lemon((int)(Math.random() * 100), "sour", false));
		}

		fruitArrayList.add(new Orange("mandarin", "sweet", true));

		printAvgLemonSourness(fruitArrayList);
	
		// this is the variable you should retain to compare
		// to the other objects in the arraylist
		Apple rottenGreenApple1 = findFirstRottenGreenApple(fruitArrayList);

		// remove all items from the arraylist that match the retained object
		removeMatchedFruits(fruitArrayList, rottenGreenApple1);

		System.out.println("\nAfter removing rotten green apple:");
		printFruitArrayList(fruitArrayList);
	}
}
