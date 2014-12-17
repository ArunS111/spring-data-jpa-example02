package griffio.phasing;

import com.mysema.query.types.expr.*;

import com.mysema.query.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * griffio.phasing.QPhasingStrategyProjection is a Querydsl Projection type for PhasingStrategyProjection
 */
@Generated("com.mysema.query.codegen.ProjectionSerializer")
public class QPhasingStrategyProjection extends ConstructorExpression<PhasingStrategyProjection> {

    private static final long serialVersionUID = 2055707898L;

    public QPhasingStrategyProjection(com.mysema.query.types.Expression<? extends java.util.Collection<PhasingStrategyContribution>> contributions) {
        super(PhasingStrategyProjection.class, new Class[]{java.util.Collection.class}, contributions);
    }

}

