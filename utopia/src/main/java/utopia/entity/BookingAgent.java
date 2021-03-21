package utopia.entity;

public class BookingAgent {
	private int bookingId;
	private int agentId;
	
	
	public int getBookingId() {
		return bookingId;
	}
	public int getAgentId() {
		return agentId;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agentId;
		result = prime * result + bookingId;
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
		BookingAgent other = (BookingAgent) obj;
		if (agentId != other.agentId)
			return false;
		if (bookingId != other.bookingId)
			return false;
		return true;
	}
	
	
	

}
