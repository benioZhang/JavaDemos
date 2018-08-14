package algorithm;

import org.junit.Test;

public class ReverseLinkTest {

    @Test(expected = NullPointerException.class)
    public void testException() {
        ReverseLink.reverse(null);
    }

    @Test
    public void reverse() {
        ReverseLink.Node head = new ReverseLink.Node(-1);
        ReverseLink.Node next = head;
        int length = 10;
//        for (int i = 0; i < length; i++) {
//            ReverseLink.Node node = new ReverseLink.Node(i);
//            if (i == 0) {
//                next = node;
//            } else {
//                next.next = node;
//            }
//        }


    }
}