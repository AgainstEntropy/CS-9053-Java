package heros;

public class Hero {

	private String name;
	private String role;
	private int level;
	private int experience;
	private final static int MAX_LEVEL = 100;
	private final static String[] ROLES = {"Warrior", "Priest",
			"Wizard", "Thief"};
	
	public Hero(String name) {
		this.name = name;
		this.level = 1;
		this.experience = 0;
	}

	public Hero(String name, String role, int level, int experience) {
		this(name);
		setRole(role);
		this.level = level;
		checkExperience(experience);
		this.experience = experience;
	}

	public void checkExperience(int experience) {
		if (level < 1 || level > MAX_LEVEL) {
			throw new HeroException("Invalid level: " + level);
		}
		if (experience < 0) {
			throw new HeroException("Invalid experience: " + experience);
		}
		if (experience > expToLevelUp()) {
			throw new HeroException(String.format("Invalid level (%d) and experience (%d)", level, experience));
		}
	}
	
	public void setRole(String role) {
		for (String r : ROLES) {
			if (r.equals(role)) {
				this.role = role;
				return;
			}
		}
		// System.out.println("Invalid role");
		this.role = "Unassigned";
		throw new HeroException("Invalid role: " + role);
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public int getLevel() {
		return level;
	}

	public int getExperience() {
		return experience;
	}
	
	public int expToLevelUp() {
		// this is not the "amount of experience NEEDED to
		// level up, based on the current amount of experience",
		// but rather the "level up" amount of experience
		return (int)Math.pow(this.level, 2);
	}
	
	public void gainExperience(int experience) {
		
		// it's not specified that we just keep adding experience
		// once you've reached max_levcel, but it makes the most
		// sense

		this.experience += experience;
		while ( (this.experience >= expToLevelUp()) && 
				(this.level < MAX_LEVEL)) {
			this.experience -= expToLevelUp();
			level++;
			System.out.println (this.name + " is now level " + this.level);
		}
	}
	
	public String toString() {
		return this.name + " the " + this.role + " is level " + this.level +
				" with " + this.experience + " experience.";
	}
	
	public static void main(String[] args) {
		//{"Warrior", "Priest",
		// "Wizard", "Thief"};
		//
		Hero h1 = new Hero("Bob");
		h1.setRole("Warrior");
		Hero  h2  = new Hero("John");
		h2.setRole("Wizard");
		Hero h3 = new Hero("Jane");
		h3.setRole("Priest");
		Hero h4 = new Hero("Dimitri");
		h4.setRole("Thief");
		Hero h5 = new Hero("Greg");
		h5.setRole("Paladin");
		Hero[] heroes = {h1, h2, h3, h4, h5};
		for (Hero h : heroes) {
			System.out.println(h);
		}
		h1.gainExperience(1);
		System.out.println(h1);
		h1.gainExperience(2);
		System.out.println(h1);
		h1.gainExperience(2);
		System.out.println(h1);
		h1.gainExperience(4);
		System.out.println(h1);
		h1.gainExperience(30);
		// if he's currently at level 3 with 4 experience,
		// then with 30 more experience he will be at 34 xp
		// With 9 xp, he goes up to level 4, with an excess of
		// 25 xp. That puts him to level 5, since he needs 16 xp
		// to get from level 4 to level 5, leaving him with 9 xp
		// in excess at level 5
		System.out.println(h1);
		// this will advance him to level 100 and all additional
		// experience will just keep adding on
		h1.gainExperience(1000000);

		System.out.println(h1);
		h1.gainExperience(200);

		System.out.println(h1);
	}
}
