package griffio.contact;

import com.google.auto.value.AutoValue;

import java.util.Date;

@AutoValue
public abstract class Person {

    abstract String firstname();
    abstract String lastname();
    abstract Date dateOfBirth();
    abstract int shoeSize();

    public static Person create(String firstname, String lastname, Date dateOfBirth, int shoeSize) {
        return new AutoValue_Person(firstname, lastname, dateOfBirth, shoeSize);
    }

}
