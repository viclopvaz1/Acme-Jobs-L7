
package acme.forms;

import java.io.Serializable;
import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	private static final long	serialVersionUID	= 1L;

	Collection<Object[]>		numberOfCompaniesGroupedBySector;

	Collection<Object[]>		numberOfInvestorsGroupedBySector;

	Collection<Object[]>		ratioOfJobsGroupedByStatus;

	Collection<Object[]>		ratioOfApplicationsGroupedByStatus;

	Double						TotalJobs;

	Double						TotalApplications;

	Collection<Object[]>		Accepted;

	Collection<Object[]>		Pending;

	Collection<Object[]>		Rejected;

	String[]					Dias;

}
