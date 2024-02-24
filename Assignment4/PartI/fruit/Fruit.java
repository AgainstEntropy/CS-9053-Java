package fruit;

public class Fruit {
	
	private String color;
	private boolean rotten;
	private int id;
	private static int next_id;

	public Fruit() {
		id = next_id++;
	}
	
	public Fruit(String color, boolean rotten) {
		this.color = color;
		this.rotten = rotten;
		id = next_id++;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isRotten() {
		return rotten;
	}

	public void setRotten(boolean rotten) {
		this.rotten = rotten;
	}

	public int getId() {
		return id;
	}
	
	public String toString() {
		return String.format(
			"Fruit [color=%s, rotten=%s, id=%s]", 
			getColor(), isRotten(), getId()
		);
	}

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Fruit)) {
            return false;
        }
        Fruit f = (Fruit) o;
        return f.getColor().equals(getColor()) 
            && f.isRotten() == isRotten();
    }
}
