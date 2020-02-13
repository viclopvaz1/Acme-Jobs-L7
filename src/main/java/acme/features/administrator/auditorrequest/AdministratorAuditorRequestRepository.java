
package acme.features.administrator.auditorrequest;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditorrequests.AuditorRequest;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorAuditorRequestRepository extends AbstractRepository {

	@Query("select a from AuditorRequest a where a.id=?1")
	AuditorRequest findOneById(int idRequest);

	@Query("select a from AuditorRequest a")
	Collection<AuditorRequest> findMany();

}
