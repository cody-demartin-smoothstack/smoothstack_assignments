package utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.entity.Booking;

public class BookingDAO extends BaseDAO<Booking> {

	public BookingDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public void create(Booking booking) throws ClassNotFoundException, SQLException {
		save("insert into booking values (?,?,?,?)",
				new Object[] { booking.getId(), booking.getIsActive(), booking.getConfirmationCode(), booking.getType() });
			}

	public void update(Booking booking) throws ClassNotFoundException, SQLException {
		save("update booking set is_active=?, confirmation_code=?, type=? where id=?",
				new Object[] { booking.getIsActive(), booking.getConfirmationCode(), booking.getType(), booking.getId() });
	}

	public void delete(Booking booking) throws ClassNotFoundException, SQLException {
		save("delete from booking where id=?",
				new Object[] {booking.getId()});
	}

	public List<Booking> readAll() throws ClassNotFoundException, SQLException {
		return read("select * from booking", new Object[] {});
	}

	public List<Booking> readAllCancelled() throws ClassNotFoundException, SQLException {
		return read("select * from booking where is_active=0", new Object[] {});
	}
	
	@Override
	public List<Booking> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Booking> bookings = new ArrayList<Booking>();
		while(rs.next()) {
			Booking booking = new Booking();
			booking.setId(rs.getInt("id"));
			booking.setIsActive(rs.getBoolean("is_active"));
			booking.setConfirmationCode(rs.getString("confirmation_code"));
			booking.setType(rs.getString("type"));
			bookings.add(booking);
		}
		return bookings;
	}



}