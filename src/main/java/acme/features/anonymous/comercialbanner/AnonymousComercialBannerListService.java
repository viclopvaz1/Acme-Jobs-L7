
package acme.features.anonymous.comercialbanner;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.comercialbanners.ComercialBanner;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousComercialBannerListService implements AbstractListService<Anonymous, ComercialBanner> {

	@Autowired
	AnonymousComercialBannerRepository repository;


	@Override
	public boolean authorise(final Request<ComercialBanner> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<ComercialBanner> request, final ComercialBanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "targetUrl", "creditCard");
	}

	@Override
	public Collection<ComercialBanner> findMany(final Request<ComercialBanner> request) {
		assert request != null;

		Collection<ComercialBanner> result = this.repository.findMany();

		return result;
	}

}
