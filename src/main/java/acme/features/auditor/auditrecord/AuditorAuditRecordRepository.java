
package acme.features.auditor.auditrecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditrecords.AuditRecord;
import acme.entities.roles.Auditor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorAuditRecordRepository extends AbstractRepository {

	@Query("select a from AuditRecord a where a.id = ?1")
	AuditRecord findOneById(int id);

	@Query("select a from AuditRecord a where a.job.id = ?1")
	Collection<AuditRecord> findManyByJobId(int jobId);

	@Query("select a from Auditor a where a.id = ?1")
	Auditor findAuditorById(int auditorId);

	@Query("select a from AuditRecord a where a.auditor.id = ?1")
	Collection<AuditRecord> findManyByAuditor(int auditorId);

	@Query("select a from AuditRecord a where a.job.id = ?1 and (a.auditor.id = ?2 or a.status = true)")
	Collection<AuditRecord> findManyByJobIdFilter(int jobId, int auditorId);

}
