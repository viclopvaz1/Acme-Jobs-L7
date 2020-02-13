
package acme.features.auditor.auditrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditrecords.AuditRecord;
import acme.entities.jobs.Job;
import acme.entities.roles.Auditor;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class AuditorAuditRecordUpdateService implements AbstractUpdateService<Auditor, AuditRecord> {

	@Autowired
	AuditorAuditRecordRepository repository;


	@Override
	public boolean authorise(final Request<AuditRecord> request) {
		assert request != null;
		boolean result;
		int jobId;
		AuditRecord auditRecord;
		Job job;

		jobId = request.getModel().getInteger("id");
		auditRecord = this.repository.findOneById(jobId);
		job = auditRecord.getJob();
		result = auditRecord.getJob().getId() == job.getId();

		return result;
	}

	@Override
	public void bind(final Request<AuditRecord> request, final AuditRecord entity, final Errors errors) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "title", "body", "moment");
		request.bind(entity, errors, "auditor.identity.fullName", "job.reference", "status");
	}

	@Override
	public void unbind(final Request<AuditRecord> request, final AuditRecord entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "body", "moment");
		request.unbind(entity, model, "auditor.identity.fullName", "job.reference", "status");

	}

	@Override
	public AuditRecord findOne(final Request<AuditRecord> request) {
		// TODO Auto-generated method stub
		assert request != null;
		AuditRecord result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;

	}

	@Override
	public void validate(final Request<AuditRecord> request, final AuditRecord entity, final Errors errors) {
		// TODO Auto-generated method stu
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void update(final Request<AuditRecord> request, final AuditRecord entity) {
		// TODO Auto-generated method stub

		assert request != null;
		assert entity != null;
		this.repository.save(entity);
	}

}
