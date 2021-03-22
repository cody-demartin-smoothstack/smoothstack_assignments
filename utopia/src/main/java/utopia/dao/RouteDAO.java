package utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.entity.Airport;
import utopia.entity.Route;

public class RouteDAO extends BaseDAO<Route> {

	public RouteDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public Route getSingleRoute(Integer id) {
		List<Route> entries = read("select * from route where id = " + id, null);
		return entries.get(0);
	}

	public void updateRoute(Route route) throws ClassNotFoundException, SQLException {
		save("update route set origin_id = ?, destination_id = ? where id = ?",
				new Object[] { route.getOrigin().getIataId(), route.getDestination().getIataId(), route.getId() });
	}
 
	public List<Route> index(Route route) {
		return read("select * from route", null);
	}

	@Override
	public List<Route> extractData(ResultSet results) throws ClassNotFoundException, SQLException {
		AirportDAO airportFinder = new AirportDAO(this.conn);
		List<Route> routes = new ArrayList<Route>();

		while (results.next()) {
			Route route = new Route();
			route.setId(results.getInt("id"));
			Airport origin = airportFinder.getSingleAirport(results.getString("origin_id"));
			Airport destination = airportFinder.getSingleAirport(results.getString("destination_id"));
			route.setOrigin(origin);
			route.setDestination(destination);
			routes.add(route);
		}

		return routes;

	}

}
