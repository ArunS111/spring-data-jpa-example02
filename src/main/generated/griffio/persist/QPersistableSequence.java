package griffio.persist;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPersistableSequence is a Querydsl query type for PersistableSequence
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QPersistableSequence extends EntityPathBase<PersistableSequence> {

    private static final long serialVersionUID = -1708619605L;

    public static final QPersistableSequence persistableSequence = new QPersistableSequence("persistableSequence");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QPersistableSequence(String variable) {
        super(PersistableSequence.class, forVariable(variable));
    }

    public QPersistableSequence(Path<? extends PersistableSequence> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPersistableSequence(PathMetadata<?> metadata) {
        super(PersistableSequence.class, metadata);
    }

}

