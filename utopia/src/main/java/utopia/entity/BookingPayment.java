package utopia.entity;

public class BookingPayment {
	private int bookingId;
	private String stripeId;
	private boolean refunded;

	
	public boolean isRefunded() {
		return refunded;
	}
	public void setRefunded(boolean refunded) {
		this.refunded = refunded;
	}
	public int getBookingId() {
		return bookingId;
	}
	public String getStripeId() {
		return stripeId;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookingId;
		result = prime * result + ((stripeId == null) ? 0 : stripeId.hashCode());
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
		BookingPayment other = (BookingPayment) obj;
		if (bookingId != other.bookingId)
			return false;
		if (stripeId == null) {
			if (other.stripeId != null)
				return false;
		} else if (!stripeId.equals(other.stripeId))
			return false;
		return true;
	}

}
