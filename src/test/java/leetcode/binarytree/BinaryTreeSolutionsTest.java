package leetcode.binarytree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BinaryTreeSolutionsTest {

    @Test
    public void preorderTraversal() {
        TreeNode root;
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Assert.assertEquals(Arrays.asList(1, 2, 3), BinaryTreeSolutions.preorderTraversal(root));
        Assert.assertEquals(Arrays.asList(1, 2, 3), BinaryTreeSolutions.preorderTraversal2(root));
        Assert.assertEquals(Arrays.asList(1, 2, 3), BinaryTreeSolutions.preorderTraversal3(root));
        Assert.assertEquals(Arrays.asList(1, 2, 3), BinaryTreeSolutions.preorderTraversal4(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Assert.assertEquals(Arrays.asList(1, 2, 4, 3, 5, 6), BinaryTreeSolutions.preorderTraversal(root));
        Assert.assertEquals(Arrays.asList(1, 2, 4, 3, 5, 6), BinaryTreeSolutions.preorderTraversal2(root));
        Assert.assertEquals(Arrays.asList(1, 2, 4, 3, 5, 6), BinaryTreeSolutions.preorderTraversal3(root));
        Assert.assertEquals(Arrays.asList(1, 2, 4, 3, 5, 6), BinaryTreeSolutions.preorderTraversal4(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Assert.assertEquals(Arrays.asList(1, 2, 4, 5, 3, 6), BinaryTreeSolutions.preorderTraversal(root));
        Assert.assertEquals(Arrays.asList(1, 2, 4, 5, 3, 6), BinaryTreeSolutions.preorderTraversal2(root));
        Assert.assertEquals(Arrays.asList(1, 2, 4, 5, 3, 6), BinaryTreeSolutions.preorderTraversal3(root));
        Assert.assertEquals(Arrays.asList(1, 2, 4, 5, 3, 6), BinaryTreeSolutions.preorderTraversal4(root));
    }

    @Test
    public void inorderTraversal() {
        TreeNode root;
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Assert.assertEquals(Arrays.asList(1, 3, 2), BinaryTreeSolutions.inorderTraversal(root));
        Assert.assertEquals(Arrays.asList(1, 3, 2), BinaryTreeSolutions.inorderTraversal2(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Assert.assertEquals(Arrays.asList(4, 2, 1, 5, 3, 6), BinaryTreeSolutions.inorderTraversal(root));
        Assert.assertEquals(Arrays.asList(4, 2, 1, 5, 3, 6), BinaryTreeSolutions.inorderTraversal2(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Assert.assertEquals(Arrays.asList(4, 2, 5, 1, 3, 6), BinaryTreeSolutions.inorderTraversal(root));
        Assert.assertEquals(Arrays.asList(4, 2, 5, 1, 3, 6), BinaryTreeSolutions.inorderTraversal2(root));
    }

    @Test
    public void postorderTraversal() {
        TreeNode root;
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Assert.assertEquals(Arrays.asList(3, 2, 1), BinaryTreeSolutions.postorderTraversal(root));
        Assert.assertEquals(Arrays.asList(3, 2, 1), BinaryTreeSolutions.postorderTraversal2(root));
        Assert.assertEquals(Arrays.asList(3, 2, 1), BinaryTreeSolutions.postorderTraversal3(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Assert.assertEquals(Arrays.asList(4, 2, 5, 6, 3, 1), BinaryTreeSolutions.postorderTraversal(root));
        Assert.assertEquals(Arrays.asList(4, 2, 5, 6, 3, 1), BinaryTreeSolutions.postorderTraversal2(root));
        Assert.assertEquals(Arrays.asList(4, 2, 5, 6, 3, 1), BinaryTreeSolutions.postorderTraversal3(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Assert.assertEquals(Arrays.asList(4, 5, 2, 6, 3, 1), BinaryTreeSolutions.postorderTraversal(root));
        Assert.assertEquals(Arrays.asList(4, 5, 2, 6, 3, 1), BinaryTreeSolutions.postorderTraversal2(root));
        Assert.assertEquals(Arrays.asList(4, 5, 2, 6, 3, 1), BinaryTreeSolutions.postorderTraversal3(root));
    }

    @Test
    public void levelOrder() {
        TreeNode root;
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Assert.assertEquals(Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3)),
                BinaryTreeSolutions.levelOrder(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Assert.assertEquals(Arrays.asList(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6)),
                BinaryTreeSolutions.levelOrder(root));
        Assert.assertEquals(Arrays.asList(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6)),
                BinaryTreeSolutions.levelOrder2(root));

        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Assert.assertEquals(Arrays.asList(Arrays.asList(3), Arrays.asList(9, 20), Arrays.asList(15, 7)),
                BinaryTreeSolutions.levelOrder(root));
        Assert.assertEquals(Arrays.asList(Arrays.asList(3), Arrays.asList(9, 20), Arrays.asList(15, 7)),
                BinaryTreeSolutions.levelOrder2(root));
    }

    @Test
    public void maxDepth() {
        TreeNode root;
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(4);
        Assert.assertEquals(4, BinaryTreeSolutions.maxDepth(root));
        Assert.assertEquals(4, BinaryTreeSolutions.maxDepth2(root));

        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Assert.assertEquals(3, BinaryTreeSolutions.maxDepth(root));
        Assert.assertEquals(3, BinaryTreeSolutions.maxDepth2(root));
    }

    @Test
    public void isSymmetric() {
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        Assert.assertEquals(true, BinaryTreeSolutions.isSymmetric(root));
        Assert.assertEquals(true, BinaryTreeSolutions.isSymmetric2(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        Assert.assertEquals(false, BinaryTreeSolutions.isSymmetric(root));
        Assert.assertEquals(false, BinaryTreeSolutions.isSymmetric2(root));
    }

    @Test
    public void hasPathSum() {
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        Assert.assertEquals(false, BinaryTreeSolutions.hasPathSum(root, 1));
        Assert.assertEquals(true, BinaryTreeSolutions.hasPathSum(root, 3));
        Assert.assertEquals(false, BinaryTreeSolutions.hasPathSum2(root, 1));
        Assert.assertEquals(true, BinaryTreeSolutions.hasPathSum2(root, 3));
        Assert.assertEquals(false, BinaryTreeSolutions.hasPathSum3(root, 1));
        Assert.assertEquals(true, BinaryTreeSolutions.hasPathSum3(root, 3));
        Assert.assertEquals(false, BinaryTreeSolutions.hasPathSum4(root, 1));
        Assert.assertEquals(true, BinaryTreeSolutions.hasPathSum4(root, 3));
        Assert.assertEquals(false, BinaryTreeSolutions.hasPathSum5(root, 1));
        Assert.assertEquals(true, BinaryTreeSolutions.hasPathSum5(root, 3));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Assert.assertEquals(true, BinaryTreeSolutions.hasPathSum(root, 8));
        Assert.assertEquals(false, BinaryTreeSolutions.hasPathSum(root, 11));
        Assert.assertEquals(true, BinaryTreeSolutions.hasPathSum2(root, 8));
        Assert.assertEquals(false, BinaryTreeSolutions.hasPathSum2(root, 11));
        Assert.assertEquals(true, BinaryTreeSolutions.hasPathSum3(root, 8));
        Assert.assertEquals(false, BinaryTreeSolutions.hasPathSum3(root, 11));
        Assert.assertEquals(true, BinaryTreeSolutions.hasPathSum4(root, 8));
        Assert.assertEquals(false, BinaryTreeSolutions.hasPathSum4(root, 11));
        Assert.assertEquals(true, BinaryTreeSolutions.hasPathSum5(root, 8));
        Assert.assertEquals(false, BinaryTreeSolutions.hasPathSum5(root, 11));

        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        Assert.assertEquals(true, BinaryTreeSolutions.hasPathSum(root, 22));
        Assert.assertEquals(false, BinaryTreeSolutions.hasPathSum(root, 23));
        Assert.assertEquals(true, BinaryTreeSolutions.hasPathSum2(root, 22));
        Assert.assertEquals(false, BinaryTreeSolutions.hasPathSum2(root, 23));
        Assert.assertEquals(true, BinaryTreeSolutions.hasPathSum3(root, 22));
        Assert.assertEquals(false, BinaryTreeSolutions.hasPathSum3(root, 23));
        Assert.assertEquals(true, BinaryTreeSolutions.hasPathSum4(root, 22));
        Assert.assertEquals(false, BinaryTreeSolutions.hasPathSum4(root, 23));
        Assert.assertEquals(true, BinaryTreeSolutions.hasPathSum5(root, 22));
        Assert.assertEquals(false, BinaryTreeSolutions.hasPathSum5(root, 23));

        root = new TreeNode(2);
        root.left = new TreeNode(-1);
        root.left.right = new TreeNode(-5);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(0);
        root.left.right.left.right = new TreeNode(-5);
        root.left.right.right.right = new TreeNode(-1);
        root.left.right.left.right.right = new TreeNode(-4);
        root.left.right.right.right.left = new TreeNode(-5);
        Assert.assertTrue(BinaryTreeSolutions.hasPathSum6(root, -10));
    }
}