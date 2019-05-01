package leetcode.queue;

import java.util.*;
/*
 * Return the length of the shortest path between root and target node.
 */
//如代码所示，在每一轮中，队列中的结点是等待处理的结点。
//在每个更外一层的 while 循环之后，我们距离根结点更远一步。变量 step 指示从根结点到我们正在访问的当前结点的距离。
/*    int BFS(Node root, Node target) {
        Queue<Node> queue;  // store all nodes which are waiting to be processed
        int step = 0;       // number of steps neeeded from root to current node
        // initialize
        add root to queue;
        // BFS
        while (queue is not empty){
            step = step + 1;
            // iterate the nodes which are already in the queue
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node cur = the first node in queue;
                return step if cur is target;
                for (Node next : the neighbors of cur){
                    add next to queue;
                }
                remove the first node from queue;
            }
        }
        return -1;          // there is no path from root to target
    }*/

/*
 * Return the length of the shortest path between root and target node.
 */
// 有时，确保我们永远不会访问一个结点两次很重要。否则，我们可能陷入无限循环。
// 如果是这样，我们可以在上面的代码中添加一个哈希集来解决这个问题。这是修改后的伪代码
/*    int BFS(Node root, Node target) {
        Queue<Node> queue;  // store all nodes which are waiting to be processed
        Set<Node> used;     // store all the used nodes
        int step = 0;       // number of steps neeeded from root to current node
        // initialize
        add root to queue;
        add root to used;
        // BFS
        while (queue is not empty) {
            step = step + 1;
            // iterate the nodes which are already in the queue
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node cur = the first node in queue;
                return step if cur is target;
                for (Node next : the neighbors of cur) {
                    if (next is not in used) {
                        add next to queue;
                        add next to used;
                    }
                }
                remove the first node from queue;
            }
        }
        return -1;          // there is no path from root to target
    }*/

/**
 * 广度优先搜索（BFS）是一种遍历或搜索数据结构（如树或图）的算法。
 */
