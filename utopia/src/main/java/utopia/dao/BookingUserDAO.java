package utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.entity.BookingUser;

public class BookingUserDAO extends BaseDAO<BookingUser> {

	public BookingUserDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public void add(BookingUser guest) throws ClassNotFoundException, SQLException {
		save("insert into booking_user values(?,?)",
				new Object[] { guest.getBookingId(), guest.getUserId() });
	}

	public void update(BookingUser guest) throws ClassNotFoundException, SQLException {
		save("update booking_user set contact_email=?, contact_phone=? where booking_id=?",
				new Object[] { guest.getBookingId(), guest.getUserId() });
	}

	public void delete(BookingUser guest) throws ClassNotFoundException, SQLException {
		save("delete from booking_user where booking_id=?", new Object[] { guest.getBookingId() });
	}

	public List<BookingUser> readAll() throws ClassNotFoundException, SQLException {
		return read("select * from booking_user", new Object[] {});
	}

	public List<BookingUser> readAllByUser(Integer userId) {
		List<BookingUser> entries = read("select * from booking_user where user_id = " + userId, new Object[] {});
		if (entries.size() != 0) {
			return entries;
		}
		else {
			return null;
		}
	}
	
	@Override
	public List<BookingUser> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingUser> guests = new ArrayList<BookingUser>();
		while (rs.next()) {
			BookingUser guest = new BookingUser();
			guest.setBookingId(rs.getInt("booking_id"));
			guest.setUserId(rs.getInt("user_id"));
			guests.add(guest);
		}
		return guests;
	}

}