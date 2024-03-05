package player;

public class ShotputPlayer extends FiledSportsPlayer {
    
    private int maxDistance = -1;
    
    public ShotputPlayer() {
        super();
    }

    public ShotputPlayer(int maxDistance, int weight, Gender gender) {
        super(weight, gender);
        this.maxDistance = maxDistance;
    }
    
    public int getMaxDistance() {
        return maxDistance;
    }
    
    public void setMaxDistance(int distance) {
        this.maxDistance = distance;
    }

    public String toString() {
        return String.format(
            "ShotputPlayer [maxDistance=%d, %s]", 
            getMaxDistance(), getBaseInfoString());
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ShotputPlayer)) {
            return false;
        }
        ShotputPlayer s = (ShotputPlayer) o;
        return s.getMaxDistance() == getMaxDistance() && super.equals(s);
    }

}
