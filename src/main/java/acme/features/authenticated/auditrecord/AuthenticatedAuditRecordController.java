
package acme.features.authenticated.auditrecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.auditrecords.AuditRecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/audit-record/")
public class AuthenticatedAuditRecordController extends AbstractController<Authenticated, AuditRecord> {

	@Autowired
	AuthenticatedAuditRecordListMineService	listMineService;

	@Autowired
	AuthenticatedAuditRecordShowService		showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);

		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);

	}

}
