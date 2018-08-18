
import java.util.*;

/**
 * 
 */
public interface OrganizerDAO {

    /**
     * @param Organizer 
     * @return
     */
    public void; CreateOrganizer(void Organizer);

    /**
     * @param Organizer 
     * @return
     */
    public void; removeOrganizer(void Organizer);

    /**
     * @param Organizer 
     * @return
     */
    public void; updateOrganizer(void Organizer);

    /**
     * @param long id 
     * @return
     */
    public Organizer; getOrganizer(void long id);

    /**
     * @return
     */
    public Collection<Organizer>; getAllOrganizers();

}