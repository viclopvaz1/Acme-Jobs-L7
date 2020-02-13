
package acme.features.anonymous.comercialbanner;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.comercialbanners.ComercialBanner;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousComercialBannerRepository extends AbstractRepository {

	@Query("select cb from ComercialBanner cb")
	Collection<ComercialBanner> findMany();

	@Query("select cb from ComercialBanner cb where cb.id = ?1")
	ComercialBanner findOneById(int id);

}
