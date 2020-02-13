
package acme.features.administrator.dashboard;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select sector, count(a) from CompanyRecord a group by a.sector")
	Collection<Object[]> findBySector();

	@Query("select sector, count(a) from InvestorRecord a group by a.sector")
	Collection<Object[]> findBySector2();

	@Query("select status, count(a) from Job a group by a.status")
	Collection<Object[]> findByStatus();

	@Query("select status, count(a) from Application a group by a.status")
	Collection<Object[]> findByStatus2();

	@Query("select count(a) from Job a")
	Double findTotalJobs();

	@Query("select count(a) from Application a")
	Double findTotalApplication();

	@Query("select DATE(a.moment), count(a) from Application a where a.status = 'accepted' and a.moment >= ?1 group by DATE(a.moment)")
	Collection<Object[]> findByAccepted(Date moment);

	@Query("select DATE(a.moment), count(a) from Application a where a.status = 'pending' and a.moment >= ?1 group by DATE(a.moment)")
	Collection<Object[]> findByPending(Date moment);

	@Query("select DATE(a.moment), count(a) from Application a where a.status = 'rejected' and a.moment >= ?1 group by DATE(a.moment)")
	Collection<Object[]> findByRejected(Date moment);

}
