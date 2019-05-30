package leetcode.hash;

import org.junit.Assert;
import org.junit.Test;

public class MyHashMapTest {
    @Test
    public void test() {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        Assert.assertEquals(1, hashMap.get(1));
        Assert.assertEquals(-1, hashMap.get(3));
        hashMap.put(2, 1);         // 更新已有的值
        Assert.assertEquals(1, hashMap.get(2));
        hashMap.remove(2);         // 删除键为2的数据
        Assert.assertEquals(-1, hashMap.get(2));
    }
}