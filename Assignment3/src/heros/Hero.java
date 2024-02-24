package heros;

import java.util.Arrays;


public class Hero {
    private String name;
    private String role;
    private int level;
    private int experience;
    private static int MAX_LEVEL = 100;
    private static String[] ROLES = { "Warrior", "Priest", "Wizard", "Thief" };

    public Hero(String name) {
        this.name = name;
        this.role = "Unassigned";
        this.level = 1;
        this.experience = 0;
    }

    public void setRole(String role) {
        if (Arrays.asList(ROLES).contains(role)) {
            this.role = role;
        } else {
            System.out.println("Invalid role");
        }
    }

    // getters
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
        return (int) Math.pow(level, 2);
    }

    public void gainExperience(int experience) {
        if (level < MAX_LEVEL) {
            this.experience += experience;
            while (this.experience >= expToLevelUp()) {
                this.experience -= expToLevelUp();
                level++;
                System.out.printf("%s is now level %d!\n", name, level);
            }
        }
    }
    
    public String toString() {
        return String.format("%s the %s is level %d with %d experience.", name, role, level, experience);
    }

    public static void main(String[] args) {
        Hero h = new Hero("Bob");
        System.out.println(h);
        h.setRole("Warrior");
        System.out.println(h);
        h.gainExperience(100);
        System.out.println(h);
    }
}
