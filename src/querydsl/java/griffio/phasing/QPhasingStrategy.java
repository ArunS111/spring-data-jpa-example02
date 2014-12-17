package griffio.phasing;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPhasingStrategy is a Querydsl query type for PhasingStrategy
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPhasingStrategy extends EntityPathBase<PhasingStrategy> {

    private static final long serialVersionUID = 1434359883L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPhasingStrategy phasingStrategy = new QPhasingStrategy("phasingStrategy");

    public final griffio.persist.QPersistableSequence _super = new griffio.persist.QPersistableSequence(this);

    public final griffio.company.QCompany company;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final SetPath<PhasingStrategyContribution, QPhasingStrategyContribution> phasingStrategyContributions = this.<PhasingStrategyContribution, QPhasingStrategyContribution>createSet("phasingStrategyContributions", PhasingStrategyContribution.class, QPhasingStrategyContribution.class, PathInits.DIRECT2);

    public QPhasingStrategy(String variable) {
        this(PhasingStrategy.class, forVariable(variable), INITS);
    }

    public QPhasingStrategy(Path<? extends PhasingStrategy> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPhasingStrategy(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPhasingStrategy(PathMetadata<?> metadata, PathInits inits) {
        this(PhasingStrategy.class, metadata, inits);
    }

    public QPhasingStrategy(Class<? extends PhasingStrategy> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new griffio.company.QCompany(forProperty("company")) : null;
    }

}

