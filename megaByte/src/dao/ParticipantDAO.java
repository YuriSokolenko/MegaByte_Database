package dao;

import java.sql.Date;
import java.util.Collection;

import beans.Gender;
import beans.Participant;

public interface ParticipantDAO {
	public void createParticipant(Participant participant);

	public void removeParticipant(Participant participant);

	public void updateParticipant(Participant participant);

	public Participant getParticipant(long id);

	public Collection<Participant> getAllParticipants();

	public Collection<Participant> getParticipantsByInterests(String interest);

	public Collection<Participant> getParticipantsByCity(String city);

	public Collection<Participant> getParticipantsByAge(Date minAge, Date maxAge);

	public Collection<Participant> getParticipantsByDistrict(String city, String district);

	public Collection<Participant> getParticipantsByGender(Gender gen);
}
