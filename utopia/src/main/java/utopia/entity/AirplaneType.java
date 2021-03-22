package utopia.entity;

public class AirplaneType {
	private int id;
	private int maxCapacity;
	private int maxFirstClass;
	private int maxBusinessClass;
	private int maxEconClass;

	public int getMaxFirstClass() {
		return maxFirstClass;
	}

	public void setMaxFirstClass(int maxFirstClass) {
		this.maxFirstClass = maxFirstClass;
	}

	public int getMaxBusinessClass() {
		return maxBusinessClass;
	}

	public void setMaxBusinessClass(int maxBusinessClass) {
		this.maxBusinessClass = maxBusinessClass;
	}

	public int getMaxEconClass() {
		return maxEconClass;
	}

	public void setMaxEconClass(int maxEconClass) {
		this.maxEconClass = maxEconClass;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public int getId() {
		return id;
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
		AirplaneType other = (AirplaneType) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
