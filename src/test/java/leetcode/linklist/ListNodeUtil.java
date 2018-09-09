package leetcode.linklist;

import java.util.ArrayList;
import java.util.List;

public class ListNodeUtil {

    public static List<Integer> getLinkedListValue(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

    public static ListNode createLinkedList(int length) {
        int i = 1;
        ListNode head = new ListNode(i);
        ListNode node = head;
        while (i < length) {
            node.next = new ListNode(++i);
            node = node.next;
        }
        return head;
    }
}
