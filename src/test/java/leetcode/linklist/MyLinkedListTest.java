package leetcode.linklist;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyLinkedListTest {

    @Test
    public void test() throws Exception {
        MyLinkedList linkedList = new MyLinkedList();

        linkedList.addAtHead(1);
        Assert.assertEquals(getLinkedListValue(linkedList), Arrays.asList(1));

        linkedList.addAtTail(3);
        Assert.assertEquals(getLinkedListValue(linkedList), Arrays.asList(1, 3));

        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        Assert.assertEquals(getLinkedListValue(linkedList), Arrays.asList(1, 2, 3));

        Assert.assertEquals(linkedList.get(1), 2); //返回2

        linkedList.deleteAtIndex(1); //现在链表是1-> 3
        Assert.assertEquals(getLinkedListValue(linkedList), Arrays.asList(1, 3));

        Assert.assertEquals(linkedList.get(1), 3); //返回3
    }

    private static List<Integer> getLinkedListValue(MyLinkedList list) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int val = 0;
        while ((val = list.get(i)) > 0) {
            i++;
            result.add(val);
        }
        return result;
    }

}