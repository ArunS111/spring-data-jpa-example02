package griffio.contact;

import griffio.persist.PersistableSequence;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "address")
@SequenceGenerator(name = "sequence", sequenceName = "address_id_seq", allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name = "address_id"))
public class Address extends PersistableSequence {

  private static final long serialVersionUID = -42L;

  @Column(name = "location", nullable = false)
  @NotNull
  private String location;

  @Column(name = "street", nullable = false)
  @NotNull
  private String street;

  @Column(name = "city", nullable = false)
  @NotNull
  private String city;

  @Column(name = "postcode", nullable = false)
  @NotNull
  private String postcode;

  protected Address() {
  }

  public Address(String location, String street, String city, String postcode) {
    this.location = location;
    this.street = street;
    this.city = city;
    this.postcode = postcode;
  }

  public String getLocation() {
    return location;
  }

  public String getStreet() {
    return street;
  }

  public String getCity() {
    return city;
  }

  public String getPostcode() {
    return postcode;
  }

  @Override
  public boolean equals(Object object) {

    if (object instanceof Address) {
      Address that = (Address) object;
      return Objects.equals(this.getPostcode(), that.getPostcode())
          && Objects.equals(this.getLocation(), that.getLocation());
    }

    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(location, street, city, postcode);
  }
}
