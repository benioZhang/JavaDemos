package leetcode.linklist;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListProblemsTest {
    @Test
    public void hasCycle() throws Exception {
        ListNode list1 = new ListNode(1);
        list1.next = list1;
        Assert.assertTrue(LinkedListProblems.hasCycle(list1));

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        Assert.assertFalse(LinkedListProblems.hasCycle(list2));

        ListNode list3 = new ListNode(1);
        list3.next = new ListNode(2);
        list3.next.next = list3.next;
        Assert.assertTrue(LinkedListProblems.hasCycle(list3));
    }

    @Test
    public void detectCycle() throws Exception {
        ListNode list1 = new ListNode(1);
        list1.next = list1;
        Assert.assertEquals(LinkedListProblems.detectCycle(list1), list1);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        Assert.assertNull(LinkedListProblems.detectCycle(list2));

        ListNode list3 = new ListNode(1);
        list3.next = new ListNode(2);
        list3.next.next = list3.next;
        Assert.assertEquals(LinkedListProblems.detectCycle(list3), list3.next);
    }

    @Test
    public void getIntersectionNode() {
        // a: 1->2->3->4->5, b:9->8->7->4->5
        ListNode intersectionNode;
        ListNode headA, headB;
        headA = new ListNode(1);
        headA.next = new ListNode(2);
        headB = new ListNode(9);
        headB.next = new ListNode(8);
        headB.next.next = new ListNode(7);
        intersectionNode = headA.next.next = headB.next.next.next = new ListNode(4);
        headA.next.next.next = new ListNode(5);
        Assert.assertEquals(intersectionNode, LinkedListProblems.getIntersectionNode(headA, headB));

        headA = new ListNode(1);
        headA.next = new ListNode(2);
        headB = new ListNode(9);
        headB.next = new ListNode(8);
        headB.next.next = new ListNode(7);
        Assert.assertNull(LinkedListProblems.getIntersectionNode(headA, headB));
    }

    @Test
    public void removeNthFromEnd() {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);

    }
}