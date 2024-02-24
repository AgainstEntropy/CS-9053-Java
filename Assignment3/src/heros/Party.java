package heros;


public class Party {
    private Hero[] heros;

    public Party() {
        this.heros = new Hero[] { null, null, null };
    }

    public void addHero(Hero hero, int index) {
        for (int i = 0; i < heros.length; i++) {
            if (heros[i] != null && heros[i].getName().equals(hero.getName())) {
                System.out.printf("%s is already in the party.\n", hero.getName());
                return;
            }
        }
        heros[index] = hero;
    }

    public void removeHero(int index) {
        heros[index] = null;
        for (int i = 0; i < heros.length - 1; i++) {
            if (heros[i] == null) {
                heros[i] = heros[i + 1];
                heros[i + 1] = null;
            }
        }
    }

    public void gainExperience(int experience) {
        System.out.printf("The party gained %d experience.\n", experience);
        int exp_each = experience / countHeros();
        System.out.printf("Each hero in the party gained %d experience.\n", exp_each);
        for (Hero hero : heros) {
            if (hero != null) {
                hero.gainExperience(exp_each);
            }
        }
    }
    
    private int countHeros() {
        int num = 0;
        for (Hero hero : heros) {
            if (hero != null) {
                num++;
            }
        }
        return num;
    }

    public String toString() {
        String result = "";
        for (Hero hero : heros) {
            if (hero != null) {
                result += hero.toString() + "\n";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Hero h1 = new Hero("Thor");
        h1.setRole("Warrior");
        Hero h2 = new Hero("Groot");
        h2.setRole("Priest");
        Hero h3 = new Hero("Doctor Strange");
        h3.setRole("Wizard");

        Party party = new Party();
        party.addHero(h1, 0);
        party.addHero(h2, 1);
        party.addHero(h3, 2);
        party.addHero(h1, 1);
        System.out.println(party);

        party.removeHero(1);
        System.out.println(party);

        Hero h4 = new Hero("Loki");
        h4.setRole("Thief");

        party.addHero(h4, 1);

        party.gainExperience(100);
        System.out.println(party);
    }
}
