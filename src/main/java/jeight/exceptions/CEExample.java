package jeight.exceptions;

import java.io.IOException;

/**
 * @author Michael Gfeller
 */
public class CEExample implements Runnable {

  public static void main(String[] args) throws IOException {
    Thread  thread = new Thread( new CEExample());
    thread.start();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    throw new IOException("oops");
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Alive!");
    }
  }
}
