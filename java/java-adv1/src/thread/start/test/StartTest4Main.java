package thread.start.test;

import static util.MyLogger.log;

public class StartTest4Main {

    public static void main(String[] args) {
        PrintWork a = new PrintWork("A", 1000);
        PrintWork b = new PrintWork("B", 500);

        Thread threadA = new Thread(a, "ThreadA");
        Thread threadB = new Thread(b, "ThreadA");

        threadA.start();
        threadB.start();

    }

    static class PrintWork implements Runnable {

        private String content;
        private int sleepMS;

        public PrintWork(String content, int sleepMS) {
            this.content = content;
            this.sleepMS = sleepMS;
        }

        @Override
        public void run() {
            while (true) {
                log(content);
                try {
                    Thread.sleep(sleepMS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
