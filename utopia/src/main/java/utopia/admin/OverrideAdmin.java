package utopia.admin;

import java.sql.Connection;
import java.sql.SQLException;

import utopia.dao.BookingDAO;
import utopia.entity.Booking;
import utopia.jdbc.DefaultConnection;

public class OverrideAdmin {
	DefaultConnection def = new DefaultConnection();
	
	public void updateBooking(Booking booking) throws SQLException {
		Connection conn = null;
		try {
			conn = def.getConnection();
			BookingDAO bDAO = new BookingDAO(conn);
			bDAO.update(booking);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}

		}
	}
}
