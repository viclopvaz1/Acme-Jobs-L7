
package acme.features.employer.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerApplicationUpdateService implements AbstractUpdateService<Employer, Application> {

	@Autowired
	EmployerApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		boolean result;
		int jobId;
		Application application;
		Job job;

		jobId = request.getModel().getInteger("id");
		application = this.repository.findOneById(jobId);
		job = application.getJob();
		result = application.getJob().getId() == job.getId();

		return result;
	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "referenceNumber", "moment", "statement", "reason");
		request.bind(entity, errors, "status", "skills", "qualifications", "job.reference", "worker.identity.fullName");

	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "referenceNumber", "moment", "statement", "reason");
		request.unbind(entity, model, "status", "skills", "qualifications", "job.reference", "worker.identity.fullName");

		//		if (request.isMethod(HttpMethod.GET)) {
		//			entity.setStatus(request.getModel().getString("nstatus"));
		//		}

	}

	@Override
	public Application findOne(final Request<Application> request) {
		// TODO Auto-generated method stub
		assert request != null;
		Application result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;

	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		// TODO Auto-generated method stu
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("reason")) {
			errors.state(request, entity.getReason() != null && entity.getReason() != "" || !entity.getStatus().equals("rejected"), "reason", "employer.application.error.reason");

		}

	}

	@Override
	public void update(final Request<Application> request, final Application entity) {
		// TODO Auto-generated method stub

		assert request != null;
		assert entity != null;
		//		if (request.isMethod(HttpMethod.GET)) {
		//			entity.setStatus(request.getModel().getString("nstatus"));
		//		}
		this.repository.save(entity);
	}

}
