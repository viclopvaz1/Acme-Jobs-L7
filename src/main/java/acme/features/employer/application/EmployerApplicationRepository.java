
package acme.features.employer.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerApplicationRepository extends AbstractRepository {

	@Query("select a from Application a where a.id = ?1")
	Application findOneById(int id);

	@Query("select a from Application a where a.job.employer.id = ?1")
	Collection<Application> findManyByEmployerId(int eId);

	//	@Query("select j from Job j where j.employer.id =?1 and exists(select a from Application a where a.job.id = j.id) and j.status=1")
	//	Collection<Job> findManyByEmployerId(int employerId);

}
