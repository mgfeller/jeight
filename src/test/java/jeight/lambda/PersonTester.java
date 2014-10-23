package jeight.lambda;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Michael Gfeller
 */
@Test
public class PersonTester {

  public void testPredicate() {
    List<Person> people = Person.createPeople();
    PersonPredicate male = (p) -> p.getGender().equals(Gender.MALE);

    for (Person person : people) {
      Assert.assertEquals(person.getGender().equals(Gender.MALE), male.test(person));
    }
  }
}
