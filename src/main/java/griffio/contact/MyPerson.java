package griffio.contact;

/**
 *
 */
public class MyPerson {

    private Integer shoeSize;

    public MyPerson(Integer shoeSize) {
        this.shoeSize = shoeSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyPerson myPerson = (MyPerson) o;

        if (!shoeSize.equals(myPerson.shoeSize)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return 31 * (shoeSize == null ? 0 : shoeSize) ;
    }
}
