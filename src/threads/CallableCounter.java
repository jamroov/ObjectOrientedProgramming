package threads;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableCounter implements Callable<Double> {
    public Finisher finisher;
    @Override
    public Double call() throws Exception {
        for (int i = 3; i >= 0; i--) {
            System.out.println(i);
            Thread.sleep(1);
        }
        return new Random().nextDouble();
    }
}
