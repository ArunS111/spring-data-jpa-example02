package griffio.company;

import com.google.common.testing.EqualsTester;
import org.testng.annotations.Test;

@Test
public class CompanyTest {

    public void company() {

        Company i = new Company("Company I");
        Company ii = new Company();
        ii.setName("Company II");
        new EqualsTester()
                .addEqualityGroup(i)
                .addEqualityGroup(ii)
                .testEquals();

    }

}