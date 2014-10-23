package jeight.lambda;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Michael Gfeller
 */
@Test
public class ReversableTest {

  public void testReverse() {
    Reversable<String> able = (s) -> StringUtils.reverse(s);
    Assert.assertEquals(able.reverse("ab"), "ba");
  }
}
