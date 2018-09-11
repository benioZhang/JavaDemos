package leetcode.linklist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedListUtil {
    public static List<Integer> getNodeListValue(Node head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

    public static Node createNodeList(int length, int valueBegin) {
        Node head = new Node();//空结点
        head.val = -1;
        Node p = head, q;
        for (int i = 0; i < length; i++) {
            q = p;
            p.next = new Node();
            p = p.next;
            p.val = valueBegin + i;
            p.prev = q;
        }
        return head.next;
    }

    public static RandomListNode createRandomList(int length) {
        RandomListNode emptyHead = new RandomListNode(-1);
        RandomListNode[] nodes = new RandomListNode[length];
        RandomListNode p = emptyHead;
        for (int i = 0; i < length; i++) {
            p.next = new RandomListNode(i);
            nodes[i] = p.next;
            p = p.next;
        }
        Random random = new Random();
        int index;
        for (int i = 0; i < length; i++) {
            index = random.nextInt(length);
            nodes[i].random = nodes[index];
        }
        return emptyHead.next;
    }

}
