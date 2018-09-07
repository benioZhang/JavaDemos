package leetcode.linklist;

public class LinkedListProblems {

    /**
     * https://leetcode-cn.com/problems/linked-list-cycle/description/
     * Q:给定一个链表，判断链表中是否有环
     * A:注意，环入口不一定在链头！！！！！！！！！！
     * 快慢指针
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // 慢指针每次走一步
            fast = fast.next.next;// 快指针每次走两步
            if (slow == fast) { //如果有环，快指针最终将与慢指针相遇。
                return true;
            }
        }
        return false;
    }

    /**
     * https://leetcode-cn.com/problems/linked-list-cycle-ii/description/
     * Q:给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * <p>
     * 说明：不允许修改给定的链表。
     * A:定义两个指针，快指针每次走两步，慢指针一次走一步，当环存在时，则快指针一定会追上慢指针；
     * 追上时使其中一个指针指向链头，然后两个指针同时走，则再次相遇时指针的位置为环开始的位置
     * 证明可参考：https://www.jianshu.com/p/0c565740a022
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // 慢指针每次走一步
            fast = fast.next.next;// 快指针每次走两步
            if (slow == fast) { //如果有环，快指针最终将与慢指针相遇。
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    /**
     * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/description/
     * Q:编写一个程序，找到两个单链表相交的起始节点
     * 注意：
     * <p>
     * 如果两个链表没有交点，返回 null.
     * 在返回结果后，两个链表仍须保持原有的结构。
     * 可假定整个链表结构中没有循环。
     * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 计算两链表长度差
        int lengthA = 0, lengthB = 0;
        ListNode node = headA;
        while (node.next != null) {
            lengthA++;
            node = node.next;
        }
        node = headB;
        while (node.next != null) {
            lengthB++;
            node = node.next;
        }
        // 将较长链表头指针移动delta-1次
        final int delta = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB) {
            for (int i = 0; i < delta; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < delta; i++) {
                headB = headB.next;
            }
        }

        // 同时遍历两链表
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    /**
     * Q:给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * <p>
     * 示例：
     * <p>
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * <p>
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     * <p>
     * 给定的 n 保证是有效的。
     * A:快慢指针，两指针保持n的距离。当快指针到达链表尾时，慢指针即为要删除节点的上一个节点
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode p = head, q = head;
        int i = 0;
        while (p != null) {
            p = p.next;
            if (i > n) {
                q = q.next;
            }
            i++;
        }
        if (q != head) {
            q.next = q.next.next;
        } else {

        }
        return null;
    }

}
