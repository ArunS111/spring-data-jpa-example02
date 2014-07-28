package griffio.phasing.repository;

import griffio.company.Company;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long>, QueryDslPredicateExecutor<Company> {

}