public class BFSSolutions {

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
     *
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0, row = grid.length; i < row; i++) {
            for (int j = 0, col = grid[0].length; j < col; j++) {
                if (grid[i][j] == '1') {
                    mark(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    // 标记出(i,j)所在的岛屿范围
    private static void mark(char[][] grid, int i, int j) {
        final int row = grid.length;
        final int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = '*';// 标记该节点已经添加过
        int[] node;
        while (!queue.isEmpty()) {
            for (int k = 0, length = queue.size(); k < length; k++) {
                node = queue.poll();
                i = node[0];
                j = node[1];
                // 遍历邻接点，判断其是否已遍历。需注意要对添加的节点做标记，否则会出现重复添加的情况
                if (i > 0 && grid[i - 1][j] == '1') {
                    grid[i - 1][j] = '*';
                    queue.offer(new int[]{i - 1, j});
                }
                if (i + 1 < row && grid[i + 1][j] == '1') {
                    grid[i + 1][j] = '*';
                    queue.offer(new int[]{i + 1, j});
                }
                if (j > 0 && grid[i][j - 1] == '1') {
                    grid[i][j - 1] = '*';
                    queue.offer(new int[]{i, j - 1});
                }
                if (j + 1 < col && grid[i][j + 1] == '1') {
                    grid[i][j + 1] = '*';
                    queue.offer(new int[]{i, j + 1});
                }
            }
        }
    }

    /**
     * https://leetcode-cn.com/problems/open-the-lock/
     * Q:你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
     * <p>
     * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
     * <p>
     * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
     * <p>
     * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
     * 输出：6
     * 解释：
     * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
     * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
     * 因为当拨动到 "0102" 时这个锁就会被锁定。
     *
     * @param deadends
     * @param target
     * @return
     */
    public static int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(deadends.length);
        Collections.addAll(visited, deadends);
        if (visited.contains("0000")) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        visited.add("0000");
        int step = 0;
        // BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String cur = queue.peek();
                // 当前节点就是target，则直接返回
                if (cur.equals(target)) {
                    return step;
                }
                // 1.将当前节点值每一位+1,-1
                // 2.判断是否在visited，否则添加到queue
                char[] chars = cur.toCharArray();
                char curChar; // 记录当前位置的char，用来恢复使用
                String nextStr;//记录生成的下一个字符串
                for (int j = 0; j < chars.length; j++) {
                    curChar = chars[j];
                    chars[j] = (char) ((curChar - '0' + 1) % 10 + '0');
                    nextStr = new String(chars);
                    if (!visited.contains(nextStr)) {
                        queue.add(nextStr);
                        visited.add(nextStr);
                    }
                    chars[j] = (char) ((curChar - '0' + 9) % 10 + '0');
                    nextStr = new String(chars);
                    if (!visited.contains(nextStr)) {
                        queue.add(nextStr);
                        visited.add(nextStr);
                    }
                    // 恢复
                    chars[j] = curChar;
                }
                queue.remove();
            }
            step = step + 1;
        }
        return -1;
    }

    /**
     * https://leetcode-cn.com/problems/perfect-squares/description/
     * Q:完全平方数
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * <p>
     * 示例 1:
     * <p>
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     * A:
     * 1.计算n与最大平方数到1的差值
     * 2.若差值为0，则证明n为平方数，可直接返回step
     * 3.若差值不为0，则将其入队
     *
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        int step = 0;
        queue.add(n);
        while (!queue.isEmpty()) {
            step = step + 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                // 计算节点的平方根，取整。如cur=12则取平方根3
                int sqrt = (int) Math.sqrt(cur);
                // 如果是平方数，则直接返回step
                if (cur == sqrt * sqrt) {
                    return step;
                }
                // 12-3*3=3, 12-2*2=8, 12-1*1=11，下面分别将3，8，11入队
                for (int j = sqrt; j >= 1; j--) {
                    // 计算cur减去完全平方数，如果没出现过，则入队
                    int left = cur - j * j;
                    queue.add(left);
                }
            }
        }
        return -1;
    }

    public static int numSquares2(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int step = 0;
        queue.add(n);
        visited[n] = true;
        while (!queue.isEmpty()) {
            step = step + 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                // 计算节点的平方根，取整。如cur=12则取平方根3
                int sqrt = (int) Math.sqrt(cur);
                // 如果是平方数，则直接返回step
                if (cur == sqrt * sqrt) {
                    return step;
                }
                // 12-3*3=3, 12-2*2=8, 12-1*1=11，下面分别将3，8，11入队
                for (int j = sqrt; j >= 1; j--) {
                    // 计算cur减去完全平方数，如果没出现过，则入队
                    int left = cur - j * j;
                    if (!visited[left]) {
                        visited[left] = true;
                        queue.add(left);
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 动态规划
     * 定义一个函数f(n)表示我们要求的解。f(n)的求解过程为：
     * f(n) = 1 + min{
     * f(n-1^2), f(n-2^2), f(n-3^2), f(n-4^2), ... , f(n-k^2) //(k为满足k^2<=n的最大的k)
     * }
     */
    public static int numSquares3(int n) {
        int[] results = new int[n + 1];
        numSquares(n, results);
        return results[n];
    }

    public static int numSquares(int n, int[] results) {
        // 已经计算过了，直接返回
        if (results.length > n && results[n] != 0) {
            return results[n];
        }
        int min, sqrt;
        for (int i = 1; i <= n; i++) {
            sqrt = (int) Math.sqrt(i);
            min = Integer.MAX_VALUE;
            for (int j = 1; j <= sqrt; j++) {
                min = Math.min(min, numSquares(i - j * j, results));
            }
            results[i] = min + 1;
        }
        return results[n];
    }

    /**
     * https://leetcode-cn.com/problems/01-matrix/
     * 542. 01 矩阵
     */
    public static int[][] updateMatrix(int[][] matrix) {
        final int row = matrix.length;
        final int col = matrix[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = getDistance(matrix, i, j);
            }
        }
        return result;
    }

    // 计算matrix[i][j]到最近的 0 的距离
    public static int getDistance(int[][] matrix, int i, int j) {
        if (matrix[i][j] == 0) {
            return 0;
        }
        final int row = matrix.length;
        final int col = matrix[0].length;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> used = new HashSet<>();
        int step = -1;
        // 高16位存放i，低16位存放j
        int combine = (i << 16) | j;
        queue.offer(combine);
        used.add(combine);
        while (queue.size() > 0) {
            step++;
            for (int k = 0, size = queue.size(); k < size; k++) {
                combine = queue.poll();
                i = combine >> 16; // 获取高16位
                j = combine & 0xffff; // 获取低16位
                if (matrix[i][j] == 0) {
                    return step;
                }
                // 左
                if (i > 0) {
                    addToQueue(queue, used, i - 1, j);
                }
                // 右
                if (i + 1 < row) {
                    addToQueue(queue, used, i + 1, j);
                }
                // 上
                if (j > 0) {
                    addToQueue(queue, used, i, j - 1);
                }
                // 下
                if (j + 1 < col) {
                    addToQueue(queue, used, i, j + 1);
                }
            }
        }
        return step;
    }

    private static boolean addToQueue(Queue<Integer> queue, Set<Integer> used, int i, int j) {
        // 高16位存放i，低16位存放j
        int combine = (i << 16) | j;
        if (!used.contains(combine)) {
            used.add(combine);
            queue.offer(combine);
            return true;
        }
        return false;
    }

    public static int[][] updateMatrix2(int[][] matrix) {
        final int row = matrix.length;
        final int col = matrix[0].length;
        int[][] result = new int[row][col];
        Queue<Integer> queue = new LinkedList<>();
        int i, j;
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    // 将所有 0 元素作为 BFS 第一层
                    // 高16位存放i，低16位存放j
                    queue.add(combine(i, j));
                } else {
                    // 设置一个不可能的值，如果这里设置Integer.MAX_VALUE的话，注意下面的运算可能会溢出
                    result[i][j] = row + col;
                }
            }
        }

        int cur;
        while (queue.size() > 0) {
            cur = queue.poll();
            i = cur >> 16; // 获取高16位
            j = cur & 0xffff; // 获取低16位
            // 如果matrix[i - 1][j]距离0的距离大于matrix[i][j] + 1
            // 则更新result[i - 1][j]，并将(i - 1,j)加入队列进行BFS
            // 因为matrix[i - 1][j]还有可能有更小的值
            if (i > 0 && result[i - 1][j] > result[i][j] + 1) {
                result[i - 1][j] = result[i][j] + 1;
                queue.offer(combine(i - 1, j));
            }
            if (i + 1 < row && result[i + 1][j] > result[i][j] + 1) {
                result[i + 1][j] = result[i][j] + 1;
                queue.offer(combine(i + 1, j));
            }
            if (j > 0 && result[i][j - 1] > result[i][j] + 1) {
                result[i][j - 1] = result[i][j] + 1;
                queue.offer(combine(i, j - 1));
            }
            if (j + 1 < col && result[i][j + 1] > result[i][j] + 1) {
                result[i][j + 1] = result[i][j] + 1;
                queue.offer(combine(i, j + 1));
            }
        }
        return result;
    }

    private static int combine(int i, int j) {
        return (i << 16) | j;
    }

    // 此方法会改变matrix内元素的值
    // 将所有 0 元素作为 BFS 第一层
    public static int[][] updateMatrix3(int[][] matrix) {
        final int row = matrix.length;
        final int col = matrix[0].length;
        Queue<Integer> queue = new LinkedList<>();
        int i, j;
        // 将所有 0 元素作为 BFS 第一层
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    // 高16位存放i，低16位存放j
                    queue.add((i << 16) | j);
                } else {
                    // 设置一个不可能的值，如果这里设置Integer.MAX_VALUE的话，注意下面的运算可能会溢出
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[] xDirection = {-1, 0, 1, 0};
        int[] yDirection = {0, -1, 0, 1};
        int cur, m, n;
        while (queue.size() > 0) {
            cur = queue.poll();
            i = cur >> 16; // 获取高16位
            j = cur & 0xffff; // 获取低16位
            for (int k = 0; k < 4; k++) {
                m = i + xDirection[k];
                n = j + yDirection[k];
                // 如果matrix[m][n]距离0的距离大于matrix[i][j] + 1
                // 则更新matrix[m][n]，并将(m,n)加入队列进行BFS
                // 因为matrix[m][n]还有可能有更小的值
                if (m >= 0 && m < row && n >= 0 && n < col && matrix[m][n] - 1 > matrix[i][j]) {
                    matrix[m][n] = matrix[i][j] + 1;
                    queue.offer((m << 16) | n);
                }
            }
        }
        return matrix;
    }
}
