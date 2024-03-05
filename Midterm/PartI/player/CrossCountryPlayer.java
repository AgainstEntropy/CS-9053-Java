package player;

public class CrossCountryPlayer extends RunningSportsPlayer {

    private double bestMileTime = -1.0;

    public CrossCountryPlayer() {
        super();
    }

    public CrossCountryPlayer(double bestMileTime, int weight, Gender gender) {
        super(weight, gender);
        this.bestMileTime = bestMileTime;
    }

    public double getBestMileTime() {
        return bestMileTime;
    }

    public void setBestMileTime(double time) {
        this.bestMileTime = time;
    }

    public String toString() {
        return String.format(
            "CrossCountryPlayer [bestMileTime=%f, %s]", 
            getBestMileTime(), getBaseInfoString());
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CrossCountryPlayer)) {
            return false;
        }
        CrossCountryPlayer c = (CrossCountryPlayer) o;
        return c.getBestMileTime() == getBestMileTime() && super.equals(c);
    }
    
}
