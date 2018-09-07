package leetcode.linklist;

/**
 * https://leetcode-cn.com/explore/learn/card/linked-list/193/singly-linked-list/741/
 */
public class MyLinkedList {
    private int size = 0;
    private final Node head = new Node(Integer.MIN_VALUE);

    private static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
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
        Node n = head;
        Node p = null;
        for (int i = 0; i <= index; i++) {
            p = n;
            n = n.next;
        }
        p.next = new Node(val, n);
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1) {
            return;
        }
        Node n = head;
        Node p = null;
        for (int i = 0; i <= index; i++) {
            p = n;
            n = n.next;
        }
        p.next = n.next;
        n.next = null;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */