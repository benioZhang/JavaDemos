package leetcode.hash;

import org.junit.Assert;
import org.junit.Test;

public class RandomizedSetTest {
    @Test
    public void test() {
        boolean result;
        int random;
        // 初始化一个空的集合。
        RandomizedSet randomSet = new RandomizedSet();

        // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        result = randomSet.insert(1);
        Assert.assertTrue(result);

        // 返回 false ，表示集合中不存在 2 。
        result = randomSet.remove(2);
        Assert.assertFalse(result);

        // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        result = randomSet.insert(2);
        Assert.assertTrue(result);

        // getRandom 应随机返回 1 或 2 。
        random = randomSet.getRandom();
        Assert.assertTrue(random == 1 || random == 2);

        // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        result = randomSet.remove(1);
        Assert.assertTrue(result);

        // 2 已在集合中，所以返回 false 。
        result = randomSet.insert(2);
        Assert.assertFalse(result);

        // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
        random = randomSet.getRandom();
        Assert.assertTrue(random == 2);
    }
}