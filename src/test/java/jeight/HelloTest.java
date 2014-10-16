package jeight;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Michael Gfeller
 */
@Test
public class HelloTest {

    public void testHelloText() {
        Hello hello = new Hello();
        Assert.assertEquals(hello.say(), "Hello");
    }
}
