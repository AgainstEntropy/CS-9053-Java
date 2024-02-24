import java.io.*;

import heros.*;

/* your tasks:
 * create a class called HeroException
 * createHero should throw a HeroException
 * in main(), you should catch the HeroException
 * 
 */
public class ReadHeroFile {

	public static Hero createHero(String ln) throws HeroException{
		String[] line = ln.split(",");

		Hero hero = new Hero(
			line[0], line[1], 
			Integer.parseInt(line[2]), 
			Integer.parseInt(line[3])
		);

		return hero;
	}
	
	public static void main(String[] args) throws IOException {

		Party party = new Party();

		int index = 0;

		try (FileReader f = new FileReader("heroes.txt")) {
			BufferedReader in = new BufferedReader(f);
			String line = null;
			while ((line = in.readLine()) != null) {
				try {
					Hero hero = createHero(line);
					System.out.println("Created hero: " + hero);
					party.addHero(hero, index);
					index++;
				} catch (HeroException e) {
					System.out.println("Failed to create hero because: " + e.getMessage());
				}
			}
		}

		System.out.println(party);
		
	}
}