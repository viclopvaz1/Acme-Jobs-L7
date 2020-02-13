
package acme.features.authenticated.offer;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.offers.Offer;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedOfferRepository extends AbstractRepository {

	//@Query("select o from Offer o where o.deadline > CURRENT_TIMESTAMP")
	//Collection<Offer> findMany();

	@Query("select a from Offer a where a.moment > ?1")
	Collection<Offer> findManyByMoment(Date moment);

	@Query("select o from Offer o where o.id = ?1")
	Offer findOneById(int id);
}
