package jeight.lambda;

/**
 * @author Michael Gfeller
 */
@FunctionalInterface // optional
public interface Hasher<R,T> {
  R hash(T in);
}
