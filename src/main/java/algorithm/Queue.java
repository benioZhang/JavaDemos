package algorithm;

import java.util.EmptyStackException;

public class Queue {
    private int head = 0;
    private int tail = -1;
    private int size = 0;
    private int[] data;

    public Queue(int size) {
        this.data = new int[size];
    }

    public void offer(int i) {
        if (size == data.length) {
            // 扩容操作
            return;
        }
        tail++;
        tail = tail % data.length;
        data[tail] = i;
        size++;
    }

    public int poll() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        head = head % data.length;
        size--;
        return data[head++];
    }

    public static void main(String[] args) {
        Queue queue = new Queue(3);
        queue.offer(4);
        System.out.println(queue.poll());
        queue.offer(3);
        System.out.println(queue.poll());
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        queue.offer(8);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
