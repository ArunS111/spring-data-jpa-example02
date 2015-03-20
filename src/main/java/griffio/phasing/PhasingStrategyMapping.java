package griffio.phasing;

import com.mysema.query.Tuple;
import com.mysema.query.types.MappingProjection;

public class PhasingStrategyMapping extends MappingProjection<PhasingStrategyProjection> {

  private static final long serialVersionUID = -42L;

  public PhasingStrategyMapping() {
    super(PhasingStrategyProjection.class, QPhasingStrategy.phasingStrategy.id);
  }

  @Override
  protected PhasingStrategyProjection map(Tuple row) {
    return new PhasingStrategyProjection(row.get(QPhasingStrategy.phasingStrategy.phasingStrategyContributions));
  }
}
