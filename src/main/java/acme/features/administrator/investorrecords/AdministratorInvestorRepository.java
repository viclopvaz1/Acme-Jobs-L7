
package acme.features.administrator.investorrecords;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investorrecords.InvestorRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorInvestorRepository extends AbstractRepository {

	@Query("select s from InvestorRecord s")
	Collection<InvestorRecord> findMany();

	@Query("select a from InvestorRecord a where a.id = ?1")
	InvestorRecord findOneInvestorById(int id);

}
