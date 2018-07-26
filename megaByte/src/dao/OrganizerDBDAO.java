package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import beans.Organizer;
import utils.ConnectionPool;

public class OrganizerDBDAO implements OrganizerDAO {
	private ConnectionPool _pool;

	public OrganizerDBDAO() {
		super();
		_pool = ConnectionPool.getConnectionPool();
	}

	@Override
	public void createOrganizer(Organizer org) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeOrganizer(Organizer org) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateOrganizer(Organizer org) {
		// TODO Auto-generated method stub

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
			organizer = new Organizer(result.getLong("Id"), result.getString("First_name"),
					result.getString("Last_name"), result.getInt("Tel_number"), result.getInt("Events_quantity"));
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
		// TODO Auto-generated method stub
		return null;
	}

}
