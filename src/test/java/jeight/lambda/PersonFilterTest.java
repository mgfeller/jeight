package jeight.lambda;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Michael Gfeller
 */
public class PersonFilterTest {

  public static void main(String[] args) {
    Predicate<Person> male = p -> p.getGender().equals(Gender.MALE);
    Predicate<Person> female = p -> p.getGender().equals(Gender.FEMALE);
    Predicate<Person> adult = p -> Period.between(p.getDob(), LocalDate.now()).getYears() > 18;
    Function<Person, String> lastNameFirstName = p -> p.getLast() + ", " + p.getFirst() + " ("
        + Period.between(p.getDob(), LocalDate.now()).getYears() + ")";
    Function<Person, String> firstNameLastName = p -> p.getFirst() + " " + p.getLast() + " ("
        + Period.between(p.getDob(), LocalDate.now()).getYears() + ")";

    List<Person> persons = Person.createPeople();
    System.out.println("\nmale:");
    filterAndPrint(persons, male, lastNameFirstName);
    System.out.println("\nfemale:");
    filterAndPrint(persons, female, lastNameFirstName);
    System.out.println("\nadults:");
    filterAndPrint(persons, adult, firstNameLastName);

  }

  public static void filterAndPrint(List<Person> persons,
                                    Predicate<Person> predicate,
                                    Function<Person, String> formatter) {
    for (Person person : persons) {
      if (predicate.test(person)) {
        System.out.println(formatter.apply(person));
      }
    }
  }
}
