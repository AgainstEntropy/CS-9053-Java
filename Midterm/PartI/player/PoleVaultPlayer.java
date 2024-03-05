package player;

public class PoleVaultPlayer extends FiledSportsPlayer {

    private int maxHeight = -1;

    public PoleVaultPlayer() {
        super();
    }

    public PoleVaultPlayer(int maxHeight, int weight, Gender gender) {
        super(weight, gender);
        this.maxHeight = maxHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int height) {
        this.maxHeight = height;
    }

    public String toString() {
        return String.format(
            "PoleVaultPlayer [maxHeight=%d, %s]", 
            getMaxHeight(), getBaseInfoString());
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PoleVaultPlayer)) {
            return false;
        }
        PoleVaultPlayer p = (PoleVaultPlayer) o;
        return p.getMaxHeight() == getMaxHeight() && super.equals(p);
    }
    
}
