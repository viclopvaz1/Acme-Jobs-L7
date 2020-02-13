
package acme.features.employer.job;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.duties.Duty;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.features.authenticated.duty.AuthenticatedDutyRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractDeleteService;

@Service
public class EmployerJobDeleteService implements AbstractDeleteService<Employer, Job> {

	@Autowired
	EmployerJobRepository		repository;

	@Autowired
	AuthenticatedDutyRepository	dutyRepository;


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

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "deadline", "salary", "title", "description", "moreInfo", "status");

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

		Principal principal;
		int employerId;
		int totalApplications;
		int idJob;
		int totalAuditRecords;

		if (!errors.hasErrors("references")) {
			principal = request.getPrincipal();
			employerId = principal.getAccountId();
			idJob = request.getModel().getInteger("id");
			totalApplications = this.repository.findTotalApplicationByEmployerId(employerId);
			totalAuditRecords = this.repository.findAllAuditRecordByJobId(idJob);
			errors.state(request, totalApplications == 0 && totalAuditRecords == 0, "reference", "employer.job.form.error.hasApplicationOrAuditRecord");
		}

	}

	@Override
	public void delete(final Request<Job> request, final Job entity) {
		assert request != null;
		assert entity != null;
		Collection<Duty> duties;
		duties = this.dutyRepository.findManyByJobId(entity.getId());
		for (Duty d : duties) {
			this.dutyRepository.delete(d);
		}
		this.repository.delete(entity);

	}

}
