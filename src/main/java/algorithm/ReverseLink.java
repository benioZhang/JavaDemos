package algorithm;

public class ReverseLink {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void reverse(Node head) {
        if (head == null) {
            throw new NullPointerException();
        }
        Node pre = null;
        while (head != null) {
            head.next = pre;
            pre = head;
            head = head.next;
        }
    }

}
