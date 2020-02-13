
package acme.features.administrator.announcement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import acme.entities.announcements.Announcement;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractDeleteService;

@Repository
public class AdministratorAnnouncementDeleteService implements AbstractDeleteService<Administrator, Announcement> {

	@Autowired
	AdministratorAnnouncementRepository repository;


	@Override
	public boolean authorise(final Request<Announcement> request) {
		// TODO Auto-generated method stub

		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Announcement> request, final Announcement entity, final Errors errors) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors, "moment");

	}

	@Override
	public void unbind(final Request<Announcement> request, final Announcement entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "text", "moreInfo");
	}
	@Override
	public Announcement findOne(final Request<Announcement> request) {
		// TODO Auto-generated method stub
		assert request != null;
		Announcement result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;

	}

	@Override
	public void validate(final Request<Announcement> request, final Announcement entity, final Errors errors) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void delete(final Request<Announcement> request, final Announcement entity) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		this.repository.delete(entity);
	}

}
