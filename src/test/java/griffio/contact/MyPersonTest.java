package griffio.contact;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

@Test
public class MyPersonTest {

    @Test
    public void shoeSize() throws Exception {

        MyPerson myPerson = new MyPerson(null);

        Set<MyPerson> sizes = new HashSet<>();

        Assert.assertTrue(sizes.add(myPerson));

    }
}