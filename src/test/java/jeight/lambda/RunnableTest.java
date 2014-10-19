package jeight.lambda;

/**
 * @author Michael Gfeller
 */
public class RunnableTest {

    public static void main(String[] args) {

        System.out.println("--- runnable example ---");

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable 1 - as anon");
            }
        };

        Runnable r2 = () -> System.out.println("runnable 2 - as lambda");

        r1.run();
        r2.run();
    }
}
