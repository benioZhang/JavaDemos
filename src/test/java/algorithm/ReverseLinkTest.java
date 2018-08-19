package algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ReverseLinkTest {

    @Test(expected = NullPointerException.class)
    public void testException() {
        ReverseLink.reverse(null);
    }

    @Test
    public void reverse() {
        ReverseLink.Node head = new ReverseLink.Node(-1);
        ReverseLink.Node node = head;
        int length = 10;
        for (int i = 0; i < length; i++) {
            node.next = new ReverseLink.Node(i);
            node = node.next;
        }

        // Create a node list and reverse it
        List<ReverseLink.Node> nodeList = createNodeList(head);
        Collections.reverse(nodeList);

        // reverse
        head = ReverseLink.reverse(head);

        List<ReverseLink.Node> reversedNodeList = createNodeList(head);

        Assert.assertEquals(nodeList, reversedNodeList);
    }

    private static List<ReverseLink.Node> createNodeList(ReverseLink.Node head) {
        List<ReverseLink.Node> nodeList = new LinkedList<>();
        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }
        return nodeList;
    }
}