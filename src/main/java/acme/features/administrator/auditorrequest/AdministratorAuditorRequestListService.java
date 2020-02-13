
package acme.features.administrator.auditorrequest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditorrequests.AuditorRequest;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorAuditorRequestListService implements AbstractListService<Administrator, AuditorRequest> {

	@Autowired
	AdministratorAuditorRequestRepository repository;


	@Override
	public boolean authorise(final Request<AuditorRequest> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<AuditorRequest> request, final AuditorRequest entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "firm", "responsabilityStatement", "numAuditorRequest");
	}

	@Override
	public Collection<AuditorRequest> findMany(final Request<AuditorRequest> request) {
		assert request != null;

		Collection<AuditorRequest> result;

		result = this.repository.findMany();

		return result;
	}
}
