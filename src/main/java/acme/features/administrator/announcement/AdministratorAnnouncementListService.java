
package acme.features.administrator.announcement;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.announcements.Announcement;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorAnnouncementListService implements AbstractListService<Administrator, Announcement> {

	@Autowired
	AdministratorAnnouncementRepository repository;


	@Override
	public boolean authorise(final Request<Announcement> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Announcement> request, final Announcement entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "moment", "title");

	}

	@Override
	public Collection<Announcement> findMany(final Request<Announcement> request) {
		assert request != null;

		Collection<Announcement> result;

		result = this.repository.findMany();

		return result;
	}
}
