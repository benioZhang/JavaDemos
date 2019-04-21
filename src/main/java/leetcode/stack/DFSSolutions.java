package leetcode.stack;

import java.util.LinkedList;

/*模板 - 递归
boolean DFS(Node cur, Node target, Set<Node> visited) {
        return true if cur is target;
        for (next : each neighbor of cur) {
        if (next is not in visited) {
        add next to visted;
        return true if DFS(next, target, visited) == true;
        }
        }
        return false;
        }

boolean DFS(int root, int target) {
        Set<Node> visited;
        Stack<Node> s;
        add root to s;
        while (s is not empty) {
        Node cur = the top element in s;
        return true if cur is target;
        for (Node next : the neighbors of cur) {
        if (next is not in visited) {
        add next to s;
        add next to visited;
        }
        }
        remove cur from s;
        }
        return false;
        }
 */
public class DFSSolutions {
    /**
     * https://leetcode-cn.com/problems/number-of-islands/description/
     * Q:岛屿的个数
     * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
     * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * 11110
     * 11010
     * 11000
     * 00000
     * <p>
     * 输出: 1
     * 示例 2:
     * <p>
     * 输入:
     * 11000
     * 11000
     * 00100
     * 00011
     * <p>
     * 输出: 3
     * A:我们现在把目光聚焦到其中一个1上，从这个1开始，先将这个1改成0，
     * 再沿着上下左右4个方向开始遍历矩阵，遍历的方法是深度优先搜索，将所有遍历到的1都改成0，
     * 直到在一个1的四个方向上相邻的的元素都是0，那么停止对这个元素的深搜。
     * 这样，我们就将“一个岛屿”上的所有1都改成了0，从地图上看，这个岛屿“消失了”。
     * 那么有多少个岛屿呢？就看这样的深搜遍历有多少次（因为一次这样的深搜消去了一个岛屿）
     *
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        final int row = grid.length;
        final int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    merge(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    // 深度优先搜索
    // 基本思想是合并相邻的域，并且应该递归地进行合并
    private static void merge(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '*';// 标记已经遍历过
        merge(grid, i - 1, j);
        merge(grid, i + 1, j);
        merge(grid, i, j - 1);
        merge(grid, i, j + 1);
    }

    /**
     * https://leetcode-cn.com/problems/target-sum/
     * Q: 494. 目标和
     * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
     * <p>
     * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums: [1, 1, 1, 1, 1], S: 3
     * 输出: 5
     * 解释:
     * <p>
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     * <p>
     * 一共有5种方法让最终目标和为3。
     * 注意:
     * <p>
     * 数组的长度不会超过20，并且数组中的值全为正数。
     * 初始的数组的和不会超过1000。
     * 保证返回的最终结果为32位整数。
     */
    public static int findTargetSumWays(int[] nums, int S) {
        boolean[] visited = new boolean[(int) Math.pow(2, nums.length)];
        // 记录数组中每个元素的符号
        LinkedList<Integer> stack = new LinkedList<>();
        visited[0] = true;
        stack.add(0);

        int count = 0;
        while (stack.size() > 0) {
            int cur = stack.pop();
            // 找到数组和为 S ，方法数加一
            if (getSum(nums, cur) == S) {
                count++;
            }
            // 将邻接点添加到栈中
            for (int i = 0, len = nums.length; i < len; i++) {
                // 每一次将cur的其中一位置为1
                int next = cur | (1 << i);
                if (!visited[next]) {
                    stack.push(next);
                    visited[next] = true;
                }
            }
        }
        return count;
    }

    /**
     * 如 nums =[1,2,3]，那么各个元素前面添加的符号组合就有 2^3=8
     * 所以只需要遍历这8次就可以知道有多少种组合的和为S了
     */
    public static int findTargetSumWays2(int[] nums, int S) {
        int count = 0;
        int len = (int) Math.pow(2, nums.length);
        for (int i = 0; i < len; i++) {
            int sum = getSum(nums, i);
            if (sum == S) {
                count++;
            }
        }
        return count;
    }

