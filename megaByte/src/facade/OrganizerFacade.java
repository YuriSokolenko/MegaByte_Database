package facade;

public class OrganizerFacade extends Client implements MegabyteClientFacade {

	@Override
	public MegabyteClientFacade login(String name, String password, ClientType clientType) {
		// TODO Auto-generated method stub
		return super.login(name, password, clientType);
	}

}
