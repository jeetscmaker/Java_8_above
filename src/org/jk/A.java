package org.jk;

/* Java program to demonstrate
 the behavior of the
 submit() method */

import java.util.concurrent.*;

public class A {
    public static void main(String[] args)
            throws Exception {
        Thread t = new Thread(new Job());
        t.start();
        // Creating the object of the
        // Executor service interface
        ExecutorService executorService
                = Executors.newFixedThreadPool(1);

        // submit() method can return the
        // result of the computation
        // because it has a return type of Future.

        // By using submit(), we are
        // accepting a Callable task
        Future obj = executorService.submit(new Callable() {

            // Overriding the call method
            public Object call() {
                System.out.println(
                        "This is submit() "
                                + "method example");

                return "Returning Callable "
                        + "Task Result";
            }
        });

        /* This method will return the result
         if the task has finished perfectly.
         The submit() method returns a
         Java Future object which is
         used to check when the Runnable
         has completed.
         As it implements Future,
         get() method is called
         to get the result
         */
        System.out.println(obj.get());
    }
}
class Job implements Runnable{
    @Override
    public void run() {
        System.out.println("Job done!");
    }
}
