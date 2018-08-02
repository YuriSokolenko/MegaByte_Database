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
import beans.Gender;
import beans.Participant;
import utils.ConnectionPool;

public class ParticipantDBDAO implements ParticipantDAO {
	private ConnectionPool _pool;
	EventDAO _eventDAO;

	public ParticipantDBDAO() {
		super();
		_pool = ConnectionPool.getConnectionPool();
		_eventDAO = new EventDBDAO();
	}// c-tor

	@Override
	public void createParticipant(Participant participant) {
		try {
			Connection conn = _pool.getConnection();
			PreparedStatement statement = conn.prepareStatement(
					"insert into `Participant` (Id, First_Name, Last_Name, Tel_Number, Adress, City, District, Birthdate, Repatriation_year, Interests, Gender) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ");
			statement.setLong(1, participant.get_id());
			statement.setString(2, participant.get_firstName());
			statement.setString(3, participant.get_lastName());
			statement.setInt(4, participant.get_telNumber());
			statement.setString(5, participant.get_adress());
			statement.setString(6, participant.get_city());
			statement.setString(7, participant.get_district());
			statement.setDate(8, new Date(participant.get_birthdate().getTime()));
			statement.setDate(9, new Date(participant.get_repatriationYear().getTime()));
			statement.setString(10, participant.get_interests());
			statement.setString(11, participant.get_gender().toString());
			statement.executeUpdate();
			statement.close();
			_pool.returnConnection(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// createParticipant

	@Override
	public void removeParticipant(Participant participant) {
		try {
			Connection conn = _pool.getConnection();
			PreparedStatement statement = conn.prepareStatement("delete from `Participant` where Id = ?;");
			statement.setLong(1, participant.get_id());
			statement.executeUpdate();
			statement.close();
			statement = conn.prepareStatement("delete from Participant_event where Participant_id = ?;");
			statement.setLong(1, participant.get_id());
			statement.close();
			_pool.returnConnection(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// removeParticipant

	@Override
	public void updateParticipant(Participant participant) {
		try {
			Connection conn = _pool.getConnection();
			PreparedStatement statement = conn.prepareStatement(
					"update `Participant` set First_Name = ?, Last_Name = ?, Tel_Number = ?, Adress = ?, City = ?, District = ?, Birthdate = ?, Repatriation_year = ?, Interests = ?, Gender = ? where Id = ?;");
			statement.setString(1, participant.get_firstName());
			statement.setString(2, participant.get_lastName());
			statement.setInt(3, participant.get_telNumber());
			statement.setString(4, participant.get_adress());
			statement.setString(5, participant.get_city());
			statement.setString(6, participant.get_district());
			statement.setDate(7, new Date(participant.get_birthdate().getTime()));
			statement.setDate(8, new Date(participant.get_repatriationYear().getTime()));
			statement.setString(9, participant.get_interests());
			statement.setString(10, participant.get_gender().toString());
			statement.setLong(11, participant.get_id());
			statement.executeUpdate();
			statement.close();
			_pool.returnConnection(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// updateParticipant

	@Override
	public Participant getParticipant(long id) {
		Participant participant = null;
		try {
			Connection conn = _pool.getConnection();
			PreparedStatement statement = conn.prepareStatement("select * from `Participant` where Id = ?;");
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			result.next();
			participant = new Participant(result.getLong("Id"), result.getString("First_name"),
					result.getString("Last_name"), result.getInt("Tel_number"), result.getString("Adress"),
					result.getString("City"), result.getString("District"),
					new java.util.Date(result.getDate("Birthdate").getTime()),
					new java.util.Date(result.getDate("Repatriation_year").getTime()), result.getString("Interests"),
					new java.util.Date(result.getDate("Last_active date").getTime()),
					Gender.valueOf(result.getString("Gender")));
			statement.close();
			result.close();
			_pool.returnConnection(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return participant;
	}// getParticipant

	@Override
	public Collection<Participant> getAllParticipants() {
		List<Participant> participants = new ArrayList<>();
		try {
			Connection conn = _pool.getConnection();
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from `Participant`;");
			while (result.next()) {
				participants.add(new Participant(result.getLong("Id"), result.getString("First_name"),
						result.getString("Last_name"), result.getInt("Tel_number"), result.getString("Adress"),
						result.getString("City"), result.getString("District"),
						new java.util.Date(result.getDate("Birthdate").getTime()),
						new java.util.Date(result.getDate("Repatriation_year").getTime()),
						result.getString("Interests"), new java.util.Date(result.getDate("Last_active date").getTime()),
						Gender.valueOf(result.getString("Gender"))));
			}
			result.close();
			statement.close();
			_pool.returnConnection(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return participants;
	}// gelAllParticipants

	@Override
	public Collection<Participant> getParticipantsByInterests(String interest) {
		List<Participant> participantsByInterests = new ArrayList<>();
		try {
			Connection conn = _pool.getConnection();
			PreparedStatement statement = conn
					.prepareStatement("select * from `Participant` where `Interests` in (?);");
			statement.setString(1, interest.toString());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				participantsByInterests.add(new Participant(result.getLong("Id"), result.getString("First_name"),
						result.getString("Last_name"), result.getInt("Tel_number"), result.getString("Adress"),
						result.getString("City"), result.getString("District"),
						new java.util.Date(result.getDate("Birthdate").getTime()),
						new java.util.Date(result.getDate("Repatriation_year").getTime()),
						result.getString("Interests"), new java.util.Date(result.getDate("Last_active date").getTime()),
						Gender.valueOf(result.getString("Gender"))));
			}
			result.close();
			statement.close();
			_pool.returnConnection(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return participantsByInterests;
	}// getParticipantsByInterests

	@Override
	public Collection<Participant> getParticipantsByCity(String city) {
		List<Participant> participants = (ArrayList<Participant>) getAllParticipants();
		List<Participant> participantsByCity = new ArrayList<>();
		for (Participant curr : participants) {
			if (city.equals(curr.get_city())) {
				participantsByCity.add(curr);
			}
		}
		return participantsByCity;
	}// getParticipantsByCity

	@Override
	public Collection<Participant> getParticipantsByAge(Date minAge, Date maxAge) {
		List<Participant> participants = (ArrayList<Participant>) getAllParticipants();
		List<Participant> participantsByAge = new ArrayList<>();
		for (Participant curr : participants) {
			if (curr.get_birthdate().getTime() >= minAge.getTime()
					&& curr.get_birthdate().getTime() <= maxAge.getTime()) {
				participantsByAge.add(curr);
			}
		}
		return participantsByAge;
	}// getParticipantsByAge

	@Override
	public Collection<Participant> getParticipantsByDistrict(String city, String district) {
		List<Participant> participants = (ArrayList<Participant>) getAllParticipants();
		List<Participant> participantsByDistrict = new ArrayList<>();
		for (Participant curr : participants) {
			if (city.equals(curr.get_city()) && district.equals(curr.get_district())) {
				participantsByDistrict.add(curr);
			}
		}
		return participantsByDistrict;
	}// getParticipantsByDistrict

	@Override
	public Collection<Participant> getParticipantsByGender(Gender gen) {
		List<Participant> participants = (ArrayList<Participant>) getAllParticipants();
		List<Participant> participantsByGender = new ArrayList<>();
		for (Participant curr : participants) {
			if (gen.equals(curr.get_gender())) {
				participantsByGender.add(curr);
			}
		}
		return participantsByGender;
	}// getParticipantsByGender

	@Override
	public void signInToEvent(Event event, Participant participant) {
		event.set_participantsQuantity(1);
		_eventDAO.updateEvent(event);
		Connection conn;
		try {
			conn = _pool.getConnection();
			PreparedStatement stm = conn
					.prepareStatement("insert into Participant_event(Participant_id, Event_id) values(?, ?);");
			stm.setLong(1, participant.get_id());
			stm.setLong(1, event.getId());
			stm.close();
			_pool.returnConnection(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// signInToEvent

}// ParticipantDBDAO
