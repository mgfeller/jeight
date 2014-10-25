package jeight.lambda;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Write a simple Lambda expression that consumes a Lambda Predicate expression
 *
 * @author Michael Gfeller
 */
public class PredicateMain {

  public static void main(String[] args) {
    Predicate<Person> male = p -> p.getGender().equals(Gender.MALE);
    Predicate<Person> adult = p -> Period.between(p.getDob(), LocalDate.now()).getYears() >= 18;
    Consumer<Person> agePrinter = p -> {
      Period age = Period.between(p.getDob(), LocalDate.now());
      System.out.println(String.format("%s age = %dd %dm %dy" , p, age.getDays(), age.getMonths(), age.getYears()));
    };

    List<Person> people = Person.createPeople();
    System.out.println("Adults:");
    people.stream().filter(adult).forEach(agePrinter);

    System.out.println("Males:");
    people.stream().filter(male).forEach(agePrinter);

    System.out.println("Male and adult:");
    people.stream().filter(male.and(adult)).forEach(agePrinter);

    System.out.println("Male or adult:");
    people.stream().filter(male.or(adult)).forEach(agePrinter);

    System.out.println("Not (male or adult):");
    people.stream().filter(male.or(adult).negate()).forEach(agePrinter);

    System.out.println("Age:");
    people.stream().forEach(agePrinter);
  }
}
