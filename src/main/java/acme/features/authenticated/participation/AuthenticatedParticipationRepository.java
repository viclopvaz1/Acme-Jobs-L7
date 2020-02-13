
package acme.features.authenticated.participation;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.participations.Participation;
import acme.entities.threads.Thread;
import acme.framework.entities.Authenticated;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedParticipationRepository extends AbstractRepository {

	@Query("select t from Thread t  where t.id = ?1")
	Thread findOneThreadById(int id);

	@Query("select t from Thread t where t.creatorUser.id = ?1")
	Collection<Thread> findManyByAuthenticatedId(int authenticatedId);

	@Query("select p.authenticated from Participation p where p.thread.id = ?1")
	Collection<Authenticated> findManyAuthenticatedByThreadId(int threadId);

	@Query("select a from Authenticated a")
	Collection<Authenticated> findAllAuthenticated();

	@Query("select a from Authenticated a where a.id = ?1")
	Authenticated findAuthenticatedById(int authenticatedId);

	@Query("select t.creatorUser.id from Thread t where t.id = ?1")
	Integer findCreatorUserByThreadId(int threadId);

	@Query("select p from Participation p where p.thread.id= ?1 ")
	Collection<Participation> findAllParticipationByThreadId(int threadId);

	@Query("select p from Participation p where p.id = ?1")
	Participation findParticipationById(int participationId);

	@Query("select p.thread.creatorUser from Participation p where p.id = ?1")
	Authenticated findCreatorUserByParticipationId(int participationId);

	@Query("select u from UserAccount u where u.username = ?1")
	UserAccount findUserByName(String userName);

	@Query("select a from Authenticated a where a.userAccount.id = ?1")
	Authenticated findAuthenticatedByAccountId(int id);

	@Query("select u from UserAccount u")
	Collection<UserAccount> findAllUserAccount();

	@Query("select u.username from UserAccount u")
	Collection<String> findAllUserNames();

	@Query("select u.username from UserAccount u where u.id in (select a.userAccount.id from Authenticated a where a.id in (select m.authenticated.id from Participation m where m.thread.id = ?1))")
	Collection<String> findAllUserInParticipation(Integer integer);
}
//@Query("select a from Authenticated a where a.id in(select a.thread.authenticated.id from Thread t where t.users.id = ?1")
//	@Query("select t from Thread t where t.users = ANY (select u from users u  where u.id =?1")

//@Query("select distinct t from Thread t join t.authenticateds a on a.id = ?1")
