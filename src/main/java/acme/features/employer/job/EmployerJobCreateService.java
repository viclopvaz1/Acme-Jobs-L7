
package acme.features.employer.job;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerJobCreateService implements AbstractCreateService<Employer, Job> {

	@Autowired
	EmployerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "status", "employer");

	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "deadline", "salary", "title", "description", "moreInfo");
	}

	@Override
	public Job instantiate(final Request<Job> request) {

		Job result;

		result = new Job();

		Principal principal;
		Employer employer;
		int userAccountId;

		principal = request.getPrincipal();
		userAccountId = principal.getActiveRoleId();
		employer = this.repository.findEmployerById(userAccountId);
		result.setEmployer(employer);
		result.setStatus(false);
		return result;
	}

	@Override
	public void validate(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Calendar calendar;
		Date minimunDeadline;
		Collection<String> references;

		String palabrasSpam;
		String[] split;
		Collection<String> spam = new HashSet<>();

		palabrasSpam = this.repository.spamWords();
		split = palabrasSpam.split(", ");
		for (String s : split) {
			spam.add(s);
		}

		if (!errors.hasErrors("deadline")) {
			calendar = new GregorianCalendar();
			calendar.add(Calendar.DAY_OF_MONTH, 7);
			minimunDeadline = calendar.getTime();
			errors.state(request, entity.getDeadline().after(minimunDeadline), "deadline", "employer.job.form.error.tooClose");
		}

		if (!errors.hasErrors("salary")) {
			errors.state(request, entity.getSalary().getCurrency().equals("EUR") || entity.getSalary().getCurrency().equals("€"), "salary", "employer.job.form.error.zoneEurS");
		}

		if (!errors.hasErrors("reference")) {
			references = this.repository.allReferences();
			errors.state(request, !references.contains(entity.getReference()), "reference", "employer.job.form.error.reference");
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

		if (!errors.hasErrors("description")) {
			boolean isSpam = false;
			for (String s : spam) {
				if (entity.getDescription().toLowerCase().contains(s.toLowerCase())) {
					isSpam = true;
					break;
				}
			}

			errors.state(request, !isSpam, "description", "employer.job.form.error.spamWordsDescription");
		}

	}

	@Override
	public void create(final Request<Job> request, final Job entity) {

		this.repository.save(entity);

	}

}
