package Task_1;

public class CounterThread extends Thread {

    private final Counter counter = new Counter();
    private int counterOfSeconds = counter.getCounter();
    private static final Thread thread = Thread.currentThread();

    @Override
    public void run() {
        try {
            while (!thread.isInterrupted()) {
                sleep(1000);
                counterOfSeconds++;
                counter.setCounter(counterOfSeconds);
                if (counterOfSeconds % 5 != 0) {
                    messageAboutSecond();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void messageAboutSecond(){
        System.out.println(String.format("Прошло %s секунд...", counterOfSeconds));

    }
}
