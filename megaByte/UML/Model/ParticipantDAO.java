
import java.util.*;

/**
 * 
 */
public interface ParticipantDAO {

    /**
     * @param Participant 
     * @return
     */
    public void; CreateParticipant(void Participant);

    /**
     * @param Participant 
     * @return
     */
    public void; removeParticipant(void Participant);

    /**
     * @param Participant 
     * @return
     */
    public void; updateParticipant(void Participant);

    /**
     * @param Interest 
     * @return
     */
    public Collection<Participant>; getParticipantsByInterest(void Interest);

    /**
     * @return
     */
    public Collection<Participant>; getAllParticipants();

    /**
     * @param City 
     * @return
     */
    public Collection<Participant>; getParticipantsByCity(void City);

    /**
     * @param int minAge 
     * @param int maxAge 
     * @return
     */
    public Collection<Participant>; getParticipantsByAge(void int minAge, void int maxAge);

    /**
     * @param City 
     * @param District 
     * @return
     */
    public Collection<Partcipant>; getParticipantsByDistrict(void City, void District);

    /**
     * @param Gender 
     * @return
     */
    public Collection<Participant>; getParticipantsByGender(void Gender);

}