
package acme.features.sponsor.noncomercialbanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.noncomercialbanners.NonComercialBanner;
import acme.entities.roles.Sponsor;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractDeleteService;

@Service
public class SponsorNonComercialBannerDeleteService implements AbstractDeleteService<Sponsor, NonComercialBanner> {

	@Autowired
	SponsorNonComercialBannerRepository repository;


	@Override
	public boolean authorise(final Request<NonComercialBanner> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<NonComercialBanner> request, final NonComercialBanner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "sponsor");

	}

	@Override
	public void unbind(final Request<NonComercialBanner> request, final NonComercialBanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "targetUrl", "jigle");

	}

	@Override
	public NonComercialBanner findOne(final Request<NonComercialBanner> request) {
		assert request != null;

		NonComercialBanner result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<NonComercialBanner> request, final NonComercialBanner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void delete(final Request<NonComercialBanner> request, final NonComercialBanner entity) {
		assert request != null;
		assert entity != null;

		this.repository.delete(entity);

	}

}
