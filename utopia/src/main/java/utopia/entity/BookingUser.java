package utopia.entity;

public class BookingUser {
	private int bookingId;
	private int userId;
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookingId;
		result = prime * result + userId;
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
		BookingUser other = (BookingUser) obj;
		if (bookingId != other.bookingId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
}
