
package acme.features.authenticated.thread;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.participations.Participation;
import acme.entities.threads.Thread;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedThreadCreateService implements AbstractCreateService<Authenticated, Thread> {

	@Autowired
	AuthenticatedThreadRepository repository;


	@Override
	public boolean authorise(final Request<Thread> request) {

		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Thread> request, final Thread entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "title");
	}

	@Override
	public void bind(final Request<Thread> request, final Thread entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");

	}

	@Override
	public Thread instantiate(final Request<Thread> request) {
		assert request != null;

		Thread result;

		result = new Thread();

		Date moment = new Date(System.currentTimeMillis() - 1);
		result.setMoment(moment);

		Principal principal = request.getPrincipal();
		int authenticatedId = principal.getActiveRoleId();
		Authenticated creatorUser = this.repository.findAuthenticatedById(authenticatedId);
		result.setCreatorUser(creatorUser);

		return result;
	}

	@Override
	public void validate(final Request<Thread> request, final Thread entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Collection<String> titles;

		if (!errors.hasErrors("title")) {
			titles = this.repository.allTitles();
			errors.state(request, !titles.contains(entity.getTitle()), "title", "authenticated.thread.form.error.title");
		}

	}

	@Override
	public void create(final Request<Thread> request, final Thread entity) {
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		Participation participation = new Participation();
		Principal principal = request.getPrincipal();
		participation.setAuthenticated(this.repository.findAuthenticatedById(principal.getActiveRoleId()));
		entity.setMoment(moment);
		participation.setThread(entity);
		this.repository.save(entity);
		this.repository.save(participation);
	}
}
