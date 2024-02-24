package fruit;


public class Inheritance {

	public static void main(String[] args) {
		// Here's some scratch space to experiment/debug your Fruit objects

		Lemon lemon_1 = new Lemon(5, "sour", false);
		Lemon lemon_2 = new Lemon(5, "sour", false);
		System.out.println(lemon_1);
		System.out.println(lemon_1.equals(lemon_2));

		Apple apple_1 = new Apple("sweet", "crisp", "red", false);
		Apple apple_2 = new Apple("sweet", "crisp", "green", false);
		System.out.println(apple_1);
		System.out.println(apple_1.equals(apple_2));

		System.out.println(lemon_1.equals(apple_1));

	}

}
