package utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.entity.AirplaneType;

public class AirplaneTypeDAO extends BaseDAO<AirplaneType> {

	public AirplaneTypeDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public AirplaneType getSingleType(Integer id) {
		List<AirplaneType> entries = read("select * from airplane_type where id = " + id, null);
		return entries.get(0);
	}

	public List<AirplaneType> index(AirplaneType type) {
		return read("select * from airplane_type", null);
	}

	@Override
	public List<AirplaneType> extractData(ResultSet results) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<AirplaneType> types = new ArrayList<AirplaneType>();

		while (results.next()) {
			AirplaneType type = new AirplaneType();
			type.setMaxCapacity(results.getInt("max_capacity"));
			type.setId(results.getInt("id"));
			type.setMaxFirstClass(results.getInt("max_first_class"));
			type.setMaxBusinessClass(results.getInt("max_business_class"));
			type.setMaxEconClass(results.getInt("max_econ_class"));
			types.add(type);
		}

		return types;
	}

}
