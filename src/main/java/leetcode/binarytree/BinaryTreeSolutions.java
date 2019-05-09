package leetcode.binarytree;

import java.util.*;

public class BinaryTreeSolutions {

    /**
     * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
     * Q:二叉树的前序遍历
     * 给定一个二叉树，返回它的 前序 遍历。
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     * Q:前序遍历首先访问根节点，然后遍历左子树，最后遍历右子树
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    public static void preorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        // 先根
        result.add(root.val);
        // 遍历左
        if (root.left != null) {
            preorderTraversal(root.left, result);
        }
        // 遍历右
        if (root.right != null) {
            preorderTraversal(root.right, result);
        }
    }

    /**
     * 先序遍历 迭代算法
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            result.add(node.val); // 先根
            if (node.right != null) {
                stack.push(node.right); // 将右子树入栈
            }
            if (node.left != null) {
                node = node.left; // 遍历左子树
            } else {
                // 左子树遍历完毕，开始遍历右子树
                if (stack.isEmpty()) {
                    break;// 遍历完毕
                } else {
                    node = stack.pop(); // 将右子树出栈, 继续右子树的先序遍历
                }
            }
        }
        return result;
    }

    public static List<Integer> preorderTraversal3(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            result.add(node.val); // 先根
            if (node.right != null) {
                stack.push(node.right); // 将右子树入栈
            }
            if (node.left != null) {
                stack.push(node.left); // 将左子树入栈
            }
        }
        return result;
    }

    public static List<Integer> preorderTraversal4(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                result.add(node.val); // 先根
                stack.push(node); // 将根入栈
                node = node.left; // 遍历左子树
            } else {
                node = stack.pop(); // 将根出栈, 遍历右子树
                node = node.right;
            }
        }
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
     * Q:中序遍历二叉树
     * 给定一个二叉树，返回它的中序遍历。
     * A:中序遍历是先遍历左子树，然后访问根节点，然后遍历右子树
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        // 遍历左子树
        List<Integer> left = inorderTraversal(root.left);
        if (!left.isEmpty()) {
            result.addAll(left);
        }
        // 遍历根
        result.add(root.val);
        // 遍历右子树
        List<Integer> right = inorderTraversal(root.right);
        if (!right.isEmpty()) {
            result.addAll(right);
        }
        return result;
    }

    /**
     * 中序遍历 迭代算法
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node); // 将根节点入栈
                node = node.left; // 继续遍历左子树
            } else {
                // 左子树遍历完毕
                node = stack.pop();// 将根节点出栈
                result.add(node.val);// 遍历根
                node = node.right; // 遍历右子树
            }
        }
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
     * Q:二叉树的后序遍历
     * 给定一个二叉树，返回它的 后序遍历。
     * A:后序遍历是先遍历左子树，然后遍历右子树，最后访问树的根节点
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    public static void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        // 遍历左子树
        postorderTraversal(root.left, result);
        // 遍历右子树
        postorderTraversal(root.right, result);
        // 遍历根
        result.add(root.val);
    }

    /**
     * https://www.jianshu.com/p/456af5480cee
     * 后序遍历 迭代算法
     * A:后序遍历在决定是否可以输出当前节点的值的时候，需要考虑其左右子树是否都已经遍历完成。
     * <p>
     * 所以需要设置一个lastVisit游标。
     * <p>
     * 若lastVisit等于当前考查节点的右子树，表示该节点的左右子树都已经遍历完成，则可以输出当前节点。
     * <p>
     * 并把lastVisit节点设置成当前节点，将当前游标节点node设置为空，下一轮就可以访问栈顶元素。
     * <p>
     * 否者，需要接着考虑右子树，node = node.right。
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root, lastVisit = null;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node); // 将根节点入栈
                node = node.left; // 继续遍历左子树
            } else {
                //查看当前栈顶元素
                node = stack.peek();
                //如果其右子树也为空，或者右子树已经访问
                //则可以直接输出当前节点的值
                if (node.right == null || lastVisit == node.right) {
                    result.add(node.val);
                    lastVisit = stack.pop();
                    node = null;
                } else {
                    //继续遍历右子树
                    node = node.right;
                }
            }
        }
        return result;
    }

    /**
     * 采用类似先序遍历的方法，先遍历根结点，然后右子树，最后左子树
     * 最后把遍历的序列逆转即得到了后序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal3(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            result.add(node.val); // 先根
            if (node.left != null) {
                stack.push(node.left); // 将左子树入栈
            }
            if (node.right != null) {
                stack.push(node.right); // 将右子树入栈
            }
        }
        Collections.reverse(result);
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
     * Q:给定一个二叉树，返回其按层次遍历的节点值。
     * （即逐层地，从左到右访问所有节点）。
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>(); // 保存要遍历的节点
        queue.offer(root); // 添加根节点
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> levelValues; // 记录每一层的值
        TreeNode node;
        // 队列中没有遍历的节点，则遍历结束
        while (queue.size() > 0) {
            // 每一层的节点数等于当前队列的大小
            levelValues = new ArrayList<>(queue.size());
            result.add(levelValues);
            // 遍历某一层，访问该层所有节点，并将该层的子结点入队
            for (int i = queue.size(); i > 0; i--) {
                node = queue.poll();
                levelValues.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(root, 0, result);
        return result;
    }

    /**
     * 访问第 level 层的 root节点
     *
     * @param root
     * @param level
     * @param result
     */
    public static void levelOrder(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        // 记录每一层的值
        List<Integer> levelValues;
        // 如果当前访问的层数大于等于 result 的大小，则表示是第一次访问该层
        if (level >= result.size()) {
            levelValues = new ArrayList<>();
            result.add(levelValues);
        } else {
            levelValues = result.get(level);
        }
        // 访问根
        levelValues.add(root.val);
        // 对左子树层次遍历
        if (root.left != null) {
            levelOrder(root.left, level + 1, result);
        }
        // 对右子树层次遍历
        if (root.right != null) {
            levelOrder(root.right, level + 1, result);
        }
    }

