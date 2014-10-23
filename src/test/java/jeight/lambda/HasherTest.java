package jeight.lambda;

import org.apache.commons.codec.digest.DigestUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Michael Gfeller
 */
@Test
public class HasherTest {

  public void testHashing() {
    Hasher<String, String> shash = (s) -> DigestUtils.md2Hex(s);
    Assert.assertEquals(shash.hash("michael"), DigestUtils.md2Hex("michael"));
  }

  public void testStringListHasher() {
    StringListHasher hasher = new StringListHasher((s) -> DigestUtils.md2Hex(s));
    List<String> names = Arrays.asList("kari", "tor", "kaja", "thor", "per");
    List<String> res = hasher.hash(names);
    for (String re : res) {
      System.out.println(re);
    }
  }
}
