package player;

public class BaseballPlayer extends BallSportsPlayer {
    
    private int rbi = -1;

    public BaseballPlayer() {
        super();
    }

    public BaseballPlayer(int rbi, int weight, Gender gender) {
        super(weight, gender);
        this.rbi = rbi;
    }

    public int getRbi() {
        return rbi;
    }

    public void setRbi(int rbi) {
        this.rbi = rbi;
    }

    public String toString() {
        return String.format(
            "BaseballPlayer [rbi=%d, %s]", 
            getRbi(), getBaseInfoString()
        );
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BaseballPlayer)) {
            return false;
        }
        BaseballPlayer b = (BaseballPlayer) o;
        return b.getRbi() == getRbi() && super.equals(b);
    }

}
