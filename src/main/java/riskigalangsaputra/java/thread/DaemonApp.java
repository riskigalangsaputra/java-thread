package riskigalangsaputra.java.thread;

public class DaemonApp {

    public static void main(String[] args) {
        var thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("Run Thread"); // tidak akan di tunggu programnya selsai kalau sebagai daemon thread
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread.setDaemon(true);
        thread.start();
    }
}
