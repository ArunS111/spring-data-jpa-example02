package griffio.phasing;

import com.mysema.query.Tuple;
import com.mysema.query.types.MappingProjection;

public class PhasingStrategyMapping extends MappingProjection<PhasingStrategyProjection> {

    public PhasingStrategyMapping() {
        super(PhasingStrategyProjection.class, QPhasingStrategy.phasingStrategy.id);
    }

    @Override
    protected PhasingStrategyProjection map(Tuple row) {
        return new PhasingStrategyProjection(row.get(QPhasingStrategy.phasingStrategy.phasingStrategyContributions));
    }
}
