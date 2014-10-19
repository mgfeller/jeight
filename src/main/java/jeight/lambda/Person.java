package jeight.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * @author Michael Gfeller
 */
public class Person {

    private final String first;
    private final String last;
    private final LocalDate dob;
    private final Gender gender;
    private final String email;
    private final String mobile;

    public Person(String first, String last, LocalDate dob, Gender gender, String email, String mobile) {
        this.first = first;
        this.last = last;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Gender getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    @Override
    public String toString() {
        return "Person{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", dob=" + dob +
                ", gender=" + gender +
                '}';
    }

    public String customToString(Function<Person, String> formatter) {
        return formatter.apply(this);
    }

    public static List<Person> createPeople() {
        final List<Person> people = new ArrayList<>();

        people.add(new Person("Horace", "Linebaugh", LocalDate.of(1985, 11, 1), Gender.MALE, "Horace@piplz.com", "12-12345678"));
        people.add(new Person("Emmitt", "Rain", LocalDate.of(1965, 10, 2), Gender.MALE, "Emmitt@piplz.com", "13-12345678"));
        people.add(new Person("Gordon", "Follett", LocalDate.of(1956, 9, 11), Gender.MALE, "Gordon@piplz.com", "14-12345678"));
        people.add(new Person("Don", "Lofgren", LocalDate.of(2002, 6, 24), Gender.MALE, "Don@piplz.com", "15-12345678"));
        people.add(new Person("Florentino", "Sirmans", LocalDate.of(2010, 4, 12), Gender.MALE, "Florentino@piplz.com", "16-12345678"));

        people.add(new Person("Mickie", "Glasser", LocalDate.of(2003, 5, 12), Gender.FEMALE, "Florentino@piplz.com", "26-12345678"));
        people.add(new Person("Lavenia", "Hysell", LocalDate.of(1999,  6, 3), Gender.FEMALE, "Lavenia@piplz.com", "23-12345678"));
        people.add(new Person("Sarina", "Leib", LocalDate.of(1967, 2, 4), Gender.FEMALE, "Sarina@piplz.com", "24-12345678"));
        people.add(new Person("Margarette", "Fuerst", LocalDate.of(1988, 1, 27), Gender.FEMALE, "Margarette@piplz.com", "25-12345678"));
        people.add(new Person("Herminia", "Mullett", LocalDate.of(1977, 7, 8), Gender.FEMALE, "Florentino@piplz.com", "26-12345678"));

        return Collections.unmodifiableList(people);
    }
}