    public static int findTargetSumWays3(int[] nums, int S) {
        int count = 0;
        int len = (int) Math.pow(2, nums.length - 1);
        // 因为 getSum(nums, i) 与 getSum(nums, nums.length - 1 - i) 互为相反数，所以可以只算一半
        // 特别注意的是，如果S==0的话，计数是加2
        int step = S == 0 ? 2 : 1;
        for (int i = 0; i < len; i++) {
            int sum = getSum(nums, i);
            if (sum == S || sum == -S) {
                count = count + step;
            }
        }
        return count;
    }

    /**
     * symbol的二进制表示nums数组上各个元素前面添加的符号
     * `0`为`+`，`1`为`-`。nums与symbol运算后的和
     * 如 nums =[1,2,3]
     * 当symbol = 000 时，sum = +1+2+3 = 6
     * 当symbol = 001 时，sum = -1+2+3 = 4
     * 当symbol = 010 时，sum = +1-2+3 = 2
     * 当symbol = 100 时，sum = +1+2-3 = 0
     */
    public static int getSum(int[] nums, int symbol) {
        int sum = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] != 0) {
                // 获取第i位的符号，0为+，1为-
                sum += (symbol >> i & 1) == 0 ? nums[i] : -nums[i];
            }
        }
        return sum;
    }

    public static int findTargetSumWays4(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 最大的和sum比S小，或者 sum和S 奇偶性不一致
        if (Math.abs(S) > sum || (sum + S) % 2 != 0) {
            return 0;
        }
        int step = S == 0 ? 2 : 1;
        int count = sum == S || sum == -S ? step : 0;
        int len = (int) Math.pow(2, nums.length - 1);
        for (int i = 1; i < len; i++) {
            // 通过上一步的symbol和sum，快速求出这一步的sum
            sum = getSum(nums, i - 1, sum, i);
            if (sum == S || sum == -S) {
                count = count + step;
            }
        }
        return count;
    }

    /**
     * sum为nums所有元素的和，对应的symbol=0。利用sum，再重新计算那些变动的位置的和，
     * 即可快速得出所求sum
     */
    public static int getSum(int[] nums, int symbol, int sum) {
        // 前0~invalid位无效，需要重新计算
        int invalid = Math.min(symbol >> 1, nums.length - 1);
        for (int i = 0; i <= invalid; i++) {
            // 获取第i位的符号，0为+，1为-
            // 如果第i位符号为+，则无需重新计算与该元素的和
            // 如果第i位符号为-，要先减去该元素，再加上-nums[i]。即需要减去2*nums[i]
            if (nums[i] != 0 && (symbol >> i & 1) != 0) {
                sum = sum - (nums[i] << 1);
            }
        }
        return sum;
    }

    /**
     * 已知sum为nums与symbol运算后的和。现求nums与newSymbol运算后的和
     */
    public static int getSum(int[] nums, int symbol, int sum, int newSymbol) {
        // 前0~invalid位无效，需要重新计算
        final int diff = symbol ^ newSymbol;
        final int invalid = Math.min(diff >> 1, nums.length - 1);
        for (int i = 0; i <= invalid; i++) {
            // 获取第i位的符号，0为相同，1为不同，需重新计算与该元素的和
            if (nums[i] != 0 && (diff >> i & 1) != 0) {
                if ((symbol >> i & 1) == 0) {
                    // symbol第i位为0，newSymbol第i位为1
                    // sum要先减去该元素，再减去nums[i]。即需要减去2*nums[i]
                    sum = sum - (nums[i] << 1);
                } else {
                    // symbol第i位为1，newSymbol第i位为0
                    // sum要先加上nums[i]，再加上-nums[i]。即需要加上2*nums[i]
                    sum = sum + (nums[i] << 1);
                }
            }
        }
        return sum;
    }
}
