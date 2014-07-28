package griffio.company.repository;

import griffio.company.Company;
import griffio.config.ApplicationConfiguration;
import griffio.contact.Address;
import griffio.phasing.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

@ContextConfiguration(classes = ApplicationConfiguration.class)
@Test
@TransactionConfiguration(defaultRollback = false)
public class CompanyRepositoryTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    CompanyRepository companyRepository;

    @Transactional
    public void saveCompany() {
        Company saved = companyRepository.save(new Company("Test 1"));
        Assert.assertTrue(saved.getId() > 0);
    }

    @Transactional
    public void saveCompanyWithLocation() {
        Company company = new Company("Test 1");
        company.addLocation(new Address("HQ", "Main Street", "A City", "MC1 123456"));
        Company saved = companyRepository.save(company);
        Assert.assertTrue(saved.getId() > 0);
        Assert.assertTrue(saved.getLocations().get(0).getId() > 0);
    }

}