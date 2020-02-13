
package acme.features.anonymous.investorrecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investorrecords.InvestorRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousInvestorRecordRepository extends AbstractRepository {

	@Query("select s from InvestorRecord s where s.id = ?1")
	InvestorRecord findOneById(int id);

	@Query("select s from InvestorRecord s")
	Collection<InvestorRecord> findMany();

	@Query("select s from InvestorRecord s where s.star >= 5")
	Collection<InvestorRecord> findManyStars();

}
