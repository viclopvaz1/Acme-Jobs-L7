
package acme.features.sponsor.noncomercialbanner;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.noncomercialbanners.NonComercialBanner;
import acme.entities.roles.Sponsor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface SponsorNonComercialBannerRepository extends AbstractRepository {

	@Query("select ncb from NonComercialBanner ncb where ncb.id = ?1")
	NonComercialBanner findOneById(int id);

	@Query("select ncb from NonComercialBanner ncb where ncb.sponsor.id = ?1")
	Collection<NonComercialBanner> findManyBySponsorId(int sponsorId);

	@Query("select s from Sponsor s where s.id = ?1")
	Sponsor findSponsorById(int sponsorId);

	@Query("select c.spamWords from Configuration c")
	String spamWords();

}
