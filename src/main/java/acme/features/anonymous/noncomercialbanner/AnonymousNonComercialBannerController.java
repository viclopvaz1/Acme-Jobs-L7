
package acme.features.anonymous.noncomercialbanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.noncomercialbanners.NonComercialBanner;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/non-comercial-banner/")
public class AnonymousNonComercialBannerController extends AbstractController<Anonymous, NonComercialBanner> {

	@Autowired
	AnonymousNonComercialBannerListService	listService;

	@Autowired
	AnonymousNonComercialBannerShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
}
