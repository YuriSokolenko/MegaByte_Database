package beans;

public enum Gender {
	MALE("Male"), FEMALE("Female"), NOT_SPECIFIED("Not specified");
	private final String _gender;

	private Gender(String gender) {
		_gender = gender;
	}// c-tor

	@Override
	public String toString() {
		return _gender;
	}
}
