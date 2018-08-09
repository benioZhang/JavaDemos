package thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchSample {
    static class Worker {
        private String name;        // 名字
        private long workDuration;  // 工作持续时间

        /**
         * 构造器
         */
        public Worker(String name, long workDuration) {
            this.name = name;
            this.workDuration = workDuration;
        }

        /**
         * 完成工作
         */
        public void doWork() {
            System.out.println(name + " begins to work...");
            try {
                Thread.sleep(workDuration); // 用休眠模拟工作执行的时间
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(name + " has finished the job...");
        }
    }

    /**
     * 测试线程
     */
    private static class WorkerTestThread implements Runnable {
        private Worker worker;
        private CountDownLatch cdLatch;

        public WorkerTestThread(Worker worker, CountDownLatch cdLatch) {
            this.worker = worker;
            this.cdLatch = cdLatch;
        }

        @Override
        public void run() {
            worker.doWork();        // 让工人开始工作
            cdLatch.countDown();    // 工作完成后倒计时次数减1
        }
    }

    private static final int MAX_WORK_DURATION = 5000;  // 最大工作时间
    private static final int MIN_WORK_DURATION = 1000;  // 最小工作时间

    // 产生随机的工作时间
    private static long getRandomWorkDuration(long min, long max) {
        return (long) (Math.random() * (max - min) + min);
    }

    public static void main(String[] args) {
        int workerCount = 5;
        CountDownLatch latch = new CountDownLatch(workerCount); // 创建倒计时闩
        for (int i = 0; i < workerCount; i++) {
            Worker worker = new Worker("worker " + i, getRandomWorkDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));
            new Thread(new WorkerTestThread(worker, latch)).start();
        }
        try {
            latch.await();  // 等待倒计时闩减到0
            System.out.println("All jobs have been finished!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
