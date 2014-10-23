package jeight.lambda;

/**
 * @author Michael Gfeller
 */
@FunctionalInterface
public interface PersonPredicate {
  boolean test(Person person);
}
