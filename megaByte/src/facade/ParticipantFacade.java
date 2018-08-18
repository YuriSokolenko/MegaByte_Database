package facade;

import dao.ParticipantDAO;
import dao.ParticipantDBDAO;
import exceptions.MegabyteSystemException;

public class ParticipantFacade implements MegabyteClientFacade {
	private ParticipantDAO partDAO = new ParticipantDBDAO();

	@Override
	public MegabyteClientFacade login(String name, String password, ClientType clientType)
			throws MegabyteSystemException {
		if (partDAO.login(name, password)) {
			return this;
		} else {
			throw new MegabyteSystemException("Name or password are incorrect");
		}
	}// login

}
