package griffio.phasing;

import com.mysema.query.annotations.QueryProjection;

import java.io.Serializable;
import java.util.Collection;

public class PhasingStrategyProjection implements Serializable {

  private static final long serialVersionUID = -42L;

  private final Collection<PhasingStrategyContribution> contributions;

  @QueryProjection
  public PhasingStrategyProjection(Collection<PhasingStrategyContribution> contributions) {
    this.contributions = contributions;
  }

  public Collection<PhasingStrategyContribution> getContributions() {
    return contributions;
  }
}
