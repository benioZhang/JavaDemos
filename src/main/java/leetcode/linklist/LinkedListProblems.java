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
     * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
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
        ListNode p = head, q = null;
        int i = 0;// 记录p移动的次数
        while (p.next != null) {
            p = p.next;
            i++;
            //当p移动了n次时，q开始移动
            if (i == n) {
                q = head;
            } else if (i > n) {
                q = q.next;
            }
        }
        if (q != null) {
            q.next = q.next.next;
        } else {
            head = head.next;
        }
        return head;
    }

    /**
     * https://leetcode-cn.com/problems/reverse-linked-list/description/
     * Q:反转一个单链表。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head, q;
        while (head.next != null) {
            q = p;
            p = head.next;
            head.next = p.next;
            p.next = q;
        }
        return p;
    }

    /**
     * https://leetcode-cn.com/problems/remove-linked-list-elements/description/
     * Q:删除链表中等于给定值 val 的所有节点。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode p = head, q = null;
        while (p != null) {
            if (p.val == val) {
                if (q == null) {
                    // 头结点为要删除的结点
                    head = head.next;
                } else {
                    q.next = p.next;
                }
            } else {
                q = p;
            }
            p = p.next;
        }
        return head;
    }

    /**
     * Q:奇偶链表
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     * <p>
     * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 1->3->5->2->4->NULL
     * 示例 2:
     * <p>
     * 输入: 2->1->3->5->6->4->7->NULL
     * 输出: 2->3->6->7->1->5->4->NULL
     * 说明:
     * <p>
     * 应当保持奇数节点和偶数节点的相对顺序。
     * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        return null;
    }

    /**
     * https://leetcode-cn.com/problems/palindrome-linked-list/description/
     * Q:请判断一个链表是否为回文链表。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     * <p>
     * 输入: 1->2->2->1
     * 输出: true
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     * A:
     * （1）先得到链表的中间节点；
     * （2）从中间节点的下一个节点开始，反转链表。
     * （3）从中间节点处，断开原链表。
     * （4）用两个指针分别向两个端点移动，同时进行比较，数据相同则继续，数据不同则直接返回false。直到遍历完成，最后返回true。
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode midNode = findMiddleNode(head);
        ListNode head2 = reverseList(midNode.next);
        midNode.next = null;
        while (head != null && head2 != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    public static ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        // 通过快慢指针找到中间节点
        while (head.next != null && head.next.next != null) {
            slow = slow.next;
            head = head.next.next;
        }
        return slow;
    }

    /**
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
     * Q:将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>
     * 示例：
     * <p>
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return head;
    }

    /**
     * https://leetcode-cn.com/problems/add-two-numbers/description/
     * Q:给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, p = null;
        int value, flag = 0;
        // 退出循环的条件是，l1==null&&l2==null&&flag==0
        // 注意flag>0表示有进位，需要多生成一位
        while (l1 != null || l2 != null || flag > 0) {
            // 计算当前位的值
            value = flag;
            if (l1 != null) {
                value += l1.val;
            }
            if (l2 != null) {
                value += l2.val;
            }
            flag = value / 10;// 进位
            if (head == null) {
                head = new ListNode(value % 10);
                p = head;
            } else {
                p.next = new ListNode(value % 10);
                p = p.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head;
    }

    /**
     * https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/description/
     * Q:您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
     * <p>
     * 扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * 1---2---3---4---5---6--NULL
     * |
     * 7---8---9---10--NULL
     * |
     * 11--12--NULL
     * <p>
     * 输出:
     * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
     *
     * @param head
     * @return
     */
    public static Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;//p为主链表遍历指针
        Node q;// q为子链表遍历指针
        while (p != null) {
            // 存在子链表，则将其插入到主链表中
            // 子链表中可能仍存在子链表，但是插入到主链表后会交给主链表处理
            if (p.child != null) {
                q = p.child;
                while (q.next != null) {
                    q = q.next;
                }
                q.next = p.next;
                if (q.next != null) {
                    q.next.prev = q;
                }
                p.next = p.child;
                p.child.prev = p;
                p.child = null;
            }
            p = p.next;
        }
        return head;
    }

    /**
     * Q:复制带随机指针的链表
     * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
     * <p>
     * 要求返回这个链表的深度拷贝。
     * A:
     * 1. 需要复制的链表ABCD，ABCD是原来的链表，A’B’C’D’是复制的链表。
     * 2. 第一遍扫描顺序复制next指针，把ABCD的next分别指向A’B’C’D’，即A->A'->B->B'->C->C'->D->D'
     * 复制random指针： A’->random=A->random->next
     * 3. 第三遍扫描，恢复:A->next=A’->next;A’->next=A’->next->next;
     *
     * @param head
     * @return
     */
    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode p = head, q;
        while (p != null) {
            q = new RandomListNode(p.label);
            q.next = p.next;
            p.next = q;
            p = q.next;
        }

        p = head;
        while (p != null) {
            if (p.random != null) {

            }
        }

        return null;
    }
}
