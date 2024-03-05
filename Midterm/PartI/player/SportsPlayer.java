package player;

enum Gender {
    MALE, 
    FEMALE
}

public abstract class SportsPlayer implements Comparable<SportsPlayer> {

    private int id;
    private static int next_id = 1;

    private int weight = -1;
    private Gender gender = null;

    public SportsPlayer() {
        id = next_id++;
    }

    public SportsPlayer(int weight, Gender gender) {
        id = next_id++;
        this.weight = weight;
        this.gender = gender;
    }

    @Override
    public int compareTo(SportsPlayer p) {
        return Integer.compare(weight, p.weight);
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBaseInfoString() {
        return String.format(
            "weight=%d, gender=%s, id=%d",
            getWeight(), getGender(), getId()
        );
    }

    public String toString() {
        return String.format(
            "SportsPlayer [%s]",
            getBaseInfoString()
        );
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SportsPlayer)) {
            return false;
        }
        SportsPlayer p = (SportsPlayer) o;
        return p.getWeight() == getWeight() 
            && p.getGender() == getGender();
    }
}
