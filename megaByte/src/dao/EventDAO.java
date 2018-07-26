package dao;

import java.util.Collection;

import beans.Event;
import beans.EventType;
import beans.Organizer;

public interface EventDAO {
	/**
	 * 
	 * @param event
	 */
	public void createEvent(Event event);

	public void removeEvent(Event event);

	public void updateEvent(Event event);

	public Event getEvent(long id);

	public Collection<Event> getAllEvents();

	public Collection<Event> getEventsByType(EventType type);

	public Collection<Event> getEventsByOrganizer(Organizer org);

}
