
package acme.features.authenticated.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

public interface AuthenticatedJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.status = 1")
	Collection<Job> findMany();

	@Query("select j from Job j where j.id = ?1")
	Job findOneById(int id);

}
