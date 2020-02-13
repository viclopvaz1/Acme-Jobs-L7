
package acme.features.administrator.investorrecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investorrecords.InvestorRecord;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorInvestorCreateService implements AbstractCreateService<Administrator, InvestorRecord> {

	@Autowired
	AdministratorInvestorRepository repository;


	@Override
	public boolean authorise(final Request<InvestorRecord> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<InvestorRecord> request, final InvestorRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<InvestorRecord> request, final InvestorRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "investor", "sector", "statement", "star");

	}

	@Override
	public InvestorRecord instantiate(final Request<InvestorRecord> request) {
		InvestorRecord result;
		result = new InvestorRecord();
		return result;
	}

	@Override
	public void validate(final Request<InvestorRecord> request, final InvestorRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<InvestorRecord> request, final InvestorRecord entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
