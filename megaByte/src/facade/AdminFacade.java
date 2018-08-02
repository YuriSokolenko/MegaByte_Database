package facade;

import java.util.Collection;

import beans.Organizer;
import beans.Participant;
import dao.EventDBDAO;
import dao.OrganizerDBDAO;
import dao.ParticipantDBDAO;
import exceptions.MegabyteSystemException;

public class AdminFacade extends Client implements MegabyteClientFacade {

	private EventDBDAO _eventDAO = new EventDBDAO();
	private OrganizerDBDAO _organizerDAO = new OrganizerDBDAO();
	private ParticipantDBDAO _participantDAO = new ParticipantDBDAO();

	public AdminFacade() {

	}

	@Override
	public MegabyteClientFacade login(String name, String password, ClientType clientType) {
		if (clientType == ClientType.ADMIN) {
			if (name == "admin" && password == "1234") {
				return new AdminFacade();
			} else {
				System.out.println("Username or password is incorrect. Please try again ");
			}
		}
		return null;
	}

	public void createOrganizer(Organizer org) throws MegabyteSystemException {
		if (_organizerDAO.getOrganizer(org.get_id()) == null) {
			_organizerDAO.createOrganizer(org);
		} else {
			throw new MegabyteSystemException("This organizer is already exist");
		}
	}

	public void createParticipant(Participant part) throws MegabyteSystemException {
		if (_participantDAO.getParticipant(part.get_id()) == null) {
			_participantDAO.createParticipant(part);
		} else {
			throw new MegabyteSystemException("This participant is already exist");
		}
	}

	public void removeOrganizer(Organizer org) throws MegabyteSystemException {
		if (_organizerDAO.getOrganizer(org.get_id()) != null) {
			_organizerDAO.removeOrganizer(org);
		} else
			throw new MegabyteSystemException("Can`t remove organizer, the organizer not found");
	}

	public void removeParticipant(Participant part) throws MegabyteSystemException {
		if (_participantDAO.getParticipant(part.get_id()) != null) {
			_participantDAO.removeParticipant(part);
		} else
			throw new MegabyteSystemException("Can`t remove participant, the participant not found");
	}

	public void updateOrganizer(Organizer org) {
		_organizerDAO.removeOrganizer(org);
	}

	public void updateParticipant(Participant part) {
		_participantDAO.removeParticipant(part);
	}

	public Organizer getOrganizer(long id) {
		return _organizerDAO.getOrganizer(id);
	}

	public Participant getParticipant(long id) {
		return _participantDAO.getParticipant(id);
	}

	public Collection<Organizer> getAllOrganizer() {
		return _organizerDAO.getAllOrganizers();
	}

}
