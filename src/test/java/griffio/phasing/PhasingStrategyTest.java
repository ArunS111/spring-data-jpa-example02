package griffio.phasing;

import com.google.common.testing.EqualsTester;
import org.testng.annotations.Test;

@Test
public class PhasingStrategyTest {

  public void phasingStrategy() throws Exception {

    PhasingStrategy i = new PhasingStrategy("Phase I") {
      @Override
      public Long getId() {
        return 1L;
      }
    };

    PhasingStrategy ii = new PhasingStrategy() {
      @Override
      public Long getId() {
        return 2L;
      }

      @Override
      public String getName() {
        return "Phase II";
      }
    };

    new EqualsTester()
        .addEqualityGroup(i)
        .addEqualityGroup(ii)
        .testEquals();
  }
}