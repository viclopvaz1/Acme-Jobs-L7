
package acme.features.administrator.investorrecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investorrecords.InvestorRecord;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorInvestorUpdateService implements AbstractUpdateService<Administrator, InvestorRecord> {

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
	public InvestorRecord findOne(final Request<InvestorRecord> request) {
		assert request != null;

		InvestorRecord result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneInvestorById(id);

		return result;

	}

	@Override
	public void validate(final Request<InvestorRecord> request, final InvestorRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void update(final Request<InvestorRecord> request, final InvestorRecord entity) {
		/*
		 * String investor = null;
		 * String sector = null;
		 * String statement = null;
		 * Integer star = null;
		 *
		 * entity.setInvestor(investor);
		 * entity.setSector(sector);
		 * entity.setStatement(statement);
		 * entity.setStar(star);
		 */
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
