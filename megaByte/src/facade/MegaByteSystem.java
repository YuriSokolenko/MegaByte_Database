package facade;

import exceptions.MegabyteSystemException;

public class MegaByteSystem implements MegabyteClientFacade {
	private static MegaByteSystem _instance = new MegaByteSystem();

	private MegaByteSystem() {

	}// c-tor

	private static MegaByteSystem getMegaByteSystem() {
		return _instance;
	}// getInstance

	@Override
	public MegabyteClientFacade login(String name, String password, ClientType clientType)
			throws MegabyteSystemException {
		switch (clientType) {
		case ADMIN:
			return new AdminFacade().login(name, password, clientType);
		case ORGANIZER:
			return new OrganizerFacade().login(name, password, clientType);
		case PARTICIPANT:
			return new ParticipantFacade().login(name, password, clientType);
		default:
			return null;
		}
	}// login
}// MegaByteSystem