package dao;

import java.util.Collection;

import beans.Organizer;

public interface OrganizerDAO {
	public void createOrganizer(Organizer org);

	public void removeOrganizer(Organizer org);

	public void updateOrganizer(Organizer org);

	public Organizer getOrganizer(long id);

	public Collection<Organizer> getAllOrganizers();
}
