package utopia.run;

import utopia.dao.AirplaneTypeDAO;
import utopia.dao.AirportDAO;
import utopia.dao.RouteDAO;
import utopia.jdbc.DefaultConnection;
import utopia.menus.EmployeeMenu;
import utopia.menus.MainMenu;

public class Main {

	public static void main(String[] args) {	
		try {
			AirplaneTypeDAO test = new AirplaneTypeDAO(DefaultConnection.getConnection());
			test.getSingleType(1);
//			RouteDAO test2 = new RouteDAO(DefaultConnection.getConnection());
//			test2.index(null);
//			test.getSingleAirport("MSY");
//			test.index(null);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MainMenu.printMain();
	}

}
