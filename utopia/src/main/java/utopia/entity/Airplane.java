package utopia.entity;

public class Airplane {
	private int id;
	private AirplaneType type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AirplaneType getType() {
		return type;
	}

	public void setType(AirplaneType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airplane other = (Airplane) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
