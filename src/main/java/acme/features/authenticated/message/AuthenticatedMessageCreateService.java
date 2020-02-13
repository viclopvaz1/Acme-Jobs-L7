
package acme.features.authenticated.message;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messages.Message;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedMessageCreateService implements AbstractCreateService<Authenticated, Message> {

	@Autowired
	AuthenticatedMessageRepository repository;


	@Override
	public boolean authorise(final Request<Message> request) {

		assert request != null;
		boolean result = false;
		Principal principal = request.getPrincipal();

		Collection<Integer> authenticatedIds = this.repository.findManyAuthenticatedIdByThreadId(request.getModel().getInteger("threadId"));
		result = authenticatedIds.contains(principal.getActiveRoleId());

		return result;
	}

	@Override
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		Integer threadId = request.getModel().getInteger("threadId");
		model.setAttribute("title", "");
		model.setAttribute("body", "");
		model.setAttribute("tags", "");
		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("check", "false");
		} else {
			request.transfer(model, "check");
		}
		model.setAttribute("threadId", threadId);
		request.unbind(entity, model);
	}

	@Override
	public void bind(final Request<Message> request, final Message entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "thread", "authenticated");
	}

	@Override
	public Message instantiate(final Request<Message> request) {
		assert request != null;

		Message result;

		result = new Message();
		Date moment = new Date(System.currentTimeMillis() - 1);
		result.setMoment(moment);

		Integer threadId = request.getModel().getInteger("threadId");
		result.setThread(this.repository.findOneThreadById(threadId));
		result.setAuthenticated(this.repository.findAuthenticatedById(request.getPrincipal().getActiveRoleId()));

		return result;
	}

	@Override
	public void validate(final Request<Message> request, final Message entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean checker = request.getModel().getString("check").equals("true");

		errors.state(request, checker, "check", "authenticated.message.error.check");
		String palabrasSpam;
		String[] split;
		Collection<String> spam = new HashSet<>();

		palabrasSpam = this.repository.spamWords();
		split = palabrasSpam.split(", ");
		for (String s : split) {
			spam.add(s);
		}

		if (!errors.hasErrors("title")) {
			boolean isSpam = false;
			for (String s : spam) {
				if (entity.getTitle().toLowerCase().contains(s.toLowerCase())) {
					isSpam = true;
					break;

				}

			}

			errors.state(request, !isSpam, "title", "employer.job.form.error.spamWordsTitle");
		}

		if (!errors.hasErrors("body")) {
			boolean isSpam = false;
			for (String s : spam) {
				if (entity.getBody().toLowerCase().contains(s.toLowerCase())) {
					isSpam = true;
					break;
				}
			}

			errors.state(request, !isSpam, "body", "employer.job.form.error.spamWordsBody");
		}
		if (!errors.hasErrors("tags")) {
			boolean isSpam = false;
			for (String s : spam) {
				if (entity.getTags().toLowerCase().contains(s.toLowerCase())) {
					isSpam = true;
					break;
				}
			}

			errors.state(request, !isSpam, "tags", "employer.job.form.error.spamWordsTags");
		}
	}

	@Override
	public void create(final Request<Message> request, final Message entity) {

		this.repository.save(entity);

	}
}
