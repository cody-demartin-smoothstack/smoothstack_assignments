package utopia.run;

import java.sql.Connection;
import java.sql.SQLException;

import utopia.dao.AirplaneTypeDAO;
import utopia.dao.AirportDAO;
import utopia.dao.RouteDAO;
import utopia.jdbc.DefaultConnection;
import utopia.menus.EmployeeMenu;
import utopia.menus.MainMenu;

public class Main {
	static DefaultConnection def = new DefaultConnection();

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		
		try {
			conn = def.getConnection();
			AirplaneTypeDAO test = new AirplaneTypeDAO(conn);
			test.getSingleType(1);
//			RouteDAO test2 = new RouteDAO(DefaultConnection.getConnection());
//			test2.index(null);
//			test.getSingleAirport("MSY");
//			test.index(null);
			MainMenu.printMain();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

		
	}

}
