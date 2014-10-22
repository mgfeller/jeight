package jeight.lambda;

import java.util.List;

/**
 * @author Michael Gfeller
 */
public class PersonForEachTest {

  public static void main(String[] args) {
    List<Person> people = Person.createPeople();

    people.forEach(p -> System.out.println(p.getLast()));
    people.forEach(Person::printMe);


  }
}
