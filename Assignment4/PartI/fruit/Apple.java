package fruit;

public class Apple extends Fruit {
	
	private String taste;
	private String texture;

	public Apple() {
		super();
	}
	
	public Apple(String taste, String texture, String color, boolean rotten) {
		super(color, rotten);
		this.taste = taste;
		this.texture = texture;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public String toString() {
		return String.format(
			"Apple [taste=%s, texture=%s, color=%s, rotten=%s, id=%s]", 
			getTaste(), getTexture(), getColor(), isRotten(), getId()
		);
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Apple)) {
			return false;
		}
		Apple a = (Apple) o;
		return a.getTaste().equals(getTaste()) 
			&& a.getTexture().equals(getTexture()) 
			&& a.getColor().equals(getColor()) 
			&& a.isRotten() == isRotten();
	}
}