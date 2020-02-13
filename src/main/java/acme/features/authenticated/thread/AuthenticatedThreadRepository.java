
package acme.features.authenticated.thread;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.threads.Thread;
import acme.framework.entities.Authenticated;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedThreadRepository extends AbstractRepository {

	@Query("select t from Thread t  where t.id = ?1")
	Thread findOneThreadById(int id);

	@Query("select t from Thread t where t.creatorUser.id = ?1")
	Collection<Thread> findManyByAuthenticatedId(int authenticatedId);

	@Query("select p.authenticated from Participation p where p.thread.id = ?1")
	Collection<Authenticated> findManyAuthenticatedByThreadId(int threadId);

	@Query("select a from Authenticated a where a.id = ?1")
	Authenticated findAuthenticatedById(int authenticatedId);

	@Query("select t.creatorUser.id from Thread t where t.id = ?1")
	Integer findCreatorUserByThreadId(int threadId);

	@Query("select p.thread from Participation p where p.authenticated.id = ?1")
	Collection<Thread> findManyThreadByAuthenticatedId(int activeRoleId);

	@Query("select j.title from Thread j")
	Collection<String> allTitles();

	@Query("select p.authenticated.id from Participation p where p.thread.id = ?1")
	Collection<Integer> findManyAuthenticatedIdByThreadId(int threadId);

	@Query("select j.title from Thread j where j.id = ?1")
	String findTitleByThreadId(int id);

}
//@Query("select a from Authenticated a where a.id in(select a.thread.authenticated.id from Thread t where t.users.id = ?1")
//	@Query("select t from Thread t where t.users = ANY (select u from users u  where u.id =?1")

//@Query("select distinct t from Thread t join t.authenticateds a on a.id = ?1")
