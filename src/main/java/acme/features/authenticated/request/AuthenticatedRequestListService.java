
package acme.features.authenticated.request;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requests.Request;
import acme.framework.components.Model;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedRequestListService implements AbstractListService<Authenticated, Request> {

	@Autowired
	AuthenticatedRequestRepository repository;


	@Override
	public boolean authorise(final acme.framework.components.Request<acme.entities.requests.Request> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final acme.framework.components.Request<acme.entities.requests.Request> request, final acme.entities.requests.Request entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "title", "text", "deadline");
	}

	@Override
	public Collection<acme.entities.requests.Request> findMany(final acme.framework.components.Request<acme.entities.requests.Request> request) {
		assert request != null;
		Collection<Request> result;
		Calendar cal = Calendar.getInstance();
		Date moment = cal.getTime();

		Calendar calendar;
		calendar = new GregorianCalendar();
		calendar.add(Calendar.MONTH, -1);
		moment = calendar.getTime();
		result = this.repository.findManyByMoment(moment);

		return result;
	}
}
