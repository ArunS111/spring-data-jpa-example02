package griffio.phasing;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPhasingStrategyContribution is a Querydsl query type for PhasingStrategyContribution
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPhasingStrategyContribution extends EntityPathBase<PhasingStrategyContribution> {

    private static final long serialVersionUID = 277641211L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPhasingStrategyContribution phasingStrategyContribution = new QPhasingStrategyContribution("phasingStrategyContribution");

    public final griffio.persist.QPersistableSequence _super = new griffio.persist.QPersistableSequence(this);

    public final NumberPath<java.math.BigDecimal> eeCont = createNumber("eeCont", java.math.BigDecimal.class);

    public final DatePath<org.joda.time.LocalDate> effectiveDate = createDate("effectiveDate", org.joda.time.LocalDate.class);

    public final NumberPath<java.math.BigDecimal> erCont = createNumber("erCont", java.math.BigDecimal.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QPhasingStrategy phasingStrategy;

    public final DateTimePath<org.joda.time.LocalDateTime> processedDate = createDateTime("processedDate", org.joda.time.LocalDateTime.class);

    public QPhasingStrategyContribution(String variable) {
        this(PhasingStrategyContribution.class, forVariable(variable), INITS);
    }

    public QPhasingStrategyContribution(Path<? extends PhasingStrategyContribution> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPhasingStrategyContribution(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPhasingStrategyContribution(PathMetadata<?> metadata, PathInits inits) {
        this(PhasingStrategyContribution.class, metadata, inits);
    }

    public QPhasingStrategyContribution(Class<? extends PhasingStrategyContribution> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.phasingStrategy = inits.isInitialized("phasingStrategy") ? new QPhasingStrategy(forProperty("phasingStrategy"), inits.get("phasingStrategy")) : null;
    }

}

