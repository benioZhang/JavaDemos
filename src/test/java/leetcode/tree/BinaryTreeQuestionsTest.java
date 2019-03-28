package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BinaryTreeQuestionsTest {

    @Test
    public void preorderTraversal() {
        TreeNode root;
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Assert.assertEquals(Arrays.asList(1, 2, 3), BinaryTreeQuestions.preorderTraversal(root));
        Assert.assertEquals(Arrays.asList(1, 2, 3), BinaryTreeQuestions.preorderTraversal2(root));
        Assert.assertEquals(Arrays.asList(1, 2, 3), BinaryTreeQuestions.preorderTraversal3(root));
        Assert.assertEquals(Arrays.asList(1, 2, 3), BinaryTreeQuestions.preorderTraversal4(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Assert.assertEquals(Arrays.asList(1, 2, 4, 3, 5, 6), BinaryTreeQuestions.preorderTraversal(root));
        Assert.assertEquals(Arrays.asList(1, 2, 4, 3, 5, 6), BinaryTreeQuestions.preorderTraversal2(root));
        Assert.assertEquals(Arrays.asList(1, 2, 4, 3, 5, 6), BinaryTreeQuestions.preorderTraversal3(root));
        Assert.assertEquals(Arrays.asList(1, 2, 4, 3, 5, 6), BinaryTreeQuestions.preorderTraversal4(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Assert.assertEquals(Arrays.asList(1, 2, 4, 5, 3, 6), BinaryTreeQuestions.preorderTraversal(root));
        Assert.assertEquals(Arrays.asList(1, 2, 4, 5, 3, 6), BinaryTreeQuestions.preorderTraversal2(root));
        Assert.assertEquals(Arrays.asList(1, 2, 4, 5, 3, 6), BinaryTreeQuestions.preorderTraversal3(root));
        Assert.assertEquals(Arrays.asList(1, 2, 4, 5, 3, 6), BinaryTreeQuestions.preorderTraversal4(root));
    }

    @Test
    public void inorderTraversal() {
        TreeNode root;
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Assert.assertEquals(Arrays.asList(1, 3, 2), BinaryTreeQuestions.inorderTraversal(root));
        Assert.assertEquals(Arrays.asList(1, 3, 2), BinaryTreeQuestions.inorderTraversal2(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Assert.assertEquals(Arrays.asList(4, 2, 1, 5, 3, 6), BinaryTreeQuestions.inorderTraversal(root));
        Assert.assertEquals(Arrays.asList(4, 2, 1, 5, 3, 6), BinaryTreeQuestions.inorderTraversal2(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Assert.assertEquals(Arrays.asList(4, 2, 5, 1, 3, 6), BinaryTreeQuestions.inorderTraversal(root));
        Assert.assertEquals(Arrays.asList(4, 2, 5, 1, 3, 6), BinaryTreeQuestions.inorderTraversal2(root));
    }

    @Test
    public void postorderTraversal() {
        TreeNode root;
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Assert.assertEquals(Arrays.asList(3, 2, 1), BinaryTreeQuestions.postorderTraversal(root));
        Assert.assertEquals(Arrays.asList(3, 2, 1), BinaryTreeQuestions.postorderTraversal2(root));
        Assert.assertEquals(Arrays.asList(3, 2, 1), BinaryTreeQuestions.postorderTraversal3(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Assert.assertEquals(Arrays.asList(4, 2, 5, 6, 3, 1), BinaryTreeQuestions.postorderTraversal(root));
        Assert.assertEquals(Arrays.asList(4, 2, 5, 6, 3, 1), BinaryTreeQuestions.postorderTraversal2(root));
        Assert.assertEquals(Arrays.asList(4, 2, 5, 6, 3, 1), BinaryTreeQuestions.postorderTraversal3(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Assert.assertEquals(Arrays.asList(4, 5, 2, 6, 3, 1), BinaryTreeQuestions.postorderTraversal(root));
        Assert.assertEquals(Arrays.asList(4, 5, 2, 6, 3, 1), BinaryTreeQuestions.postorderTraversal2(root));
        Assert.assertEquals(Arrays.asList(4, 5, 2, 6, 3, 1), BinaryTreeQuestions.postorderTraversal3(root));
    }

    @Test
    public void levelOrder() {
        TreeNode root;
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Assert.assertEquals(Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3)),
                BinaryTreeQuestions.levelOrder(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Assert.assertEquals(Arrays.asList(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6)),
                BinaryTreeQuestions.levelOrder(root));
        Assert.assertEquals(Arrays.asList(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6)),
                BinaryTreeQuestions.levelOrder2(root));

        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Assert.assertEquals(Arrays.asList(Arrays.asList(3), Arrays.asList(9, 20), Arrays.asList(15, 7)),
                BinaryTreeQuestions.levelOrder(root));
        Assert.assertEquals(Arrays.asList(Arrays.asList(3), Arrays.asList(9, 20), Arrays.asList(15, 7)),
                BinaryTreeQuestions.levelOrder2(root));
    }

    @Test
    public void maxDepth() {
        TreeNode root;
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(4);
        Assert.assertEquals(4, BinaryTreeQuestions.maxDepth(root));

        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Assert.assertEquals(3, BinaryTreeQuestions.maxDepth(root));
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
        Assert.assertEquals(true, BinaryTreeQuestions.isSymmetric(root));
        Assert.assertEquals(true, BinaryTreeQuestions.isSymmetric2(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        Assert.assertEquals(false, BinaryTreeQuestions.isSymmetric(root));
        Assert.assertEquals(false, BinaryTreeQuestions.isSymmetric2(root));
    }

    @Test
    public void hasPathSum() {
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        Assert.assertEquals(false, BinaryTreeQuestions.hasPathSum(root, 1));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Assert.assertEquals(true, BinaryTreeQuestions.hasPathSum(root, 8));
        Assert.assertEquals(false, BinaryTreeQuestions.hasPathSum(root, 11));

        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        Assert.assertEquals(true, BinaryTreeQuestions.hasPathSum(root, 22));
        Assert.assertEquals(false, BinaryTreeQuestions.hasPathSum(root, 23));
    }
}