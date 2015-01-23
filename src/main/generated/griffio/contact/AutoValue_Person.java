package griffio.contact;

import java.util.Date;

@javax.annotation.Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_Person extends Person {
  private final String firstname;
  private final String lastname;
  private final Date dateOfBirth;
  private final int shoeSize;

  AutoValue_Person(
      String firstname,
      String lastname,
      Date dateOfBirth,
      int shoeSize) {
    if (firstname == null) {
      throw new NullPointerException("Null firstname");
    }
    this.firstname = firstname;
    if (lastname == null) {
      throw new NullPointerException("Null lastname");
    }
    this.lastname = lastname;
    if (dateOfBirth == null) {
      throw new NullPointerException("Null dateOfBirth");
    }
    this.dateOfBirth = dateOfBirth;
    this.shoeSize = shoeSize;
  }

  @Override
  String firstname() {
    return firstname;
  }

  @Override
  String lastname() {
    return lastname;
  }

  @Override
  Date dateOfBirth() {
    return dateOfBirth;
  }

  @Override
  int shoeSize() {
    return shoeSize;
  }

  @Override
  public String toString() {
    return "Person{"
        + "firstname=" + firstname
        + ", lastname=" + lastname
        + ", dateOfBirth=" + dateOfBirth
        + ", shoeSize=" + shoeSize
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Person) {
      Person that = (Person) o;
      return (this.firstname.equals(that.firstname()))
          && (this.lastname.equals(that.lastname()))
          && (this.dateOfBirth.equals(that.dateOfBirth()))
          && (this.shoeSize == that.shoeSize());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= firstname.hashCode();
    h *= 1000003;
    h ^= lastname.hashCode();
    h *= 1000003;
    h ^= dateOfBirth.hashCode();
    h *= 1000003;
    h ^= shoeSize;
    return h;
  }
}
