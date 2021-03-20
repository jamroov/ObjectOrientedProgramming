package threads;

public class RunnableCounter implements Runnable {

    static final public Integer START_FROM = 3;
    public Finisher finisher;

    @Override
    public void run() {
        for (int i = START_FROM; i >= 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        finisher.finishHim();
    }
}
