
package acme.features.administrator.challenge;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorChallengeCreateService implements AbstractCreateService<Administrator, Challenge> {

	@Autowired
	AdministratorChallengeRepository repository;


	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "deadline", "description", "title");
	}

	@Override
	public Challenge instantiate(final Request<Challenge> request) {
		Challenge result;

		result = new Challenge();

		return result;
	}

	@Override
	public void validate(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Calendar calendar;
		Date minimunDeadline;

		if (!errors.hasErrors("deadline")) {
			calendar = new GregorianCalendar();
			calendar.add(Calendar.DAY_OF_MONTH, 7);
			minimunDeadline = calendar.getTime();
			errors.state(request, entity.getDeadline().after(minimunDeadline), "deadline", "administrator.challenge.form.error.tooClose");
		}

		if (!errors.hasErrors("goldReward")) {
			errors.state(request, entity.getGoldReward().getCurrency().equals("EUR") || entity.getGoldReward().getCurrency().equals("€"), "goldReward", "administrator.challenge.form.error.zoneEurG");
		}

		if (!errors.hasErrors("silverReward")) {
			errors.state(request, entity.getSilverReward().getCurrency().equals("EUR") || entity.getSilverReward().getCurrency().equals("€"), "silverReward", "administrator.challenge.form.error.zoneEurS");
			errors.state(request, entity.getGoldReward().getAmount() > entity.getSilverReward().getAmount(), "silverReward", "administrator.challenge.form.error.goldBsilver");
		}

		if (!errors.hasErrors("bronzeReward")) {
			errors.state(request, entity.getBronzeReward().getCurrency().equals("EUR") || entity.getBronzeReward().getCurrency().equals("€"), "bronzeReward", "administrator.challenge.form.error.zoneEurB");
			errors.state(request, entity.getBronzeReward().getAmount() < entity.getSilverReward().getAmount(), "bronzeReward", "administrator.challenge.form.error.silverBbronze");
		}

	}

	@Override
	public void create(final Request<Challenge> request, final Challenge entity) {

		this.repository.save(entity);

	}

}
