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

	@Override
	public List<Flight> extractData(ResultSet results) throws ClassNotFoundException, SQLException {
		List<Flight> flights = new ArrayList<>();
		RouteDAO route = new RouteDAO(DefaultConnection.getConnection());
		AirplaneDAO airplane = new AirplaneDAO(DefaultConnection.getConnection());
		
		while(results.next()) {
			Flight flight = new Flight();
			flight.setId(results.getInt("id"));
			Route flightRoute = route.getSingleRoute(results.getInt("route_id"));
			Airplane flightPlane = airplane.getSingleAirplane(results.getInt("airplane_id"));
			flight.setRoute(flightRoute);
			flight.setAirplane(flightPlane);
			flight.setDepartureTime(results.getTimestamp("departure_time"));
			flight.setReservedSeats(results.getInt("reserved_seats"));
			flight.setSeatPrice(results.getFloat("seat_price"));
			flight.setArrivalTime(results.getTimestamp("arrival_time"));
			flights.add(flight);
		}		
		return flights;
	}
	
}
