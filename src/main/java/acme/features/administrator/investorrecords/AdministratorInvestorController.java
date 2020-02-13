
package acme.features.administrator.investorrecords;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.investorrecords.InvestorRecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/investor-record")
public class AdministratorInvestorController extends AbstractController<Administrator, InvestorRecord> {

	@Autowired
	private AdministratorInvestorCreateService	createService;

	@Autowired
	private AdministratorInvestorDeleteService	deleteService;

	@Autowired
	private AdministratorInvestorUpdateService	updateService;

	@Autowired
	private AdministratorInvestorShowService	showService;

	@Autowired
	private AdministratorInvestorListService	listService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);

	}

}
