
package acme.features.authenticated.auditorrequest;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditorrequests.AuditorRequest;
import acme.entities.roles.Auditor;
import acme.framework.entities.Authenticated;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedAuditorRequestRepository extends AbstractRepository {

	@Query("select a from Auditor a where a.userAccount.id=?1")
	Auditor findOneAuditorByUserAccountId(Integer userId);

	@Query("select au from Authenticated au where au.userAccount.id =?1")
	Authenticated findOneAuthenticatedByUserAccountId(int userAccountId);

	@Query("select a from AuditorRequest a where a.authenticated.userAccount.id =?1")
	AuditorRequest findOneAuditorRequestByUserAccountId(Integer userAccountId);

	@Query("select ua from UserAccount ua where ua.id = ?1")
	UserAccount findOneUserAccountById(int id);

	@Query("select count(a) from AuditorRequest a where a.authenticated.userAccount.id = ?1")
	int findTotalAuditoRequestByUserAccountId(int userAccountId);
}
