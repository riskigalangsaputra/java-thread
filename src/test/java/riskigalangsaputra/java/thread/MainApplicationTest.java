package riskigalangsaputra.java.thread;

import org.junit.jupiter.api.Test;

public class MainApplicationTest {

    @Test
    void mainThread() {
        var name = Thread.currentThread().getName();
        System.out.println("Tread Name : " + name);
    }

    @Test
    void createdThread() {

        var name = Thread.currentThread().getName();
        System.out.println("Tread Name : " + name);

        Runnable runnable = () -> {
            System.out.println("My tread name : " + Thread.currentThread().getName());
        };

        var thread = new Thread(runnable);
        thread.start();
    }

    @Test
    void threadSleep() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000L);

                System.out.println("Hello from thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("Program selesai");
        Thread.sleep(3_000L);
    }

    @Test
    void threadJoin() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000L);

                System.out.println("Hello from thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("Menunggu program");
        thread.join();
        System.out.println("Program selesai");
    }

    @Test
    void threadInterrupt() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runnable : " + i);
                try {
                    Thread.sleep(1_000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5_000L);
        thread.interrupt();
        System.out.println("Menunggu program");
        thread.join();
        System.out.println("Program selesai");
    }

    @Test
    void threadInterruptCorrect() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                // manual check interrup
                if (Thread.interrupted()) {
                    return;
                }
                System.out.println("Runnable : " + i);
                try {
                    Thread.sleep(1_000L);
                } catch (InterruptedException e) {
                    return;
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5_000L);
        thread.interrupt();
        System.out.println("Menunggu program");
        thread.join();
        System.out.println("Program selesai");
    }

    @Test
    void threadName() {
        var thread = new Thread(() -> {
            System.out.println("Run in thread : " + Thread.currentThread().getName());
        });
        thread.setName("galang");
        thread.start();
    }

    @Test
    void threadState() throws InterruptedException {
        var thread = new Thread(() -> {
            System.out.println("Status 2 : " + Thread.currentThread().getState());
            System.out.println("Run in thread : " + Thread.currentThread().getName());
        });
        thread.setName("galang");
        System.out.println("Status 1 : " + thread.getState());

        thread.start();
        thread.join();
        System.out.println("Status 3 : " + thread.getState());
    }
}
