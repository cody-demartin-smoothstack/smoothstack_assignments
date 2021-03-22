package utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.entity.User;

public class UserDAO extends BaseDAO<User> {
	public UserDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public void addEmployee(User user) throws ClassNotFoundException, SQLException{
		save("insert into user values(?,?,?,?,?,?,?,?)",
				new Object[] {user.getId(), 1, user.getGivenName(), user.getFamilyName(),user.getUsername(),
						user.getEmail(), user.getPassword(), user.getPhone()});
	}
	
	public void addCustomer(User user) throws ClassNotFoundException, SQLException{
		save("insert into user values(?,?,?,?,?,?,?,?)",
				new Object[] {user.getId(), 2, user.getGivenName(), user.getFamilyName(),user.getUsername(),
						user.getEmail(), user.getPassword(), user.getPhone()});
	}
	
	public void update(User user) throws ClassNotFoundException, SQLException{
		save("update user set role_id=?, given_name=?, family_name=?, username=?, email=?, password=?, phone=? where id=?",
				new Object[] {user.getRoleId(), user.getGivenName(), user.getFamilyName(),user.getUsername(),
						user.getEmail(), user.getPassword(), user.getPhone(), user.getId()});
	}
	
	public void delete(User user) throws ClassNotFoundException, SQLException{
		save("delete from user where id=?",
				new Object[] {user.getId()});
	}
	
	public List<User> readAllEmployees() throws ClassNotFoundException, SQLException{
		return read("select * from user where role_id=1", new Object[] {});
	}
	
	public List<User> readAllCustomers() throws ClassNotFoundException, SQLException{
		return read("select * from user where role_id=2", new Object[] {});
	}

	@Override
	public List<User> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<User> users = new ArrayList<User>();
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setRoleId(rs.getInt("role_id"));
			user.setGivenName(rs.getString("given_name"));
			user.setFamilyName(rs.getString("family_name"));
			user.setUsername(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			users.add(user);
		}
		
		return users;
	}
}
