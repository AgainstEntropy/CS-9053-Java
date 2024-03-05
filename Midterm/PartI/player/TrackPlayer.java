package player;

public class TrackPlayer extends RunningSportsPlayer {
    
    private int distance = 1;

    public TrackPlayer() {
        super();
    }

    public TrackPlayer(int distance, int weight, Gender gender) {
        super(weight, gender);
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String toString() {
        return String.format(
            "TrackPlayer [distance=%d, %s]", 
            getDistance(), getBaseInfoString());
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TrackPlayer)) {
            return false;
        }
        TrackPlayer t = (TrackPlayer) o;
        return t.getDistance() == getDistance() && super.equals(t);
    }
}
