
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
import acme.features.authenticated.duty.AuthenticatedDutyRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerJobUpdateService implements AbstractUpdateService<Employer, Job> {

	@Autowired
	EmployerJobRepository		repository;

	@Autowired
	AuthenticatedDutyRepository	dutyRepository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		boolean result;
		int jobId;
		Job job;
		Employer employer;
		Principal principal;

		jobId = request.getModel().getInteger("id");
		job = this.repository.findOneById(jobId);
		employer = job.getEmployer();
		principal = request.getPrincipal();
		result = employer.getUserAccount().getId() == principal.getAccountId();

		return result;
		//		return true;
	}

	@Override
	public void bind(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "deadline", "title", "description", "moreInfo", "status");

	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;
		Job result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Double sumDuties;
		int id;
		Collection<String> references;
		String reference;
		Calendar calendar;
		Date minimunDeadline;

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
			id = request.getModel().getInteger("id");
			sumDuties = this.dutyRepository.sumDutiesJob(id);
			if (sumDuties == null) {
				sumDuties = 0.;
			}
			errors.state(request, sumDuties == 1.00 || !request.getModel().getBoolean("status"), "reference", "employer.job.form.error.sumDuty");
		}

		if (!errors.hasErrors("reference")) {
			references = this.repository.allReferences();
			id = request.getModel().getInteger("id");
			reference = this.repository.findReferenceByJobId(id);
			errors.state(request, !references.contains(entity.getReference()) || reference.equals(entity.getReference()), "reference", "employer.job.form.error.reference");
		}

		if (!errors.hasErrors("title")) {
			boolean isSpam = true;
			for (String s : spam) {
				isSpam = entity.getTitle().contains(s);
			}

			errors.state(request, isSpam == false, "title", "employer.job.form.error.spamWordsTitle");
		}

		if (!errors.hasErrors("description")) {
			boolean isSpam = true;
			for (String s : spam) {
				isSpam = entity.getDescription().contains(s);
			}

			errors.state(request, isSpam == false, "description", "employer.job.form.error.spamWordsDescription");
		}
	}

	@Override
	public void update(final Request<Job> request, final Job entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
