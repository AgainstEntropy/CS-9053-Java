package fruit;

public class Orange extends Citrus {

	private String type;

	public Orange() {
		super();
	}

	public Orange(String type, String taste, boolean rotten) {
		super(taste, "orange", rotten);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		return String.format(
			"Orange [type=%s, taste=%s, color=%s, rotten=%s, id=%s]", 
			getType(), getTaste(), getColor(), isRotten(), getId()
		);
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Orange)) {
			return false;
		}
		Orange oj = (Orange) o;
		return oj.getType().equals(getType()) 
			&& oj.getTaste().equals(getTaste()) 
			&& oj.getColor().equals(getColor()) 
			&& oj.isRotten() == isRotten();
	}
}