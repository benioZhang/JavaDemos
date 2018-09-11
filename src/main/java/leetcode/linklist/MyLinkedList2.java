package leetcode.linklist;

/**
 * https://leetcode-cn.com/problems/design-linked-list/description/
 */
public class MyLinkedList2 {
    private int size = 0;
    private final Node head = new Node(Integer.MIN_VALUE);

    private static class Node {
        public int value;
        public Node next;
        public Node pre;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node pre) {
            this.value = value;
            this.next = next;
            this.pre = pre;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList2() {
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index > size - 1) {
            return -1;
        }
        Node n = head;
        for (int i = 0; i <= index; i++) {
            n = n.next;
        }
        return n.value;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        Node p = head, q;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        q = new Node(val, p.next, p);
        if (p.next != null) {
            p.next.pre = q;
        }
        p.next = q;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1) {
            return;
        }
        Node p = head;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        if (p.next != null) {
            p.next.pre = p.pre;
        }
        p.pre.next = p.next;
        size--;
    }
}
