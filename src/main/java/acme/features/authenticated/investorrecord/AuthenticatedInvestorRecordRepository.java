
package acme.features.authenticated.investorrecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investorrecords.InvestorRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedInvestorRecordRepository extends AbstractRepository {

	@Query("select s from InvestorRecord s where s.id = ?1")
	InvestorRecord findOneById(int id);

	@Query("select s from InvestorRecord s")
	Collection<InvestorRecord> findMany();

}
