package jeight.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Michael Gfeller
 */
public class PersonComparatorTest {

  public static void main(String[] args) {
    List<Person> persons = new ArrayList<>(Person.createPeople());

    System.out.println(" - compare with inner class - lastname asc - ");
    Collections.sort(persons, new Comparator<Person>() {

      @Override
      public int compare(Person o1, Person o2) {
        return o1.getLast().compareTo(o2.getLast());
      }
    });

    for (Person person : persons) {
      System.out.println(person);
    }

    System.out.println(" - compare with lambda - lastname desc - ");
    Collections.sort(persons, (Person p1, Person p2) -> p2.getLast().compareTo(p1.getLast()));
    for (Person person : persons) {
      System.out.println(person);
    }

    System.out.println(" - compare with lambda - firstname desc - ");
    Collections.sort(persons, (p1, p2) -> p2.getFirst().compareTo(p1.getFirst()));
    for (Person person : persons) {
      System.out.println(person);
    }

  }
}
