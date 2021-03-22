package utopia.admin;

import java.sql.Connection;
import java.sql.SQLException;

import utopia.dao.UserDAO;
import utopia.entity.User;
import utopia.jdbc.DefaultConnection;

public class UserAdmin {
	DefaultConnection def = new DefaultConnection();

	public void addEmployee(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = def.getConnection();
			UserDAO uDAO = new UserDAO(conn);
			uDAO.addEmployee(user);
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

	public void addCustomer(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = def.getConnection();
			UserDAO uDAO = new UserDAO(conn);
			uDAO.addCustomer(user);
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

	public void updateUser(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = def.getConnection();
			UserDAO uDAO = new UserDAO(conn);
			uDAO.update(user);
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

	public void deleteUser(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = def.getConnection();
			UserDAO uDAO = new UserDAO(conn);
			uDAO.delete(user);
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
