
package acme.features.employer.job;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/employer/job/")
public class EmployerJobController extends AbstractController<Employer, Job> {

	@Autowired
	private EmployerJobShowService		showService;

	@Autowired
	private EmployerJobListMineService	listMineService;

	@Autowired
	private EmployerJobCreateService	createService;

	@Autowired
	private EmployerJobDeleteService	deleteService;

	@Autowired
	private EmployerJobUpdateService	updateService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);

		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);

		super.addBasicCommand(BasicCommand.CREATE, this.createService);

		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);

		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
	}

}
