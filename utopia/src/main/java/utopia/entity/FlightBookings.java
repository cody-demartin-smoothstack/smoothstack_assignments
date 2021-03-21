package utopia.entity;

public class FlightBookings {
	private int flightId;
	private int bookingId;
	
	
	public int getFlightId() {
		return flightId;
	}
	public int getBookingId() {
		return bookingId;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookingId;
		result = prime * result + flightId;
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
		FlightBookings other = (FlightBookings) obj;
		if (bookingId != other.bookingId)
			return false;
		if (flightId != other.flightId)
			return false;
		return true;
	}
	
	

}
