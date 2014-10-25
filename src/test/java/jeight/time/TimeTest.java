package jeight.time;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;

/**
 * Create and manipulate calendar data using classes from
 * java.time.LocalDateTime,
 * java.time.LocalDate,
 * java.time.LocalTime,
 * java.time.format.DateTimeFormatter,
 * java.time.Period:
 * * This class models a quantity or amount of time in terms of years, months and days.
 * * See {@link java.time.Duration} for the time-based equivalent to this class.
 *
 * @author Michael Gfeller
 */
@Test
public class TimeTest {

  public void testLocalDateTime() {
    LocalDateTime past = LocalDateTime.of(1981, Month.APRIL, 7, 21, 1, 2, 1);
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime recent = LocalDateTime.of(LocalDate.of(2014, Month.OCTOBER, 24), LocalTime.MIDNIGHT);
    Assert.assertTrue(now.isAfter(past));
    Assert.assertTrue(past.isBefore(now));
    Assert.assertTrue(past.isBefore(recent));
    Assert.assertEquals(past.withHour(7).getHour(), 7);
    Assert.assertEquals(past.minus(1, ChronoUnit.MONTHS).getMonth(), Month.MARCH);
  }

  public void testDateTimeFormatter() {
    LocalDateTime past = LocalDateTime.of(1981, Month.APRIL, 7, 21, 1, 2, 1);

    Assert.assertEquals(DateTimeFormatter.BASIC_ISO_DATE.format(past), "19810407");
    Assert.assertEquals(DateTimeFormatter.ISO_DATE.format(past), "1981-04-07");
    Assert.assertEquals(DateTimeFormatter.ISO_DATE_TIME.format(past), "1981-04-07T21:01:02.000000001");
    Assert.assertEquals(DateTimeFormatter.ISO_WEEK_DATE.format(past), "1981-W15-2");
    Assert.assertEquals(DateTimeFormatter.ofPattern("d MMM uuuu G").format(past),"7 Apr 1981 AD");
    Assert.assertEquals(DateTimeFormatter.ofPattern("d MMMM uuuu G").format(past),"7 April 1981 AD");
    Assert.assertEquals(DateTimeFormatter.ofPattern("dd MMMM uuuu G").format(past),"07 April 1981 AD");
    System.out.println(DateTimeFormatter.ofPattern("d MMM u G").format(past));
  }

  public void testPeriod() {
    LocalDateTime past = LocalDateTime.of(1981, Month.APRIL, 7, 21, 1, 2, 1);
    LocalDateTime recent = LocalDateTime.of(LocalDate.of(2014, Month.OCTOBER, 24), LocalTime.MIDNIGHT);

    Period recentPastPeriod = Period.between(past.toLocalDate(), recent.toLocalDate());

    Assert.assertFalse(recentPastPeriod.isNegative());
    List<TemporalUnit> recentPastUnits = recentPastPeriod.getUnits();
    Assert.assertEquals(recentPastUnits.size(), 3);
    Assert.assertTrue(recentPastUnits.contains(ChronoUnit.YEARS));
    Assert.assertTrue(recentPastUnits.contains(ChronoUnit.MONTHS));
    Assert.assertTrue(recentPastUnits.contains(ChronoUnit.DAYS));

  }
}
