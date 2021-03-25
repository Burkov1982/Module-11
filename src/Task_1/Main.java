package Task_1;

public class Main {
    private volatile int counter = 0;
    public static void main(String[] args) {

        Thread getSeconds = new CounterThread();
        getSeconds.start();

        Thread get5Seconds = new SecondsPrinter();
        get5Seconds.start();
    }
}
