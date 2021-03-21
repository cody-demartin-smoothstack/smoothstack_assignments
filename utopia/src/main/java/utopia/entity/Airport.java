package utopia.entity;

public class Airport {
	private String iataId;
	private String city;
	
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getIataId() {
		return iataId;
	}
	public void setIataId(String iataId) {
		this.iataId = iataId;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iataId == null) ? 0 : iataId.hashCode());
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
		Airport other = (Airport) obj;
		if (iataId == null) {
			if (other.iataId != null)
				return false;
		} else if (!iataId.equals(other.iataId))
			return false;
		return true;
	}
}
