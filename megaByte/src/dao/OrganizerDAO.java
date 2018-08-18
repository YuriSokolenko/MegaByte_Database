package dao;

import java.util.Collection;

import beans.Organizer;

public interface OrganizerDAO {
	public boolean login(String userName, String password);

	public void createOrganizer(Organizer org);

	public void removeOrganizer(Organizer org);

	public void updateOrganizer(Organizer org);

	public Organizer getOrganizer(long id);

	public Organizer getOrganizerByUserName(String userName, String password);

	public Collection<Organizer> getAllOrganizers();
}
