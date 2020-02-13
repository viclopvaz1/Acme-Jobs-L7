
package acme.features.employer.duty;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.duties.Duty;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerDutyRepository extends AbstractRepository {

	@Query("select d from Duty d where d.id = ?1")
	Duty findOneById(int id);

	@Query("select d from Duty d where d.job.id = ?1")
	Collection<Duty> findManyByJobId(int jobId);

	@Query("select sum(d.percentage) from Duty d where d.job.id = ?1")
	Double sumDutiesJob(int idJob);

}
