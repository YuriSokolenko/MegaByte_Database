package beans;

import java.util.Date;

public class Participant {
//	Members:
	protected final int _id;
	protected String _firstName;
	protected int _telNumber;
	protected String _city;
	protected String _district;
	protected Date _birthdate;
	protected Date _repatriationYear;
	protected String _interests;
	protected Date _lastActiveDate;
	protected Gender _gender;

//	Constructors:
	public Participant(int _id, String _firstName, int _telNumber, String _city, String _district, Date _birthdate,
			Date _repatriationYear, String _interests, Date _lastActiveDate, Gender _gender) {
		super();
		this._id = _id;
		this._firstName = _firstName;
		this._telNumber = _telNumber;
		this._city = _city;
		this._district = _district;
		this._birthdate = _birthdate;
		this._repatriationYear = _repatriationYear;
		this._interests = _interests;
		this._lastActiveDate = _lastActiveDate;
		this._gender = _gender;
	}

	public String get_firstName() {
		return _firstName;
	}

	public void set_firstName(String _firstName) {
		this._firstName = _firstName;
	}

	public int get_telNumber() {
		return _telNumber;
	}

	public void set_telNumber(int _telNumber) {
		this._telNumber = _telNumber;
	}

	public String get_city() {
		return _city;
	}

	public void set_city(String _city) {
		this._city = _city;
	}

	public String get_district() {
		return _district;
	}

	public void set_district(String _district) {
		this._district = _district;
	}

	public Date get_birthdate() {
		return _birthdate;
	}

	public void set_birthdate(Date _birthdate) {
		this._birthdate = _birthdate;
	}

	public Date get_repatriationYear() {
		return _repatriationYear;
	}

	public void set_repatriationYear(Date _repatriationYear) {
		this._repatriationYear = _repatriationYear;
	}

	public String get_interests() {
		return _interests;
	}

	public void set_interests(String _interests) {
		this._interests = _interests;
	}

	public Date get_lastActiveDate() {
		return _lastActiveDate;
	}

	public void set_lastActiveDate(Date _lastActiveDate) {
		this._lastActiveDate = _lastActiveDate;
	}

	public Gender get_gender() {
		return _gender;
	}

	public void set_gender(Gender _gender) {
		this._gender = _gender;
	}

	public int get_id() {
		return _id;
	}

//	Methods

}// Participant
