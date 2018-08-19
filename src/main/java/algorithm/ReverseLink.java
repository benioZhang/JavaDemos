package algorithm;

public class ReverseLink {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node reverse(Node head) {
        if (head == null) {
            throw new NullPointerException();
        }
        Node pre = null, tmp = null;
        while (head != null) {
            tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

}
