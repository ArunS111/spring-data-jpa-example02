package griffio.phasing.repository;

import com.google.common.base.Supplier;
import griffio.company.Company;
import griffio.config.ApplicationConfiguration;
import griffio.phasing.PhasingStrategy;
import griffio.phasing.PhasingStrategyContribution;
import org.hibernate.Session;
import org.hibernate.stat.Statistics;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.Set;

import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = ApplicationConfiguration.class)
@TransactionConfiguration(defaultRollback = false)
public class PhasingStrategyRepositoryTest extends AbstractTransactionalTestNGSpringContextTests {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    PhasingStrategyRepository phasingStrategyRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    Supplier<LocalDateTime> now;

    final PhasingStrategyContribution.Builder contributions = new PhasingStrategyContribution.Builder();

    @BeforeMethod
    public void before() {
        Session delegate = (Session) entityManager.getDelegate();
        Statistics statistics = delegate.getSessionFactory().getStatistics();
        statistics.setStatisticsEnabled(true);
    }

    @Test
    public void addPhasingToCompany() {
        Company companyOne = companyRepository.save(new Company("One"));
        PhasingStrategy phasingStrategy = new PhasingStrategy("Test 1");
        phasingStrategy.setCompany(companyOne);
        PhasingStrategy saved = phasingStrategyRepository.save(phasingStrategy);
        assertTrue(saved.getId() > 0);
    }

    @AfterTest
    public void afterOne() {
        Session delegate = (Session) entityManager.getDelegate();
        Statistics statistics = delegate.getSessionFactory().getStatistics();
        statistics.logSummary();
    }


    @Test
    public void addContributions() {
        Company companyOne = new Company("One");
        save(companyOne);
        PhasingStrategy phasingStrategy = new PhasingStrategy("Test 2");
        phasingStrategy.setCompany(companyOne);
        contributions.effectiveDate(now.get().toLocalDate()).eeCont(BigDecimal.TEN).erCont(BigDecimal.ONE).processedDate(now.get());
        phasingStrategy.addContribution(contributions.build());
        save(phasingStrategy);
    }

    @Test
    public void addRemoveContributions() {
        Company companyOne = new Company("One");
        save(companyOne);
        PhasingStrategy phasingStrategy = new PhasingStrategy("Test 2");
        phasingStrategy.setCompany(companyOne);
        contributions.effectiveDate(now.get().toLocalDate()).eeCont(BigDecimal.TEN).erCont(BigDecimal.ONE).processedDate(now.get());
        phasingStrategy.addContribution(contributions.build());
        save(phasingStrategy);
        remove(phasingStrategy);
    }

    @Transactional
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Transactional
    public PhasingStrategy save(PhasingStrategy phasingStrategy) {
        return phasingStrategyRepository.save(phasingStrategy);
    }

    @Transactional
    public void remove(PhasingStrategy phasingStrategy) {
        phasingStrategy = phasingStrategyRepository.findOne(phasingStrategy.getId());
        Set<PhasingStrategyContribution> phasingStrategyContributions = phasingStrategy.getPhasingStrategyContributions();
        for (PhasingStrategyContribution phasingStrategyContribution : phasingStrategyContributions) {
           assertTrue(phasingStrategy.remove(phasingStrategyContribution));
        }
    }

}