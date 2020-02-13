
package acme.features.sponsor.comercialbanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.comercialbanners.ComercialBanner;
import acme.entities.roles.Sponsor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/sponsor/comercial-banner/")
public class SponsorComercialBannerController extends AbstractController<Sponsor, ComercialBanner> {

	@Autowired
	private SponsorComercialBannerShowService		showService;

	@Autowired
	private SponsorComercialBannerListMineService	listMineService;

	@Autowired
	private SponsorComercialBannerCreateService		createService;

	@Autowired
	private SponsorComercialBannerUpdateService		updateService;

	@Autowired
	private SponsorComercialBannerDeleteService		deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);

		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);

		super.addBasicCommand(BasicCommand.CREATE, this.createService);

		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);

		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
	}

}
