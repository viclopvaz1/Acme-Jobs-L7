
package acme.features.authenticated.thread;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.threads.Thread;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/thread/")
public class AuthenticatedThreadController extends AbstractController<Authenticated, Thread> {

	@Autowired
	private AuthenticatedThreadCreateService	createService;

	@Autowired
	private AuthenticatedThreadListMineService	listMineService;

	@Autowired
	private AuthenticatedThreadShowService		showService;

	@Autowired
	private AuthenticatedThreadListService		listService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}
}
