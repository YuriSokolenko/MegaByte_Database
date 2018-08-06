package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import beans.Organizer;
import utils.ConnectionPool;

public class OrganizerDBDAO implements OrganizerDAO {
	private ConnectionPool _pool;

	public OrganizerDBDAO() {
		super();
		_pool = ConnectionPool.getConnectionPool();
	}

	@Override
	public boolean login(String userName, String password) {
		boolean ret = false;
		try {
			Connection conn = _pool.getConnection();
			PreparedStatement stm = conn
					.prepareStatement("select * from `Organizer` where `User_Name` = ? and `Password` = ?");
			stm.setString(1, userName);
			stm.setString(2, password);
			ResultSet res = stm.executeQuery();
			if (res.next()) {
				ret = true;
			}
			_pool.returnConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public void createOrganizer(Organizer org) {
		try {
			Connection conn = _pool.getConnection();
			PreparedStatement statement = conn.prepareStatement(
					"insert into Organizer (Id, First_Name, Last_Name, Tel_Number, Events_quantity) values (?,?,?,?,?); ");
			statement.setLong(1, org.get_id());
			statement.setString(2, org.get_firstName());
			statement.setString(3, org.get_lastName());
			statement.setInt(4, org.get_telNumber());
			statement.setInt(5, org.get_eventsQuant());
			statement.executeUpdate();
			statement.close();
			_pool.returnConnection(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// createOrganizer

	@Override
	public void removeOrganizer(Organizer org) {
		try {
			Connection conn = _pool.getConnection();
			PreparedStatement statement = conn.prepareStatement("delete from Organizer where Id = ?;");
			statement.setLong(1, org.get_id());
			statement.executeUpdate();
			statement.close();
			_pool.returnConnection(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// removeOrganizer

	@Override
	public void updateOrganizer(Organizer org) {
		try {
			Connection conn = _pool.getConnection();
			PreparedStatement statement = conn.prepareStatement(
					"update `Organizer` set First_Name = ?, Last_Name = ?, Tel_Number = ?, Events_quantity = ? where id = ?;");
			statement.setString(1, org.get_firstName());
			statement.setString(2, org.get_lastName());
			statement.setInt(3, org.get_telNumber());
			statement.setInt(4, org.get_eventsQuant());
			statement.setLong(4, org.get_id());
			statement.executeUpdate();
			statement.close();
			_pool.returnConnection(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// updateOrganizer

	@Override
	public Organizer getOrganizerByUserName(String userName, String password) {
		Organizer organizer = null;
		try {
			Connection conn = _pool.getConnection();
			PreparedStatement statement = conn
					.prepareStatement("select * from Organizer where `User_Name` = ? and `Password` = ?;");
			statement.setString(1, userName);
			statement.setString(1, password);
			ResultSet result = statement.executeQuery();
			result.next();
			organizer = new Organizer(result.getLong("Id"), result.getString("User_Name"), result.getString("Password"),
					result.getString("First_name"), result.getString("Last_name"), result.getInt("Tel_number"),
					result.getInt("Events_quantity"));
			statement.close();
			result.close();
			_pool.returnConnection(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return organizer;
	}

	@Override
	public Organizer getOrganizer(long id) {
		Organizer organizer = null;
		try {
			Connection conn = _pool.getConnection();
			PreparedStatement statement = conn.prepareStatement("select * from Organizer where Id = ?;");
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			result.next();
			organizer = new Organizer(result.getLong("Id"), result.getString("User_Name"), result.getString("Password"),
					result.getString("First_name"), result.getString("Last_name"), result.getInt("Tel_number"),
					result.getInt("Events_quantity"));
			statement.close();
			result.close();
			_pool.returnConnection(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return organizer;
	}

	@Override
	public Collection<Organizer> getAllOrganizers() {
		List<Organizer> organizers = new ArrayList<>();
		try {
			Connection conn = _pool.getConnection();
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from Organizer;");
			while (result.next()) {
				organizers.add(new Organizer(result.getLong("Id"), result.getString("User_Name"),
						result.getString("Password"), result.getString("First_name"), result.getString("Last_name"),
						result.getInt("Tel_number"), result.getInt("Events_quantity")));
			}
			result.close();
			statement.close();
			_pool.returnConnection(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return organizers;
	}// getAllOrganizers

}
