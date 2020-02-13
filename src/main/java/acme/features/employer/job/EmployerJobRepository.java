
package acme.features.employer.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id = ?1")
	Job findOneById(int id);

	@Query("select j from Job j where j.employer.id = ?1")
	Collection<Job> findManyByEmployerId(int employerId);

	@Query("select e from Employer e where e.id = ?1")
	Employer findEmployerById(int employerId);

	@Query("select j.reference from Job j")
	Collection<String> allReferences();

	@Query("select j.reference from Job j where j.id = ?1")
	String findReferenceByJobId(int id);

	@Query("select c.spamWords from Configuration c")
	String spamWords();

	@Query("select count(a) from Application a where a.job.employer.id = ?1")
	int findTotalApplicationByEmployerId(int employerId);

	@Query("select count(ad) from AuditRecord ad where ad.job.id = ?1")
	int findAllAuditRecordByJobId(int jobId);

	//	@Query("select j.status from Job j where j.id = ?1")
	//	boolean findStatus(int id);
}
