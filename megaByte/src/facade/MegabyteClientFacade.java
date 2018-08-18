package facade;

import exceptions.MegabyteSystemException;

public interface MegabyteClientFacade {

	public abstract MegabyteClientFacade login(String name, String password, ClientType clientType)
			throws MegabyteSystemException;

}
