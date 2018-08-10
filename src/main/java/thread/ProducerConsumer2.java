package thread;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * http://www.importnew.com/27063.html
 */
public class ProducerConsumer2 {
    public static final int MAX_BUFFER_SIZE = 10;
    public static final int CONSUMER_COUNT = 5;
    public static final int PRODUCER_COUNT = 10;
    public static final int CONSUME_DURATION = 300;
    public static final int PRODUCE_DURATION = 500;

    static class Consumer implements Runnable {
        private Queue buffer;
        private final Object lock;
        private int no;

        public Consumer(int no, Queue buffer, Object lock) {
            this.buffer = buffer;
            this.lock = lock;
            this.no = no;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (lock) {
                        while (buffer.isEmpty()) {
                            lock.wait();
                        }
                        Thread.sleep(CONSUME_DURATION);
                        Object o = buffer.poll();
                        System.out.println("Consumer#" + no + " consume " + o);
                        lock.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    static class Producer implements Runnable {
        private Queue buffer;
        private final Object lock;
        private int no;

        public Producer(int no, Queue buffer, Object lock) {
            this.buffer = buffer;
            this.lock = lock;
            this.no = no;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (lock) {
                        while (buffer.size() >= MAX_BUFFER_SIZE) {
                            lock.wait();
                        }
                        Thread.sleep(PRODUCE_DURATION);
                        Object o = (int) (Math.random() * 10);
                        buffer.offer(o);
                        System.out.println("Producer#" + no + " produce " + o);
                        lock.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        BlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(MAX_BUFFER_SIZE);
        for (int i = 0; i < CONSUMER_COUNT; i++) {
            new Thread(new Consumer(i, queue, lock)).start();
        }
        for (int i = 0; i < PRODUCER_COUNT; i++) {
            new Thread(new Producer(i, queue, lock)).start();
        }
    }
}
