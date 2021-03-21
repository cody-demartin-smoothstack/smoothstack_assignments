package utopia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import utopia.jdbc.DefaultConnection;

public abstract class BaseDAO<T> {
	protected Connection conn = null;
	
	public BaseDAO(Connection conn) {
		try {
			this.conn = DefaultConnection.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Integer saveReturnPrimaryKeys(String sql, Object[] values) {
		try {
			PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			int count = 1;
			for(Object o: values) {
				statement.setObject(count, o);
				count++;
			}
			
			statement.executeUpdate();
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				return results.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public void save(String sql, Object[] values) {	
		try(PreparedStatement statement = conn.prepareStatement(sql)) {
			int count = 1;
			for(Object o: values) {
				statement.setObject(count, o);
				count++;
			}
			statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<T> read(String sql, Object[] vals) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			if(vals != null) {
				int count = 1;
				for(Object o: vals) {
					pstmt.setObject(count, o);
					count++;
				}	
			}
			ResultSet rs = pstmt.executeQuery();
			return extractData(rs);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	abstract public List<T> extractData(ResultSet results) throws ClassNotFoundException, SQLException;
	
	
}
