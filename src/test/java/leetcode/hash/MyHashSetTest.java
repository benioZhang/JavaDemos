package leetcode.hash;

import org.junit.Assert;
import org.junit.Test;

public class MyHashSetTest {
    @Test
    public void test() {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        Assert.assertEquals(true, hashSet.contains(1));
        Assert.assertEquals(false, hashSet.contains(3));
        hashSet.add(2);
        Assert.assertEquals(true, hashSet.contains(2));
        hashSet.remove(2);
        Assert.assertEquals(false, hashSet.contains(2));
    }
}