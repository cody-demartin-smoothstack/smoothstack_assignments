package utopia.admin;

import java.sql.Connection;
import java.sql.SQLException;

import utopia.dao.FlightDAO;
import utopia.dao.PassengerDAO;
import utopia.entity.Flight;
import utopia.entity.Passenger;
import utopia.jdbc.DefaultConnection;

public class PassengersAdmin {
	DefaultConnection def = new DefaultConnection();

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
