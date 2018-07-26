package dao;

import java.util.Collection;

import beans.Gender;
import beans.Interests;
import beans.Participant;

public class ParticipantDBDAO implements ParticipantDAO {

	@Override
	public void createParticipant(Participant participant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeParticipant(Participant participant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateParticipant(Participant participant) {
		// TODO Auto-generated method stub

	}

	@Override
	public Participant getParticipant(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Participant> getAllParticipants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Participant> getParticipantsByInterests(Interests interest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Participant> getParticipantsByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Participant> getParticipantsByAge(int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Participant> getParticipantsByDistrict(String city, String district) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Participant> getParticipantsByGender(Gender gen) {
		// TODO Auto-generated method stub
		return null;
	}

}
