package org.jk;

import java.util.concurrent.*;

public class C {
    private static int i = 0;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Callable<Integer> incrementer = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return ++i;
            }
        };
        Callable<Integer> decrementer = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return --i;
            }
        };
        int count = 0;
        while(count <10){
            Future f1 = service.submit(incrementer);
            Future f2 = service.submit(decrementer);
            System.out.println(f1.get());
            System.out.println(f2.get());
            count++;
        }

    }
}
