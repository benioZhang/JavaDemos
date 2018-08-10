package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * http://www.importnew.com/27063.html
 */
public class ProducerConsumer {
    public static final int MAX_BUFFER_SIZE = 10;
    public static final int CONSUMER_COUNT = 5;
    public static final int PRODUCER_COUNT = 10;
    public static final int CONSUME_DURATION = 300;
    public static final int PRODUCE_DURATION = 500;

    static class Consumer implements Runnable {
        private BlockingQueue<Object> mQueue;
        private int mNo;

        public Consumer(int no, BlockingQueue<Object> mQueue) {
            this.mNo = no;
            this.mQueue = mQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(CONSUME_DURATION);
                    Object o = mQueue.take();
                    System.out.println("Consumer#" + mNo + " consume " + o);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    static class Producer implements Runnable {
        private BlockingQueue<Object> mQueue;
        private int mNo;

        public Producer(int no, BlockingQueue<Object> mQueue) {
            this.mNo = no;
            this.mQueue = mQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(PRODUCE_DURATION);
                    Object o = (int) (Math.random() * 10);
                    mQueue.put(o);
                    System.out.println("Producer#" + mNo + " produce " + o);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(MAX_BUFFER_SIZE);
        for (int i = 0; i < CONSUMER_COUNT; i++) {
            new Thread(new Consumer(i, queue)).start();
        }
        for (int i = 0; i < PRODUCER_COUNT; i++) {
            new Thread(new Producer(i, queue)).start();
        }
    }
}
