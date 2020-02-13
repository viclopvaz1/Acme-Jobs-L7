
package acme.features.auditor.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.entities.roles.Auditor;
import acme.features.auditor.auditrecord.AuditorAuditRecordRepository;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class AuditorJobShowService implements AbstractShowService<Auditor, Job> {

	@Autowired
	AuditorJobRepository			repository;

	@Autowired
	AuditorAuditRecordRepository	auditRecordRepository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;
		//
		//		boolean result;
		//		int auditRecordId;
		//		Collection<AuditRecord> auditRecord;
		//		Principal principal;
		//
		//		principal = request.getPrincipal();
		//		auditRecordId = request.getModel().getInteger("id");
		//		auditRecord = this.repository.findAuditRecordById(auditRecordId);
		//
		//		result = auditRecord.to == principal.getAccountId();
		//
		//		return result;
		return true;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "title", "deadline", "description", "moreInfo", "salary", "employer.identity.fullName");

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

}
