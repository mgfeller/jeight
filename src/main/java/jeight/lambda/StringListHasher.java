package jeight.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Michael Gfeller
 */
public class StringListHasher {

  private final Hasher<String, String> hasher;

  public StringListHasher(Hasher<String, String> hasher) {
    this.hasher = hasher;
  }

  public List<String> hash(List<String> toHash) {
    final List<String> res = new ArrayList<>();
    for (String s : toHash) {
      res.add(hasher.hash(s));
    }
    return Collections.unmodifiableList(res);
  }
}
