package fruit;

public class Lemon extends Citrus {

	private int sourness;

	public Lemon() {
		super();
	}

	public Lemon(int sourness, String taste, Boolean rotten) {
		super(taste, "yellow", rotten);
		this.sourness = sourness;
	}

	public int getSourness() {
		return sourness;
	}

	public void setSourness(int sourness) {
		this.sourness = sourness;
	}

	public String toString() {
		return String.format(
			"Lemon [sourness=%d, taste=%s, color=%s, rotten=%s, id=%s]", 
			getSourness(), getTaste(), getColor(), isRotten(), getId()
		);
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Lemon)) {
			return false;
		}
		Lemon l = (Lemon) o;
		return l.getSourness() == getSourness() 
			&& l.getTaste().equals(getTaste()) 
			&& l.getColor().equals(getColor()) 
			&& l.isRotten() == isRotten();
	}
}