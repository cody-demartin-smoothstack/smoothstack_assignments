package utopia.admin;

import java.sql.Connection;
import java.sql.SQLException;
import utopia.dao.FlightDAO;
import utopia.entity.Flight;
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
