package griffio.persist;

import org.springframework.data.domain.Persistable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

/**
 * <code>PersistableSequence</code>
 * The actual sequence is overridden in subclasses
 */
@MappedSuperclass
public abstract class PersistableSequence implements Persistable<Long> {

  private static final long serialVersionUID = -42L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
  private Long id;

  @Override
  public Long getId() {
    return id;
  }

  protected void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean isNew() {
    return getId() == null;
  }

  @Override
  public boolean equals(Object object) {

    if (object instanceof PersistableSequence) {
      PersistableSequence that = (PersistableSequence) object;
      return java.util.Objects.equals(this.getId(), that.getId());
    }

    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
    return Objects.toString(getId(), "{id}");
  }
}

