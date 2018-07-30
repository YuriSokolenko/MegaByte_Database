package beans;

import java.util.Collection;
import java.util.Date;

public class Organizer extends Participant {
	private int _eventsQuant;

	// Constructors:
	public Organizer(long _id, String _firstName, String lastName, int _telNumber, String adress, String _city,
			String _district, Date _birthdate, Date _repatriationYear, String _interests, Date _lastActiveDate,
			Gender _gender, int eventsQuant) {
		super(_id, _firstName, lastName, _telNumber, adress, _city, _district, _birthdate, _repatriationYear,
				_interests, _lastActiveDate, _gender);
		_eventsQuant = eventsQuant;

	}// C-tor

	public Organizer(long id, String firstName, String lastName, int telNumber, int eventsQuant) {
		super(id);
		_firstName = firstName;
		_lastName = lastName;
		_telNumber = telNumber;
		_eventsQuant = eventsQuant;
	}

	// Methods:
	public int get_eventsQuant() {
		return _eventsQuant;
	}

	public void set_eventsQuant(int _eventsQuant) {
		this._eventsQuant = _eventsQuant;
	}

	@Override
	public String toString() {
		return "Organizer [_eventsQuant=" + _eventsQuant + ", _id=" + _id + ", _firstName=" + _firstName
				+ ", _lastName=" + _lastName + "]";
	}

	public Collection<Event> getAllEVents() {
		// TODO Auto-generated method stub
		return null;
	}

}// Participant
