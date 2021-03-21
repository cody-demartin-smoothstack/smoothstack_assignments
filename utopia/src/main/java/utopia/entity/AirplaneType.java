package utopia.entity;

public class AirplaneType {
	private int id;
	private int maxCapacity;
	private int firstClass;
	private int businessClass;
	private int econClass;

	public int getFirstClass() {
		return firstClass;
	}

	public void setFirstClass(int firstClass) {
		this.firstClass = firstClass;
	}

	public int getBusinessClass() {
		return businessClass;
	}

	public void setBusinessClass(int businessClass) {
		this.businessClass = businessClass;
	}

	public int getEconClass() {
		return econClass;
	}

	public void setEconClass(int econClass) {
		this.econClass = econClass;
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

	public void setId(Integer id) {
		this.id = id;
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
