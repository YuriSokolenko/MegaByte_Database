package dao;

import java.util.Collection;

import beans.Gender;
import beans.Interests;
import beans.Participant;

public interface ParticipantDAO {
	public void createParticipant(Participant participant);

	public void removeParticipant(Participant participant);

	public void updateParticipant(Participant participant);

	public Participant getParticipant(int id);

	public Collection<Participant> getAllParticipants();

	public Collection<Participant> getParticipantsByInterests(Interests interest);

	public Collection<Participant> getParticipantsByCity(String city);

	public Collection<Participant> getParticipantsByAge(int minAge, int maxAge);

	public Collection<Participant> getParticipantsByDistrict(String city, String district);

	public Collection<Participant> getParticipantsByGender(Gender gen);
}
