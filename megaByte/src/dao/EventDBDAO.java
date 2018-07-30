package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import beans.Event;
import beans.EventStatus;
import beans.EventType;
import beans.Organizer;
import utils.ConnectionPool;

public class EventDBDAO implements EventDAO {
	// Attributes:
	private ConnectionPool _pool;
	private OrganizerDAO _organizerDao;

	// Constructors:
	public EventDBDAO() {
		super();
		_pool = ConnectionPool.getConnectionPool();
		_organizerDao = new OrganizerDBDAO();
	}// c-tor
		// Methods:

	@Override
	public void createEvent(Event event) {
		try {
			Connection conn = _pool.getConnection();
			PreparedStatement statement = conn.prepareStatement(
					"insert into Event (Name, Id, Date, Status, Type, Place, Price, Participants_quantity, Organizer) values (?, ?, ?, ?, ?, ?, ?, ?, ?);");
			statement.setString(1, event.get_name());
			statement.setLong(2, event.getId());
			statement.setDate(3, new Date(event.get_date().getTime()));
			statement.setString(4, event.get_status().toString());
			statement.setString(5, event.get_type().toString());
			statement.setString(6, event.get_place());
			statement.setDouble(7, event.get_price());
			statement.setInt(8, event.get_participantsQuantity());
			statement.setString(9, event.get_organizer().toString());
			statement.executeUpdate();
			statement.close();
			_pool.returnConnection(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// createEvent

	@Override
	public void removeEvent(Event event) {
		try {
			Connection conn = _pool.getConnection();
			PreparedStatement statement = conn.prepareStatement("delete from Event where Id = ?;");
			statement.setLong(1, event.getId());
			statement.executeUpdate();
			statement.close();
			_pool.returnConnection(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// removeEvent

	@Override
	public void updateEvent(Event event) {
		try {
			Connection conn = _pool.getConnection();
			PreparedStatement statement = conn.prepareStatement(
					"update `Event` set Name = ?, Date = ?, Status = ?, Type = ?, Place = ?, Price = ?, Participants_quntity = ?, Organizer = ? where id = ?;");
			statement.setString(1, event.get_name());
			statement.setDate(2, new Date(event.get_date().getTime()));
			statement.setString(3, event.get_status().name());
			statement.setString(4, event.get_type().name());
			statement.setString(5, event.get_place());
			statement.setDouble(6, event.get_price());
			statement.setInt(7, event.get_participantsQuantity());
			statement.setString(8, event.get_organizer().toString());
			statement.setLong(9, event.getId());
			statement.executeUpdate();
			statement.close();
			_pool.returnConnection(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// updateEvent

	@Override
	public Event getEvent(long id) {
		Event event = null;
		try {
			Connection conn = _pool.getConnection();
			PreparedStatement statement = conn.prepareStatement("select * from Event where Id = ?;");
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			result.next();
			event = new Event(result.getLong("Id"), result.getString("Name"),
					new Date(result.getDate("Date").getTime()), EventStatus.valueOf(result.getString("Status")),
					EventType.valueOf(result.getString("Type")), result.getString("Place"), result.getDouble("Price"),
					result.getInt("Participants_quantity"), _organizerDao.getOrganizer(result.getLong("Organizer")));
			result.close();
			statement.close();
			_pool.returnConnection(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return event;
	}// getEvent

	@Override
	public Collection<Event> getAllEvents() {
		List<Event> events = new ArrayList<>();
		try {
			Connection conn = _pool.getConnection();
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from Event;");
			while (result.next()) {
				events.add(new Event(result.getLong("Id"), result.getString("Name"),
						new Date(result.getDate("Date").getTime()), EventStatus.valueOf(result.getString("Status")),
						EventType.valueOf(result.getString("Type")), result.getString("Place"),
						result.getDouble("Price"), result.getInt("Participants_quantity"),
						_organizerDao.getOrganizer(result.getLong("Organizer"))));
			}
			result.close();
			statement.close();
			_pool.returnConnection(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return events;
	}// getAllEvents

	@Override
	public Collection<Event> getEventsByType(EventType type) {
		List<Event> eventsByType = new ArrayList<>();
		List<Event> events = (ArrayList<Event>) getAllEvents();
		for (Event curr : events) {
			if (type.equals(curr.get_type())) {
				eventsByType.add(curr);
			}
		}
		return eventsByType;
	}// getEventsByType

	@Override
	public Collection<Event> getEventsByOrganizer(Organizer org) {
		List<Event> eventsByOrganizer = new ArrayList<>();
		List<Event> events = (ArrayList<Event>) getAllEvents();
		for (Event curr : events) {
			if (org.get_id() == curr.get_organizer().get_id()) {
				eventsByOrganizer.add(curr);
			}
		}
		return eventsByOrganizer;
	}// getEventsByOrganizer

	@Override

	public Event getEventByName(String name) {
		Event event = null;
		try {
			Connection conn = _pool.getConnection();
			PreparedStatement statement = conn.prepareStatement("select * from Event where Name = ?;");
			statement.setString(1, name);
			ResultSet result = statement.executeQuery();
			result.next();
			event = new Event(result.getLong("Id"), result.getString("Name"),
					new Date(result.getDate("Date").getTime()), EventStatus.valueOf(result.getString("Status")),
					EventType.valueOf(result.getString("Type")), result.getString("Place"), result.getDouble("Price"),
					result.getInt("Participants_quantity"), _organizerDao.getOrganizer(result.getLong("Organizer")));
			_pool.returnConnection(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return event;
	}// getEventByName. Needed for validations in facade

	public void addEventToOrganizer_Event(Event event, Organizer currentOrganizer) {
		// TODO Auto-generated method stub

	}

}// EventDBDAO
