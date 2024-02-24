package fruit;

public class Citrus extends Fruit {
	
	private String taste;

	public Citrus() {
		super();
	}

	public Citrus(String taste, String color, boolean rotten) {
		super(color, rotten);
		this.taste = taste;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public String toString() {
		return String.format(
			"Citrus [taste=%s, color=%s, rotten=%s, id=%s]", 
			getTaste(), getColor(), isRotten(), getId()
		);
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Citrus)) {
			return false;
		}
		Citrus c = (Citrus) o;
		return c.getTaste().equals(getTaste()) 
			&& c.getColor().equals(getColor()) 
			&& c.isRotten() == isRotten();
	}
}