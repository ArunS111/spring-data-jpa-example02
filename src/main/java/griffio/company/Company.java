package griffio.company;

import com.google.common.collect.Lists;
import griffio.contact.Address;
import griffio.persist.PersistableSequence;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "company")
@SequenceGenerator(name = "sequence", sequenceName = "company_id_seq", allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name = "company_id"))
public class Company extends PersistableSequence {

  private static final long serialVersionUID = -42L;

  @Column(name = "name")
  @NotNull
  private String name;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "company_id", referencedColumnName = "company_id", nullable = true)
  private List<Address> locations = Lists.newArrayList();

  protected Company() {
  }

  public Company(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Address> getLocations() {
    return locations;
  }

  public void addLocation(Address address) {
    this.locations.add(address);
  }

  @Override
  public boolean equals(Object object) {

    if (object instanceof Company) {
      Company that = (Company) object;
      return java.util.Objects.equals(this.getName(), that.getName());
    }

    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getName());
  }

  @Override
  public String toString() {
    return Objects.toString(name, "{name}");
  }
}
