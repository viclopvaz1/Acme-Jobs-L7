
package acme.features.authenticated.auditorrequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditorrequests.AuditorRequest;
import acme.entities.roles.Auditor;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedAuditorRequestCreateService implements AbstractCreateService<Authenticated, AuditorRequest> {

	@Autowired
	AuthenticatedAuditorRequestRepository repository;


	@Override
	public boolean authorise(final Request<AuditorRequest> request) {
		assert request != null;
		Principal principal = request.getPrincipal();
		Integer userId = principal.getAccountId();
		Auditor au = this.repository.findOneAuditorByUserAccountId(userId);

		return au == null;
	}

	@Override
	public void bind(final Request<AuditorRequest> request, final AuditorRequest entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<AuditorRequest> request, final AuditorRequest entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "firm", "responsabilityStatement", "numAuditorRequest");
	}

	@Override
	public AuditorRequest instantiate(final Request<AuditorRequest> request) {
		assert request != null;

		AuditorRequest result;
		Authenticated authenticated;
		int userAccountId;
		Principal principal;

		result = new AuditorRequest();

		principal = request.getPrincipal();
		userAccountId = principal.getAccountId();
		authenticated = this.repository.findOneAuthenticatedByUserAccountId(userAccountId);
		result.setAuthenticated(authenticated);
		result.setNumAuditorRequest(this.repository.findTotalAuditoRequestByUserAccountId(userAccountId));
		return result;
	}

	@Override
	public void validate(final Request<AuditorRequest> request, final AuditorRequest entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		//		if (!errors.hasErrors("responsabilityStatement")) {
		//			Principal principal = request.getPrincipal();
		//			Integer userAccountId = principal.getAccountId();
		//			AuditorRequest audR = this.repository.findOneAuditorRequestByUserAccountId(userAccountId);
		//			boolean exist = audR != null;
		//			errors.state(request, !exist, "responsabilityStatement", "auditor.error.exist");
		//		}

	}

	@Override
	public void create(final Request<AuditorRequest> request, final AuditorRequest entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

	//	@Override
	//	public void onSuccess(final Request<AuditorRequest> request, final Response<AuditorRequest> response) {
	//		assert request != null;
	//		assert response != null;
	//
	//		if (request.isMethod(HttpMethod.GET)) {
	//			PrincipalHelper.handleUpdate();
	//		}
	//	}
}
