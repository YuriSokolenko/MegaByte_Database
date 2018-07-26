
import java.util.*;

/**
 * 
 */
public interface EventDAO {

    /**
     * @param Event 
     * @return
     */
    public void; createEvent(void Event);

    /**
     * @param Event 
     * @return
     */
    public void; removeEvent(void Event);

    /**
     * @param Event 
     * @return
     */
    public void; updateEvent(void Event);

    /**
     * @param long id 
     * @return
     */
    public Event; getEvent(void long id);

    /**
     * @return
     */
    public Collection<Event>; getAllEvents();

    /**
     * @param Organizer 
     * @return
     */
    public Collection<Event>; getEventsByOrganizer(void Organizer);

    /**
     * @param EventType 
     * @return
     */
    public Collection<Event>; getEventsByType(void EventType);

}