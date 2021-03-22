package utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.entity.Airplane;
import utopia.entity.Airport;
import utopia.entity.Flight;
import utopia.entity.Route;
import utopia.jdbc.DefaultConnection;

public class FlightDAO extends BaseDAO<Flight> {

	public FlightDAO(Connection conn) {
		super(conn);
	}

	public List<Flight> index(Flight flight) {
		return read("select * from flight", null);
	}

	public void updateFLightEmployee(Flight flight) throws ClassNotFoundException, SQLException {
		save("update flight set route_id = ?, departure_time = ?, arrival_time = ? where id = ?", new Object[] {
				flight.getRoute().getId(), flight.getDepartureTime(), flight.getArrivalTime(), flight.getId() });
	}

	@Override
	public List<Flight> extractData(ResultSet results) throws ClassNotFoundException, SQLException {
		List<Flight> flights = new ArrayList<>();
		DefaultConnection def = new DefaultConnection();
		Connection conn = def.getConnection();
		RouteDAO route = new RouteDAO(conn);
		AirplaneDAO airplane = new AirplaneDAO(conn);
		try {
			while (results.next()) {
				Flight flight = new Flight();
				flight.setId(results.getInt("id"));
				Route flightRoute = route.getSingleRoute(results.getInt("route_id"));
				Airplane flightPlane = airplane.getSingleAirplane(results.getInt("airplane_id"));
				flight.setRoute(flightRoute);
				flight.setAirplane(flightPlane);
				flight.setDepartureTime(results.getTimestamp("departure_time"));
				flight.setArrivalTime(results.getTimestamp("arrival_time"));
				flight.setAllowedBusiness(results.getInt("allowed_business"));
				flight.setAllowedFirst(results.getInt("allowed_first"));
				flight.setAllowedEcon(results.getInt("allowed_econ"));
				flights.add(flight);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

		return flights;
	}

}
