package threading;

/**
 * Created by mmandam on 12/20/16.
 */
public class NoVisibility {
    private static boolean ready = true;
    private static int number;


      public static class ReaderThread extends Thread {
        public void run() {
            while(ready) {
                System.out.println(number);
            }
            Thread.yield();
        }
    }

    public static void main (String args[]) {
        NoVisibility noVisibility = new NoVisibility();
        new ReaderThread().start();
            number = 42;
            ready = false;
    }
}
