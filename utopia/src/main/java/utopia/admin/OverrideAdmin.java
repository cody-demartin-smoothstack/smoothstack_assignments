package utopia.admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

import utopia.dao.BookingDAO;
import utopia.dao.BookingUserDAO;
import utopia.dao.FlightBookingDAO;
import utopia.entity.Booking;
import utopia.entity.BookingUser;
import utopia.entity.FlightBookings;
import utopia.jdbc.DefaultConnection;

public class OverrideAdmin {
	DefaultConnection def = new DefaultConnection();
	
	
	public Booking handleInput(String type) {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        
        Booking newB = new Booking();
        newB.setIsActive(true);
        newB.setConfirmationCode(saltStr);
        newB.setType(type);
        return newB;
	}
	
	public void createFlightBooking(Integer flightId, Booking booking) throws SQLException {
		Connection conn = null;
		try {
			conn = def.getConnection();
			BookingDAO bDAO = new BookingDAO(conn);
			Booking book = bDAO.readOne(booking.getId());
			FlightBookings fb = new FlightBookings();
			FlightBookingDAO fbDAO = new FlightBookingDAO(conn);
			fb.setBookingId(book.getId());
			fb.setFlightId(flightId);
			fbDAO.add(fb);
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	public void createBookingUser(Booking booking, Integer userId) throws SQLException {
		Connection conn = null;
		try {
			conn = def.getConnection();
			BookingDAO bDAO = new BookingDAO(conn);
			Booking book = bDAO.readOne(booking.getId());
			BookingUser bu = new BookingUser();
			bu.setBookingId(book.getId());
			bu.setUserId(userId);
			BookingUserDAO buDAO = new BookingUserDAO(conn);
			buDAO.add(bu);
			conn.commit();	
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}
		finally {
			conn.close();
		}
		
	}
	
	public Booking createBooking(Booking booking) throws SQLException {
		Connection conn = null;
		try {
			conn = def.getConnection();
			BookingDAO bDAO = new BookingDAO(conn);
			bDAO.create(booking);
			conn.commit();
			return booking;
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return null;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	
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
