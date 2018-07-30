package facade;

import java.util.Collection;

import beans.Event;
import dao.EventDBDAO;
import dao.OrganizerDBDAO;
import dao.ParticipantDBDAO;
import exceptions.MegabyteSystemException;

public class AdminFacade extends Client implements MegabyteClientFacade {

	private EventDBDAO _eventDAO = new EventDBDAO();
	private OrganizerDBDAO _organizerDAO = new OrganizerDBDAO();
	private ParticipantDBDAO _participantDAO = new ParticipantDBDAO();

	public AdminFacade() {

	}

	// 123
	@Override
	public MegabyteClientFacade login(String name, String password, ClientType clientType) {
		if (clientType == ClientType.ADMIN) {
			if (name == "admin" && password == "1234") {
				return new AdminFacade();
			} else {
				System.out.println("Username or password is incorrect. Please try again ");
			}
		}
		return null;
	}

	public void createEvent(Event event) throws MegabyteSystemException {
		// validate if the event exist and if there is event with same name
		try {
			if ((_eventDAO.getEvent(event.getId()) == null)) {
				{
					if (_eventDAO.getEventByName(event.get_name()) == null) {
						_eventDAO.createEvent(event);
					}
				}
			} else {
				throw new MegabyteSystemException("Company with the same name or ID already exist");
			}
		} catch (

		MegabyteSystemException e) {
			throw new MegabyteSystemException("Can`t create Company ", e);
		}
	}

	// delete company and all its coupons
	public void removeCompany(Company company) throws MegabyteSystemException {
		try {
			companyDao.removeAllCouponsOfCompany(company);
		} catch (MegabyteSystemException e) {
			throw new MegabyteSystemException("Can`t remove coupons of this company", e);
		}
		try {
			companyDao.removeCompany(company);
		} catch (MegabyteSystemException e) {
			throw new MegabyteSystemException("Cant remove the Company", e);
		}
	}

	public void updateCompany(Company company) {
		companyDao.updateCompany(company);
	}

	public Company getCompany(long id) throws MegabyteSystemException {
		return companyDao.getCompany(id);
	}

	public Collection<Company> getAllCompanies() throws MegabyteSystemException {
		return companyDao.getAllCompanies();
	}

	public void createCustomer(Customer cust) {
		customerDao.createCustomer(cust);
	}

	public void removeCustomer(Customer cust) {
		customerDao.removeCustomer(cust);
	}

	public void updateCustomer(Customer cust) {
		customerDao.removeCustomer(cust);
	}

	public Customer getCustomer(long id) {
		return customerDao.getCustomer(id);
	}

	public Collection<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

}