    /**
     * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/
     * Q: 二叉树的最大深度
     * 给定一个二叉树，找出其最大深度。
     * <p>
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 使用 BFS 策略访问每个结点，同时在每次访问时更新最大深度
     */
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>(); // 保存要遍历的节点
        queue.offer(root); // 添加根节点
        int maxDepth = 0;
        TreeNode node;
        // 队列中没有遍历的节点，则遍历结束
        while (queue.size() > 0) {
            // 每一层的节点数等于当前队列的大小
            // 遍历某一层，将该层的子结点入队
            for (int i = queue.size(); i > 0; i--) {
                node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }

    /**
     * https://leetcode-cn.com/problems/symmetric-tree/
     * Q:对称二叉树
     * <p>
     * 给定一个二叉树，检查它是否是镜像对称的。
     * <p>
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetric(root.left, root.right);
    }

    // 判断两棵树是否对称
    private static boolean symmetric(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }
        if (tree1.val != tree2.val) {
            return false;
        }
        return symmetric(tree1.left, tree2.right) && symmetric(tree1.right, tree2.left);
    }

    /**
     * 对称二叉树 迭代方法
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        TreeNode p, q;
        while (list.size() > 0) {
            // 遍历该层，并添加该层的子结点
            for (int i = list.size(); i > 0; i--) {
                p = list.remove(0);
                if (p != null) {
                    // 子结点为空也需添加，因为需要知道顺序
                    list.add(p.left);
                    list.add(p.right);
                }
            }
            // 拿该层第一个和最后一个结点对比，看看是否对称
            for (int i = 0, length = list.size(); i < length / 2; i++) {
                p = list.get(i);
                q = list.get(length - 1 - i);
                if ((p == null && q != null) || (p != null && q == null) ||
                        (p != null && q != null && p.val != q.val)) {
                    // 不对称则直接返回
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * https://leetcode-cn.com/problems/path-sum/
     * Q:给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * A:用sum-当前结点值，如果相等，则找到路径
     *
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        // 必须是根节点到叶子节点的路径
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> sumStack = new LinkedList<>();
        stack.push(root);
        sumStack.push(sum);

        TreeNode node = root;
        int curSum = sum;
        while (stack.size() > 0) {
            node = stack.pop();
            curSum = sumStack.pop();
            // 找到值为curSum的叶子节点，则返回true
            if (node.left == null && node.right == null && node.val == curSum) {
                return true;
            }

            // 将左子树和剩余的sum入栈
            if (node.left != null) {
                stack.push(node.left);
                sumStack.push(curSum - node.val);
            }
            // 将右子树和剩余的sum入栈
            if (node.right != null) {
                stack.push(node.right);
                sumStack.push(curSum - node.val);
            }
        }
        return false;
    }

    public static boolean hasPathSum3(TreeNode root, int sum) {
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> sumStack = new LinkedList<>();
        TreeNode node = root;
        int curSum = 0; // 根节点到某个节点的路径上所有节点的和
        while (node != null || stack.size() > 0) {
            if (node != null) {
                // 计算节点和
                curSum = curSum + node.val;
                if (node.left == null && node.right == null && sum == curSum) {
                    // 找到curSum等于sum的叶子节点，则返回true
                    return true;
                }
                stack.push(node); // 将根节点进栈
                sumStack.push(curSum); // 将curSum进栈
                node = node.left; // 继续遍历左子树
            } else {
                node = stack.pop(); // 将根节点出栈
                node = node.right; // 遍历右子树
                curSum = sumStack.pop();// 恢复当时的curSum
            }
        }
        return false;
    }

    public static boolean hasPathSum4(TreeNode root, int sum) {
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> sumStack = new LinkedList<>();
        TreeNode node = root;
        int curSum = 0; // 根节点到某个节点的路径上所有节点的和
        while (node != null || stack.size() > 0) {
            if (node != null) {
                // 计算节点和
                curSum = curSum + node.val;
                if (node.right != null) {
                    stack.push(node.right); // 将右子树进栈
                    sumStack.push(curSum); // 将curSum进栈
                } else if (node.left == null && sum == curSum) {
                    // 找到curSum等于sum的叶子节点，则返回true
                    return true;
                }
                node = node.left; // 继续遍历左子树
            } else {
                node = stack.pop(); // 将右子树出栈, 遍历右子树
                curSum = sumStack.pop();// 恢复当时的curSum
            }
        }
        return false;
    }

    public static boolean hasPathSum5(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>(); // 保存要遍历的节点
        Queue<Integer> sumQueue = new LinkedList<>();
        queue.offer(root); // 添加根节点
        sumQueue.offer(root.val); // 添加根节点
        TreeNode node;
        int curSum; // 根节点到某个节点的路径上所有节点的和
        // 队列中没有遍历的节点，则遍历结束
        while (queue.size() > 0) {
            // 访问节点和对应的节点和
            node = queue.poll();
            curSum = sumQueue.poll();
            // 找到curSum等于sum的叶子节点，则返回true
            if (node.left == null && node.right == null && sum == curSum) {
                return true;
            }
            // 将子结点和对应的节点和入队
            if (node.left != null) {
                queue.offer(node.left);
                sumQueue.offer(curSum + node.left.val);
            }
            if (node.right != null) {
                queue.offer(node.right);
                sumQueue.offer(curSum + node.right.val);
            }
        }
        return false;
    }

    public static boolean hasPathSum6(TreeNode root, int sum) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root, lastVisit = null;
        int curSum = 0; // 根节点到某个节点的路径上所有节点的和
        while (node != null || stack.size() > 0) {
            if (node != null) {
                curSum += node.val; // 计算路径上的节点和
                stack.push(node); // 将根节点入栈
                node = node.left; // 继续遍历左子树
            } else {
                //查看当前栈顶元素
                node = stack.peek();
                //如果其右子树也为空，或者右子树已经访问
                //则可以直接输出当前节点的值
                if (node.right == null || lastVisit == node.right) {
                    // 找到curSum等于sum的叶子节点，则返回true
                    if (node.left == null && node.right == null && curSum == sum) {
                        return true;
                    }
                    curSum -= node.val; // 恢复路径上的节点和
                    lastVisit = stack.pop(); // 节点出栈
                    node = null;
                } else {
                    //继续遍历右子树
                    node = node.right;
                }
            }
        }
        return false;
    }

    /**
     * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/comments/
     * 106. 从中序与后序遍历序列构造二叉树
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    /**
     * 根据inorder[iStart..iEnd]和postorder[pStart..pEnd]构造二叉树
     */
    public static TreeNode buildTree(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }
        // 后序遍历序列的最后一个元素必为根
        int rootVal = postorder[pEnd];
        TreeNode root = new TreeNode(rootVal);
        // 在中序遍历序列中找到根（题目已假设树中没有重复的元素）
        // 因为中序遍历的顺序是[左，根，右]，所以根左边的就是左子树，右边的就是右子树
        int index = iStart;
        while (index <= iEnd && inorder[index] != rootVal) {
            index++;
        }
        // 递归构造左子树
        // 在中序遍历中，inorder[iStart, index - 1]为左子树的部分
        // 在后序遍历中，postorder[pStart, pStart + (index - 1 - iStart)]为左子树的部分
        // (index - 1 - iStart)为中序遍历中，左子树节点的个数
        root.left = buildTree(inorder, iStart, index - 1, postorder, pStart, pStart + (index - 1 - iStart));
        // 递归构造右子树
        // 在中序遍历中，inorder[index + 1, iEnd]为右子树的部分
        // 在后序遍历中，postorder[pStart + (index - iStart), pEnd - 1]为左子树的部分
        root.right = buildTree(inorder, index + 1, iEnd, postorder, pStart + (index - iStart), pEnd - 1);
        return root;
    }

    public static TreeNode buildTree2(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, postorder, 0, postorder.length);
    }

    /**
     * 根据inorder[iStart..iStart+len-1]和postorder[pStart..pStart+len-1]构造二叉树
     */
    public static TreeNode buildTree(int[] inorder, int iStart, int[] postorder, int pStart, int len) {
        if (len == 0) {
            return null;
        }
        // 后序遍历序列的最后一个元素必为根
        int rootVal = postorder[pStart + len - 1];
        TreeNode root = new TreeNode(rootVal);
        if (len == 1) {
            return root;
        }
        // 在中序遍历序列中找到根（题目已假设树中没有重复的元素）
        // 因为中序遍历的顺序是[左，根，右]，所以根左边的就是左子树，右边的就是右子树
        int index = iStart;
        while (index <= iStart + len - 1 && inorder[index] != rootVal) {
            index++;
        }
        // 递归构造左子树
        root.left = buildTree(inorder, iStart, postorder, pStart, index - iStart);
        // 递归构造右子树
        root.right = buildTree(inorder, index + 1, postorder, pStart + (index - iStart), len - 1 - (index - iStart));
        return root;
    }
}