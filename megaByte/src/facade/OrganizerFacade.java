package facade;

import beans.Event;
import beans.Organizer;
import dao.EventDBDAO;
import dao.OrganizerDBDAO;
import dao.ParticipantDBDAO;
import exceptions.MegabyteSystemException;

public class OrganizerFacade extends Client implements MegabyteClientFacade {

	private EventDBDAO _eventDAO = new EventDBDAO();
	private OrganizerDBDAO _organizerDAO = new OrganizerDBDAO();
	private ParticipantDBDAO _participantDAO = new ParticipantDBDAO();
	private static Organizer _currentOrganizer;

	@Override
	public MegabyteClientFacade login(String name, String password, ClientType clientType) {
		// TODO Auto-generated method stub
		return super.login(name, password, clientType);

	}

	public Event createEvent(Event event) throws MegabyteSystemException {
		// validation if the Event exist
		if (_eventDAO.getEvent(event.getId()) != null) {
			throw new MegabyteSystemException("This Event is already exist");
		} else {
			_eventDAO.createEvent(event);
			_eventDAO.addEventToOrganizer_Event(event, _currentOrganizer);
			System.out.println("Event created");
		}
		// 1223
		return event;

	}

}
