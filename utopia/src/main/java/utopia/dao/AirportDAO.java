package utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.entity.Airport;

public class AirportDAO extends BaseDAO<Airport> {
	public AirportDAO(Connection conn) {
		super(conn);
		
	}
	
	public Airport getSingleAirport(String iata) {
		List<Airport> entries = read("select * from airport where iata_id = '" + iata +"'", null);
		return entries.get(0);
	}
	
	public List<Airport> index(Airport airport) {
		return read("select * from airport", null);
	}

	@Override
	public List<Airport> extractData(ResultSet results) throws ClassNotFoundException, SQLException {
		List<Airport> airports = new ArrayList<Airport>();

		while (results.next()) {
			Airport airport = new Airport();
			airport.setIataId(results.getString("iata_id"));
			airport.setCity(results.getString("city"));
			airports.add(airport);
		}

		return airports;
	}

}
