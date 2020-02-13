
package acme.features.sponsor.noncomercialbanner;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.noncomercialbanners.NonComercialBanner;
import acme.entities.roles.Sponsor;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class SponsorNonComercialBannerCreateService implements AbstractCreateService<Sponsor, NonComercialBanner> {

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

		request.unbind(entity, model, "picture", "slogan", "targetUrl", "jingle");

	}

	@Override
	public NonComercialBanner instantiate(final Request<NonComercialBanner> request) {
		assert request != null;

		NonComercialBanner result;
		Principal principal;
		Sponsor sponsor;
		int sponsorId;

		principal = request.getPrincipal();
		sponsorId = principal.getActiveRoleId();
		sponsor = this.repository.findSponsorById(sponsorId);

		result = new NonComercialBanner();
		result.setSponsor(sponsor);

		return result;
	}

	@Override
	public void validate(final Request<NonComercialBanner> request, final NonComercialBanner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		String palabrasSpam;
		String[] split;
		Collection<String> spam = new HashSet<>();

		palabrasSpam = this.repository.spamWords();
		split = palabrasSpam.split(", ");
		for (String s : split) {
			spam.add(s);
		}

		if (!errors.hasErrors("slogan")) {
			boolean isSpam = true;
			for (String s : spam) {
				isSpam = entity.getSlogan().contains(s);
			}

			errors.state(request, isSpam == false, "slogan", "sponsor.non-comercial-banner.form.error.spamWordsSlogan");
		}

	}

	@Override
	public void create(final Request<NonComercialBanner> request, final NonComercialBanner entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
