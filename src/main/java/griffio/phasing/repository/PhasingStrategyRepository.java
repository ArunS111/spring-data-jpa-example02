package griffio.phasing.repository;

import griffio.phasing.PhasingStrategy;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface PhasingStrategyRepository extends CrudRepository<PhasingStrategy, Long>, QueryDslPredicateExecutor<PhasingStrategy> {

}
