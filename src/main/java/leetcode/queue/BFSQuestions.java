package leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;
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
public class BFSQuestions {

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

    // 套用BFS模版
    private static void merge(char[][] grid, int i, int j) {
        final int row = grid.length;
        final int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = '*';// 标记该节点已经添加过
        int[] node;
        // BFS
        while (!queue.isEmpty()) {
            // iterate the nodes which are already in the queue
            for (int k = 0, length = queue.size(); k < length; k++) {
                node = queue.poll();
                i = node[0];
                j = node[1];
                // 向四周搜索岛屿，需注意要对已添加的节点做标记，否则会出现重复添加的情况
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
}
