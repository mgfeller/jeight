package jeight.text;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Michael Gfeller
 */
public class WebpageReader {

  private static final String URL_1 = "http://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html";
  private static final String TMP_DIR = System.getProperty("java.io.tmpdir");

  public static void main(String[] args) {
    try {
      final URL url = new URL(URL_1);
      try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
           BufferedWriter out = Files.newBufferedWriter(Paths.get(TMP_DIR, "webpage_1.txt"), StandardCharsets.UTF_8, StandardOpenOption.CREATE)
      ) {
        String str;
        while ((str = in.readLine()) != null) {
          out.write(str + "\n");
        }
      } catch (IOException ioe) {
        throw new RuntimeException(ioe);
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }
}
