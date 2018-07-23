package beans;

import java.util.Date;

public class Organizer extends Participant {
	private int _eventsQuant;

	public Organizer(int _id, String _firstName, int _telNumber, String _city, String _district, Date _birthdate,
			Date _repatriationYear, String _interests, Date _lastActiveDate, Gender _gender, int eventsQuant) {
		super(_id, _firstName, _telNumber, _city, _district, _birthdate, _repatriationYear, _interests, _lastActiveDate,
				_gender);
		_eventsQuant = eventsQuant;

	}// C-tor

	public int get_eventsQuant() {
		return _eventsQuant;
	}

	public void set_eventsQuant(int _eventsQuant) {
		this._eventsQuant = _eventsQuant;
	}

}// Participant
