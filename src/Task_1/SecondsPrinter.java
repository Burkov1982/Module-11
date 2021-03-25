package Task_1;

public class SecondsPrinter extends Thread {

    private static final Thread thread = Thread.currentThread();
    private final Counter counter = new Counter();

    @Override
    public void run() {
        while (!thread.isInterrupted()) {
            int counterOfSeconds = counter.getCounter();
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            if (counterOfSeconds % 5 == 0) {
                messageAbout5Seconds();
            }
        }
    }

    private void messageAbout5Seconds(){
        System.out.println("Прошло 5 секунд...");
    }
}
