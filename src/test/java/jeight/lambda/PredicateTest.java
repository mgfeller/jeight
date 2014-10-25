package jeight.lambda;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.function.Predicate;

/**
 * @author Michael Gfeller
 */
@Test
public class PredicateTest {

  public void testPredicate() {
    Predicate<Person> male = p -> p.getGender().equals(Gender.MALE);
    Predicate<Person> adult = p -> Period.between(p.getDob(), LocalDate.now()).getYears() >= 18;
    Person tor = new Person("tor", "smith", LocalDate.of(1980, Month.APRIL, 1), Gender.MALE, "", "");
    Person kari = new Person("kari", "smith", LocalDate.of(2014, Month.OCTOBER, 1), Gender.FEMALE, "", "");
    Assert.assertTrue(male.test(tor));
    Assert.assertFalse(male.test(kari));

    Assert.assertTrue(adult.test(tor));
    Assert.assertFalse(adult.test(kari));

    Assert.assertTrue(adult.and(male).test(tor));
    Assert.assertFalse(adult.or(male).test(kari));
  }
}
