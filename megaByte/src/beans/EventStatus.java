package beans;

/**
 * 
 * @author Igor Khavinson
 *
 */
public enum EventStatus {
	OPEN("Open"), CLOSED("Closed"), NOT_APPROVED("Not Approved");

	private final String _name;

	private EventStatus(String name) {
		_name = name;
	}// c-tor

	@Override
	public String toString() {
		return _name;
	}

}
