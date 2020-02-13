
package acme.features.administrator.estadistica;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.datatypes.Money;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorEstadisticaRepository extends AbstractRepository {

	//2629750000

	@Query("select count(*) from Announcement")
	Double findAnnoun();

	@Query("select count(*) from CompanyRecord")
	Double findCompanyRecord();

	@Query("select count(*) from InvestorRecord")
	Double findInvestorRecord();

	@Query("select o.rewardMin from Offer o where datediff(current_date(), o.deadline)<0 ")
	List<Money> minOffer();

	@Query("select o.rewardMax from Offer o where datediff(current_date(), o.deadline)<0")
	List<Money> maxOffer();

	@Query("select s.reward from Request s where datediff(current_date(), s.deadline)<0")
	List<Money> findRequest();

	@Query("select avg(select count(j) from Job j where j.employer.id = e.id) from Employer e")
	Double averageNumberOfJobsPerEmployer();

	@Query("select avg(select count(a) from Application a where a.worker.id = w.id) from Worker w")
	Double averageNumberOfApplicationsPerWorker();

	@Query("select avg(select count(a) from Application a where exists(select j from Job j where j.employer.id = e.id)) from Employer e")
	Double averageNumberOfApplicationsPerEmployer();

}
