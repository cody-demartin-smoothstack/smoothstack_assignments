package utopia.admin;

import java.sql.Connection;
import java.sql.SQLException;

import utopia.dao.AirportDAO;
import utopia.entity.Airport;
import utopia.jdbc.DefaultConnection;

public class AirportAdmin {
	DefaultConnection def = new DefaultConnection();

	public void addAirport(Airport airport) throws SQLException {
		Connection conn = null;
		try {
			conn = def.getConnection();
			AirportDAO apDAO = new AirportDAO(conn);
			apDAO.add(airport);
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

	public void updateAirport(Airport airport) throws SQLException {
		Connection conn = null;
		try {
			conn = def.getConnection();
			AirportDAO apDAO = new AirportDAO(conn);
			apDAO.update(airport);
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
	
	public void deleteAirport(Airport airport) throws SQLException {
		Connection conn = null;
		try {
			conn = def.getConnection();
			AirportDAO apDAO = new AirportDAO(conn);
			apDAO.delete(airport);
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
