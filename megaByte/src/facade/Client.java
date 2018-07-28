package facade;

public class Client implements MegabyteClientFacade {

	@Override
	public MegabyteClientFacade login(String name, String password, ClientType clientType) {
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
	}
}