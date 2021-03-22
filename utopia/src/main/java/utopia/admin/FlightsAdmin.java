package utopia.admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utilities.FlightUtil;
import utopia.dao.BookingDAO;
import utopia.dao.BookingUserDAO;
import utopia.dao.FlightBookingDAO;
import utopia.dao.FlightDAO;
import utopia.entity.Booking;
import utopia.entity.BookingUser;
import utopia.entity.Flight;
import utopia.entity.FlightBookings;
import utopia.jdbc.DefaultConnection;

public class FlightsAdmin {
	DefaultConnection def = new DefaultConnection();

	public void addFlight(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = def.getConnection();
			FlightDAO flightAdder = new FlightDAO(conn);
			flightAdder.create(flight);
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
	
	public void printClassOptions(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = def.getConnection();
			FlightBookingDAO fbDAO = new FlightBookingDAO(conn);
			BookingDAO bDAO = new BookingDAO(conn);
			List<FlightBookings> fbs = fbDAO.readAllWithFlight(flight.getId());
			Integer first = 0;
			Integer business = 0;
			Integer econ = 0;
			List<Booking> bookings = new ArrayList<>();
			for(FlightBookings fb: fbs) {
				Booking b = bDAO.readOne(fb.getBookingId());
				if (b != null) {
					bookings.add(b);
				}
			}
			
			for(Booking book: bookings) {
				if(book.getType().equals("first")) {
					first++;
				}
				else if(book.getType().equals("business")) {
					business++;
				}
				else if(book.getType().equals("econ")){
					econ++;
				}
			}
			if (fbs.size() == 0) {
				System.out.println("Press f for first class ticket.");
				System.out.println("Press b for business class ticket.");
				System.out.println("Press e for econ class ticket.");
			}
			else {
				if(first < FlightUtil.getRemainingFirst(flight)) {
					System.out.println("Press f for first class ticket.");
				}
				else if(business < FlightUtil.getRemainingBusiness(flight)) {
					System.out.println("Press b for business class ticket.");
				}
				else if(econ < FlightUtil.getRemainingEcon(flight)) {
					System.out.println("Press e for econ class ticket.");
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
	}
	
	
	public List<Flight> getAssociatedFlights(Integer userId) throws SQLException{
		Connection conn = null;
		try {
			conn = def.getConnection();
			BookingUserDAO buDAO = new BookingUserDAO(conn);
			FlightBookingDAO fbDAO = new FlightBookingDAO(conn);
			FlightDAO fDAO = new FlightDAO(conn);
			List<BookingUser> busers = buDAO.readAllByUser(userId);
			List<Integer> bookingIds = new ArrayList<>();
			for(BookingUser bu: busers) {
				bookingIds.add(bu.getBookingId());
			}
			List<FlightBookings> fbs = new ArrayList<>();
			for(Integer bid: bookingIds) {
				FlightBookings fb = fbDAO.readOneWithBookingId(bid);
				if (fb != null) {
					fbs.add(fb);
				}
			}
			List<Flight> flights = new ArrayList<>();
			for(FlightBookings fb: fbs) {
				Flight f = fDAO.getOne(fb.getFlightId());
				if (f != null) {
					flights.add(f);
				}
			}
			
			return flights;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			conn.close();
		}
	}

	public void updateFlight(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = def.getConnection();
			FlightDAO flightUpdater = new FlightDAO(conn);
			flightUpdater.update(flight);
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
	
	public void deleteFlight(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = def.getConnection();
			FlightDAO flightDeleter = new FlightDAO(conn);
			flightDeleter.delete(flight);
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
