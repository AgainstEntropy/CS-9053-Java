package player;

import java.util.Arrays;

public class BasketballPlayer extends BallSportsPlayer {
    
    private int[] height = new int[] { -1, -1 };

    public BasketballPlayer() {
        super();
    }

    public BasketballPlayer(int[] height, int weight, Gender gender) {
        super(weight, gender);
        this.height = height;
    }

    public int[] getHeight() {
        return height;
    }
    
    public void setHeight(int[] height) {
        this.height = height;
    }
    
    public String getHeightString() {
        String heightString = "{" + height[0];
        for (int i = 1; i < height.length; i++) {
            heightString += ", " + height[i];
        }
        heightString += "}";
        return heightString;
    }

    public String toString() {
        return String.format(
            "BasketballPlayer [height=%s, %s]", 
            getHeightString(), getBaseInfoString()
        );
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BasketballPlayer)) {
            return false;
        }
        BasketballPlayer b = (BasketballPlayer) o;
        return Arrays.equals(getHeight(), b.getHeight()) && super.equals(b);
    }

}
