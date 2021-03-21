package utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.entity.Airplane;
import utopia.entity.AirplaneType;
import utopia.jdbc.DefaultConnection;

public class AirplaneDAO extends BaseDAO<Airplane> {

	public AirplaneDAO(Connection conn) {
		super(conn);
	}
	
	public Airplane getSingleAirplane(Integer id) {
		List<Airplane> entries = read("select * from airplane where id = " + id, null);
		return entries.get(0);
	}

	@Override
	public List<Airplane> extractData(ResultSet results) throws ClassNotFoundException, SQLException {
		AirplaneTypeDAO type = new AirplaneTypeDAO(DefaultConnection.getConnection());
		List<Airplane> airplanes = new ArrayList<Airplane>();
		
		while(results.next()) {
			Airplane airplane = new Airplane();
			AirplaneType planeType = type.getSingleType(results.getInt("type_id"));
			airplane.setId(results.getInt("id"));
			airplane.setType(planeType);
			airplanes.add(airplane);
		}
		
		return airplanes;
	}
	

}
