package jeight.text;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @author Michael Gfeller
 */
public class TextSplitter {
  private static final String TMP_DIR = System.getProperty("java.io.tmpdir");

  public static void main(String[] args) {

    try {
      Stream<String> lines = Files.lines(Paths.get(TMP_DIR, "webpage_1.txt"), StandardCharsets.UTF_8);
//      lines.forEach(line -> System.err.println(line));

//      lines.map(line -> line.split("\\W+")) // Stream<String[]>
//              .forEach(System.out::println);

/*
      lines.map(line -> line.split("\\W+")) // Stream<String[]>
              .flatMap(Arrays::stream)      // Stream<String>
              .filter(StringUtils::isNotBlank)
              .map(String::toLowerCase)
              .distinct()
              .sorted()
              .forEach(System.out::println);
*/

      Map<String, Long> words = lines.map(line -> line.split("\\W+")) // Stream<String[]>
              .flatMap(Arrays::stream)      // Stream<String>
              .filter(StringUtils::isNotBlank)
              .filter(word -> !StringUtils.containsAny(word, "0123456789_"))
              .filter(word -> word.length() > 1)
              .map(String::toLowerCase)
              .collect(groupingBy(identity(), counting()));
      SortedSet<String> keys = new TreeSet<>();
      Map<Long, List<String>> byCount = new HashMap<>();
      keys.addAll(words.keySet());
      for (String key : keys) {
        if (!byCount.containsKey(words.get(key))) {
          byCount.put(words.get(key), new ArrayList<>());
        }
        byCount.get(words.get(key)).add(key);
        System.out.println(key + ": " + words.get(key));
      }
      System.out.println(StringUtils.repeat("-", 50));
      SortedSet<Long> counts = new TreeSet<>();
      counts.addAll(byCount.keySet());
      for (Long count : counts) {
        System.out.println(count + ": " + byCount.get(count));
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
}
