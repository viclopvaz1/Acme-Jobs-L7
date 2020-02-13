
package acme.features.authenticated.participation;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.participations.Participation;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/participation/")
public class AuthenticatedParticipationController extends AbstractController<Authenticated, Participation> {

	@Autowired
	private AuthenticatedParticipationListService	listService;

	@Autowired
	private AuthenticatedParticipationCreateService	createService;

	@Autowired
	private AuthenticatedParticipationShowService	showService;

	@Autowired
	private AuthenticatedParticipationDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);

	}
}
