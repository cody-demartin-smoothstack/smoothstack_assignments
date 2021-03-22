package utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.entity.FlightBookings;

public class FlightBookingDAO extends BaseDAO<FlightBookings> {	

	public FlightBookingDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	public void add(FlightBookings booking) throws ClassNotFoundException, SQLException{
		save("insert into flight_bookings values (?,?)",
				new Object[] {booking.getFlightId(), booking.getBookingId()});
	}

	public void delete(FlightBookings booking) throws ClassNotFoundException, SQLException{
		save("delete from flight_bookings where flight_id=? and booking_id=?",
				new Object[] {booking.getFlightId(), booking.getBookingId()});
	}
	
	public List<FlightBookings> readAll() throws ClassNotFoundException, SQLException{
		return read("select * from flight_bookings",
				new Object[] {});
	}
	
	public List<FlightBookings> readAllWithFlight(Integer flightId) throws ClassNotFoundException, SQLException{
		return read("select * from flight_bookings where flight_id = " + flightId,
				new Object[] {});
	}
	
	public FlightBookings readOneWithBookingId(Integer bookingId) throws ClassNotFoundException, SQLException{
		List<FlightBookings> entries = read("select * from flight_bookings where booking_id = " + bookingId,
				new Object[] {});
		if(entries.size() != 0) {
			return entries.get(0);
		}
		else {
			return null;
		}
	}
	

	@Override
	public List<FlightBookings> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<FlightBookings> bookings = new ArrayList<FlightBookings>();
		while(rs.next()) {
			FlightBookings booking = new FlightBookings();
			booking.setBookingId(rs.getInt("booking_id"));
			booking.setFlightId(rs.getInt("flight_id"));
			bookings.add(booking);
		}
		return bookings;
	}

}
