
package acme.features.authenticated.message;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.messages.Message;
import acme.entities.threads.Thread;
import acme.framework.entities.Authenticated;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageRepository extends AbstractRepository {

	@Query("select m from Message m where m.id=?1")
	Message findOneById(int id);

	@Query("select t from Thread t where t.id=?1")
	Thread findThreadById(int id);

	@Query("select m from Message m where m.thread.id=?1")
	Collection<Message> findMessageByThreadId(int id);

	@Query("select m.thread from Message m where m.id=?1")
	Thread findThreadByMessageId(int id);

	@Query("select p.authenticated from Participation p where p.thread.id = ?1")
	Collection<Authenticated> findManyByThreadId(int threadId);

	@Query("select t.creatorUser.id from Thread t where t.id = ?1")
	Integer findCreatorUserByThreadId(int threadId);

	@Query("select u.username from UserAccount u where u.id in (select a.userAccount.id from Authenticated a where a.id in (select m.authenticated.id from Participation m where m.thread.id = ?1))")
	Collection<String> findAllUserInParticipation(Integer integer);

	@Query("select p.authenticated.id from Participation p where p.thread.id = ?1")
	Collection<Integer> findManyAuthenticatedIdByThreadId(int threadId);

	@Query("select p.authenticated from Participation p where p.thread.id = ?1")
	Collection<Authenticated> findManyAuthenticatedByThreadId(int threadId);

	@Query("select a from Authenticated a where a.id = ?1")
	Authenticated findAuthenticatedById(int authenticatedId);

	@Query("select t from Thread t  where t.id = ?1")
	Thread findOneThreadById(int id);

	@Query("select c.spamWords from Configuration c")
	String spamWords();
}
