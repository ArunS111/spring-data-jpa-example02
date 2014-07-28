package griffio.phasing;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.testing.EqualsTester;
import org.joda.time.LocalDateTime;
import org.testng.annotations.Test;

import java.math.BigDecimal;

@Test
public class PhasingStrategyContributionTest {

    private Supplier<LocalDateTime> now = Suppliers.ofInstance(new LocalDateTime());

    PhasingStrategyContribution.Builder builder = new PhasingStrategyContribution.Builder();

    public void phasingStrategyContribution() {

        PhasingStrategyContribution i = new PhasingStrategyContribution(now.get().toLocalDate(), BigDecimal.TEN, BigDecimal.ONE, now.get().plusMinutes(10));
        PhasingStrategyContribution ii = builder.eeCont(i.getEeCont()).erCont(i.getErCont()).effectiveDate(i.getEffectiveDate()).processedDate(i.getProcessedDate()).build();
        PhasingStrategyContribution iii = builder.eeCont(i.getEeCont()).erCont(i.getErCont()).effectiveDate(i.getEffectiveDate().minusDays(1)).processedDate(i.getProcessedDate().minusDays(1)).build();

        new EqualsTester()
                .addEqualityGroup(i, ii)
                .addEqualityGroup(iii)
                .testEquals();
    }

}