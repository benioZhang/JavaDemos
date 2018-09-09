package leetcode.linklist;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static leetcode.linklist.ListNodeUtil.createLinkedList;
import static leetcode.linklist.ListNodeUtil.getLinkedListValue;

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
        ListNode list1, list2;
        list1 = createLinkedList(1);// 1
        list2 = LinkedListProblems.removeNthFromEnd(list1, 1);
        Assert.assertEquals(null, list2);
        Assert.assertEquals(Collections.emptyList(), getLinkedListValue(list2));

        list1 = createLinkedList(5);// 1->2->3->4->5
        list2 = LinkedListProblems.removeNthFromEnd(list1, 1);
        Assert.assertEquals(list1, list2);
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4), getLinkedListValue(list2));

        list1 = createLinkedList(5);// 1->2->3->4->5
        list2 = LinkedListProblems.removeNthFromEnd(list1, 5);
        Assert.assertEquals(list1.next, list2);
        Assert.assertEquals(Arrays.asList(2, 3, 4, 5), getLinkedListValue(list2));

        list1 = createLinkedList(5);// 1->2->3->4->5
        list2 = LinkedListProblems.removeNthFromEnd(list1, 2);
        Assert.assertEquals(list1, list2);
        Assert.assertEquals(Arrays.asList(1, 2, 3, 5), getLinkedListValue(list2));

        list1 = createLinkedList(2);// 1->2
        list2 = LinkedListProblems.removeNthFromEnd(list1, 1);
        Assert.assertEquals(list1, list2);
        Assert.assertEquals(Arrays.asList(1), getLinkedListValue(list2));
    }

    @Test
    public void reverseList() {
        ListNode list, node;
        Assert.assertNull(LinkedListProblems.reverseList(null));

        list = createLinkedList(1);// 1
        Assert.assertEquals(list, LinkedListProblems.reverseList(list));

        list = createLinkedList(2);// 1->2
        node = LinkedListProblems.reverseList(list);
        Assert.assertEquals(list, node.next);
        Assert.assertEquals(Arrays.asList(2, 1), getLinkedListValue(node));

        list = createLinkedList(4);// 1->2->3->4
        node = LinkedListProblems.reverseList(list);
        Assert.assertEquals(list, node.next.next.next);
        Assert.assertEquals(Arrays.asList(4, 3, 2, 1), getLinkedListValue(node));
    }

    @Test
    public void removeElements() {
        ListNode list, node;
        list = new ListNode(1);
        list.next = new ListNode(1);
        Assert.assertNull(null, LinkedListProblems.removeElements(list, 1));

        list = new ListNode(1);
        node = list.next = new ListNode(2);
        list.next.next = new ListNode(1);
        Assert.assertEquals(node, LinkedListProblems.removeElements(list, 1));
        Assert.assertEquals(Arrays.asList(2), getLinkedListValue(node));

        list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(6);
        list.next.next.next = new ListNode(3);
        list.next.next.next.next = new ListNode(4);
        list.next.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next.next = new ListNode(6);
        Assert.assertEquals(list, LinkedListProblems.removeElements(list, 6));
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5), getLinkedListValue(list));
    }

    @Test
    public void oddEvenList() {

    }

    @Test
    public void isPalindrome() {
        ListNode list, node;
        Assert.assertTrue(LinkedListProblems.isPalindrome(null));

        list = new ListNode(1);
        list.next = new ListNode(2);
        Assert.assertFalse(LinkedListProblems.isPalindrome(list));

        node = list = new ListNode(1);
        node = node.next = new ListNode(2);
        node = node.next = new ListNode(2);
        node = node.next = new ListNode(1);
        Assert.assertTrue(LinkedListProblems.isPalindrome(list));

        node = list = new ListNode(1);
        node = node.next = new ListNode(2);
        node = node.next = new ListNode(3);
        node = node.next = new ListNode(2);
        node = node.next = new ListNode(1);
        Assert.assertTrue(LinkedListProblems.isPalindrome(list));
    }
}