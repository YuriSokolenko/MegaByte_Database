package facade;

import java.util.Collection;

import beans.Event;
import beans.EventType;
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
		// TODO need fix this
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

		return event;

	}

	public void removeCoupon(Event event) {
		if (_eventDAO.getEvent(event.getId()) != null) {
			_eventDAO.removeEvent(event);
			_eventDAO.removeEventFromJoinTables(event);
		}
	}

	public void updateEvent(Event event) {
		_eventDAO.updateEvent(event);
	}

	public Event getEvent(long id) {
		return _eventDAO.getEvent(id);
	}

	public Collection<Event> getAllEvents() {
		return _currentOrganizer.getAllEVents();
	}

	public Collection<Event> getCouponsByType(EventType type) {
		return _eventDAO.getEventsByType(type);
	}
}
