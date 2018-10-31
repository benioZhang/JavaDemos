package concurrent;

import java.util.LinkedList;
import java.util.List;

/**
 * http://ifeve.com/blocking-queues/
 * 阻塞队列的简单实现
 * 在enqueue和dequeue方法内部，只有队列的大小等于上限（limit）或者下限（0）时，才调用notifyAll方法。
 * 如果队列的大小既不等于上限，也不等于下限，任何线程调用enqueue或者dequeue方法时，都不会阻塞，
 * 都能够正常的往队列中添加或者移除元素
 */
public class BlockingQueue {
    private List<Object> queue = new LinkedList<>();
    private int limit;

    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(Object item) throws InterruptedException {
        while (queue.size() == limit) {
            wait();
        }
        if (queue.size() == 0) {
            notifyAll();
        }
        queue.add(item);
    }

    public synchronized Object dequeue() throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }
        if (queue.size() == limit) {
            notifyAll();
        }
        return queue.remove(0);
    }

    public static final int MAX_BUFFER_SIZE = 10;
    public static final int CONSUMER_COUNT = 5;
    public static final int PRODUCER_COUNT = 10;
    public static final int CONSUME_DURATION = 300;
    public static final int PRODUCE_DURATION = 500;

    static class Consumer implements Runnable {
        private BlockingQueue mQueue;
        private int mNo;

        public Consumer(int no, BlockingQueue mQueue) {
            this.mNo = no;
            this.mQueue = mQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(CONSUME_DURATION);
                    Object o = mQueue.dequeue();
                    System.out.println("Consumer#" + mNo + " consume " + o);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    static class Producer implements Runnable {
        private BlockingQueue mQueue;
        private int mNo;

        public Producer(int no, BlockingQueue mQueue) {
            this.mNo = no;
            this.mQueue = mQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(PRODUCE_DURATION);
                    Object o = (int) (Math.random() * 10);
                    System.out.println("Producer#" + mNo + " produce " + o);
                    mQueue.enqueue(o);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue(MAX_BUFFER_SIZE);
        for (int i = 0; i < CONSUMER_COUNT; i++) {
            new Thread(new Consumer(i, queue)).start();
        }
        for (int i = 0; i < PRODUCER_COUNT; i++) {
            new Thread(new Producer(i, queue)).start();
        }
    }
}
