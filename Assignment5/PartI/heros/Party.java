package heros;

import java.util.ArrayList;

public class Party {

	private ArrayList<Hero> heroes;
	
	public Party() {
		heroes = new ArrayList<Hero>(); // will automatically be null
	}
	
	public void addHero(Hero hero, int index) {
		for (Hero h: heroes) {
			if (h == hero) {
				System.out.println(hero.getName() + " is already in the party");
				return;
			}
		}
		heroes.add(index, hero);
	}
	
	public void removeHero(int index) {
		if ( (heroes.get(index) != null)) {
			heroes.add(index, null);
			index++;
			while ((index < heroes.size()) && 
					(heroes.get(index) != null)) {
				heroes.add(index-1, heroes.get(index));
				heroes.add(index, null);
				index++;
			}
		}
	}
	
	public Hero getHero(int index) {
		return heroes.get(index);
	}
	
	public void gainExperience(int experience) {
		System.out.println("the party has gained " + experience +
				" experience");
		int numHeroes = 0;
		int index = 0;
		while (heroes.get(index) != null) {
			numHeroes++;
			index++;
		}
		// we will be generous and round up.
		int individualExperience = (int)Math.ceil((1.0*experience)/numHeroes);

		index = 0;
		while (heroes.get(index) != null) {
			heroes.get(index).gainExperience(individualExperience);
			index++;
		}
	}
	
	public String toString() {
		// you don't have to use StringBuilder, but it's 
		// the most efficient
		StringBuilder sb = new StringBuilder("Party:\n");
		int index = 0;
		while ((index < heroes.size()) && (heroes.get(index) != null)){
			sb.append(heroes.get(index).toString() + "\n");
			index++;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Hero h1 = new Hero("Bob");
		h1.setRole("Warrior");
		Hero  h2  = new Hero("John");
		h2.setRole("Wizard");
		Hero h3 = new Hero("Jane");
		h3.setRole("Priest");
		Hero h4 = new Hero("Dimitri");
		h4.setRole("Thief");
		
		Party p = new Party();
		p.addHero(h1, 0);
		p.addHero(h2, 1);
		p.addHero(h3, 2);

		System.out.println(p);
		p.removeHero(2);

		System.out.println(p);
		p.addHero(h4, 2);

		System.out.println(p);
		p.removeHero(0);
		System.out.println(p);
		p.addHero(h3, 2);
		System.out.println(p);
		p.addHero(h3, 0);
		System.out.println(p);
		p.addHero(h1, 2);
		System.out.println(p);

		p.removeHero(1);
		System.out.println(p);
		
		p.gainExperience(25);
		System.out.println(p);
		
	}
}
