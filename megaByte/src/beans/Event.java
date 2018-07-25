package beans;

import java.util.Date;

/**
 * 
 * @author Igor Khavinson
 *
 */
public class Event {
//	Members:
	private final int _id;
	private String _name;
	private Date _date;
	private EventStatus _status;
	private EventType _type;
	private String _place;
	private double _price;
	private int _participantsQuantity;
	private String _organizer;

//	Constructors:

	public Event(int id, String _name, Date _date, EventStatus _status, EventType _type, String _place, double _price,
			int _participantsQuantity, String _organizer) {
		super();

		_id = id;
		this._name = _name;
		this._date = _date;
		this._status = _status;
		this._type = _type;
		this._place = _place;
		this._price = _price;
		this._participantsQuantity = _participantsQuantity;
		this._organizer = _organizer;
	}

//	Methods:
	public int getId() {
		return _id;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public Date get_date() {
		return _date;
	}

	public void set_date(Date _date) {
		this._date = _date;
	}

	public EventStatus get_status() {
		return _status;
	}

	public void set_status(EventStatus _status) {
		this._status = _status;
	}

	public EventType get_type() {
		return _type;
	}

	public void set_type(EventType _type) {
		this._type = _type;
	}

	public String get_place() {
		return _place;
	}

	public void set_place(String _place) {
		this._place = _place;
	}

	public double get_price() {
		return _price;
	}

	public void set_price(double _price) {
		this._price = _price;
	}

	public int get_participantsQuantity() {
		return _participantsQuantity;
	}

	public void set_participantsQuantity(int _participantsQuantity) {
		this._participantsQuantity = _participantsQuantity;
	}

	public String get_organizer() {
		return _organizer;
	}

	public void set_organizer(String _organizer) {
		this._organizer = _organizer;
	}

}// Event
