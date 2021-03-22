package utopia.admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import utopia.dao.PassengerDAO;
import utopia.entity.Passenger;
import utopia.jdbc.DefaultConnection;

public class PassengersAdmin {
	DefaultConnection def = new DefaultConnection();
	
	public List<Passenger> index() throws SQLException {
		Connection conn = null;
		try {
			conn = def.getConnection();
			PassengerDAO passengers = new PassengerDAO(conn);
			List<Passenger> passes = passengers.readAll();
			for (Passenger p: passes) {
				System.out.println(p.getId() + " - " + p.getGivenName() + " " + p.getFamilyName());
			}
			return passes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				conn.close();
			}

		}
	}

	public void addPassenger(Passenger passenger) throws SQLException {
		Connection conn = null;
		try {
			conn = def.getConnection();
			PassengerDAO passengerAdder = new PassengerDAO(conn);
			passengerAdder.add(passenger);
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

	public void updateFlight(Passenger passenger) throws SQLException {
		Connection conn = null;
		try {
			conn = def.getConnection();
			PassengerDAO passengerUpdater = new PassengerDAO(conn);
			passengerUpdater.add(passenger);
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

	public void deleteFlight(Passenger passenger) throws SQLException {
		Connection conn = null;
		try {
			conn = def.getConnection();
			PassengerDAO passengerDeleter = new PassengerDAO(conn);
			passengerDeleter.delete(passenger);
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
