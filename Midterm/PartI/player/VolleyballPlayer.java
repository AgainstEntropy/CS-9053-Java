package player;

public class VolleyballPlayer extends BallSportsPlayer {

    private int maxPoints = -1;

    public VolleyballPlayer() {
        super();
    }

    public VolleyballPlayer(int maxPoints, int weight, Gender gender) {
        super(weight, gender);
        this.maxPoints = maxPoints;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int points) {
        this.maxPoints = points;
    }
    
    public String toString() {
        return String.format(
            "VolleyballPlayer [maxPoints=%d, %s]", 
            getMaxPoints(), getBaseInfoString()
        );
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof VolleyballPlayer)) {
            return false;
        }
        VolleyballPlayer v = (VolleyballPlayer) o;
        return v.getMaxPoints() == getMaxPoints() && super.equals(v);
    }
}
