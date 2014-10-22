package jeight.lambda;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Michael Gfeller
 */
public class PersonStreamTest {

  public static void main(String[] args) {
    List<Person> people = Person.createPeople();

    System.out.println("# Female: " + people.stream().filter(p -> p.getGender().equals(Gender.FEMALE)).count());
    System.out.println("# Males:  " + people.stream().filter(p -> p.getGender().equals(Gender.MALE)).count());
    System.out.println("# All:    " + people.stream().count());

    Predicate<Person> adult = p -> Period.between(p.getDob(), LocalDate.now()).getYears() > 18;
      Function<Person, Integer> age = p -> Period.between(p.getDob(), LocalDate.now()).getYears();

    System.out.println("Adults:");
    people.stream().filter(adult).forEach(Person::printMe);

    System.out.println("Adults as a list (sorted by first name desc):");
    List<Person> adults = people.stream().filter(adult).sorted((p1, p2) -> p2.getFirst().compareTo(p1.getFirst()))
        .collect(Collectors.toList());
    adults.forEach(Person::printMe);

    System.out.println("Adult average age: " + people.stream().filter(adult).mapToDouble(p -> age.apply(p)).average().getAsDouble());
  }
}
