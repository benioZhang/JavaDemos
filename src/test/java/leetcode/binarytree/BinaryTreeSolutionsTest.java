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

    @Test
    public void buildTree() {
        int[] inorder, postorder;
        inorder = new int[]{9, 3, 15, 20, 7};
        postorder = new int[]{9, 15, 7, 20, 3};

        TreeNode root = BinaryTreeSolutions.buildTree(inorder, postorder);
        Assert.assertEquals(3, root.val);
        Assert.assertEquals(9, root.left.val);
        Assert.assertEquals(20, root.right.val);
        Assert.assertEquals(15, root.right.left.val);
        Assert.assertEquals(7, root.right.right.val);
    }

    @Test
    public void buildTree2() {
        int[] inorder, postorder;
        inorder = new int[]{9, 3, 15, 20, 7};
        postorder = new int[]{9, 15, 7, 20, 3};

        TreeNode root = BinaryTreeSolutions.buildTree2(inorder, postorder);
        Assert.assertEquals(3, root.val);
        Assert.assertEquals(9, root.left.val);
        Assert.assertEquals(20, root.right.val);
        Assert.assertEquals(15, root.right.left.val);
        Assert.assertEquals(7, root.right.right.val);
    }

    @Test
    public void buildTreeII() {
        int[] inorder, preorder;
        preorder = new int[]{3, 9, 20, 15, 7};
        inorder = new int[]{9, 3, 15, 20, 7};

        TreeNode root = BinaryTreeSolutions.buildTreeII(preorder, inorder);
        Assert.assertEquals(3, root.val);
        Assert.assertEquals(9, root.left.val);
        Assert.assertEquals(20, root.right.val);
        Assert.assertEquals(15, root.right.left.val);
        Assert.assertEquals(7, root.right.right.val);
    }

    @Test
    public void connect() {
        Node root;
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Assert.assertEquals(null, BinaryTreeSolutions.connect(null));
        BinaryTreeSolutions.connect(root);
        Assert.assertEquals(null, root.next);
        Assert.assertEquals(root.right, root.left.next);
        Assert.assertEquals(null, root.right.next);
        Assert.assertEquals(root.left.right, root.left.left.next);
        Assert.assertEquals(root.right.left, root.left.right.next);
        Assert.assertEquals(root.right.right, root.right.left.next);
        Assert.assertEquals(null, root.right.right.next);
    }

    @Test
    public void connect2() {
        Node root;
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Assert.assertEquals(null, BinaryTreeSolutions.connect2(null));
        BinaryTreeSolutions.connect2(root);
        Assert.assertEquals(null, root.next);
        Assert.assertEquals(root.right, root.left.next);
        Assert.assertEquals(null, root.right.next);
        Assert.assertEquals(root.left.right, root.left.left.next);
        Assert.assertEquals(root.right.left, root.left.right.next);
        Assert.assertEquals(root.right.right, root.right.left.next);
        Assert.assertEquals(null, root.right.right.next);
    }

    @Test
    public void connect3() {
        Node root;
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Assert.assertEquals(null, BinaryTreeSolutions.connect3(null));
        BinaryTreeSolutions.connect3(root);
        Assert.assertEquals(null, root.next);
        Assert.assertEquals(root.right, root.left.next);
        Assert.assertEquals(null, root.right.next);
        Assert.assertEquals(root.left.right, root.left.left.next);
        Assert.assertEquals(root.right.left, root.left.right.next);
        Assert.assertEquals(root.right.right, root.right.left.next);
        Assert.assertEquals(null, root.right.right.next);
    }

    @Test
    public void connect4() {
        Node root;
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Assert.assertEquals(null, BinaryTreeSolutions.connect4(null));
        BinaryTreeSolutions.connect4(root);
        Assert.assertEquals(null, root.next);
        Assert.assertEquals(root.right, root.left.next);
        Assert.assertEquals(null, root.right.next);
        Assert.assertEquals(root.left.right, root.left.left.next);
        Assert.assertEquals(root.right.left, root.left.right.next);
        Assert.assertEquals(root.right.right, root.right.left.next);
        Assert.assertEquals(null, root.right.right.next);
    }

    @Test
    public void connectII() {
        Assert.assertEquals(null, BinaryTreeSolutions.connectII(null));

        Node root;
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(7);

        BinaryTreeSolutions.connectII(root);
        Assert.assertEquals(null, root.next);
        Assert.assertEquals(root.right, root.left.next);
        Assert.assertEquals(null, root.right.next);
        Assert.assertEquals(root.left.right, root.left.left.next);
        Assert.assertEquals(root.right.right, root.left.right.next);
        Assert.assertEquals(null, root.right.right.next);

        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.right = new Node(3);
        root.right.right = new Node(5);

        BinaryTreeSolutions.connectII(root);
        Assert.assertEquals(null, root.next);
        Assert.assertEquals(root.right, root.left.next);
        Assert.assertEquals(null, root.right.next);
        Assert.assertEquals(root.right.right, root.left.left.next);
        Assert.assertEquals(null, root.right.right.next);

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        root.right.right.right = new Node(8);

        BinaryTreeSolutions.connectII(root);
        Assert.assertEquals(null, root.next);
        Assert.assertEquals(root.right, root.left.next);
        Assert.assertEquals(null, root.right.next);
        Assert.assertEquals(root.left.right, root.left.left.next);
        Assert.assertEquals(root.right.right, root.left.right.next);
        Assert.assertEquals(null, root.right.right.next);
        Assert.assertEquals(root.right.right.right, root.left.left.left.next);
        Assert.assertEquals(null, root.right.right.right.next);
    }

    @Test
    public void connectII2() {
        Assert.assertEquals(null, BinaryTreeSolutions.connectII2(null));

        Node root;
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(7);

        BinaryTreeSolutions.connectII2(root);
        Assert.assertEquals(null, root.next);
        Assert.assertEquals(root.right, root.left.next);
        Assert.assertEquals(null, root.right.next);
        Assert.assertEquals(root.left.right, root.left.left.next);
        Assert.assertEquals(root.right.right, root.left.right.next);
        Assert.assertEquals(null, root.right.right.next);

        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.right = new Node(3);
        root.right.right = new Node(5);

        BinaryTreeSolutions.connectII2(root);
        Assert.assertEquals(null, root.next);
        Assert.assertEquals(root.right, root.left.next);
        Assert.assertEquals(null, root.right.next);
        Assert.assertEquals(root.right.right, root.left.left.next);
        Assert.assertEquals(null, root.right.right.next);

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        root.right.right.right = new Node(8);

        BinaryTreeSolutions.connectII2(root);
        Assert.assertEquals(null, root.next);
        Assert.assertEquals(root.right, root.left.next);
        Assert.assertEquals(null, root.right.next);
        Assert.assertEquals(root.left.right, root.left.left.next);
        Assert.assertEquals(root.right.right, root.left.right.next);
        Assert.assertEquals(null, root.right.right.next);
        Assert.assertEquals(root.right.right.right, root.left.left.left.next);
        Assert.assertEquals(null, root.right.right.right.next);
    }

    @Test
    public void lowestCommonAncestor() {
        TreeNode root, p, q;

        root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // p = 5, q = 1
        p = root.left;
        q = root.right;
        Assert.assertEquals(null, BinaryTreeSolutions.lowestCommonAncestor(null, p, q));
        Assert.assertEquals(root, BinaryTreeSolutions.lowestCommonAncestor(root, p, q));

        // p = 5, q = 4
        p = root.left;
        q = root.left.right.right;
        Assert.assertEquals(p, BinaryTreeSolutions.lowestCommonAncestor(root, p, q));

        // p = 6, q = 4
        p = root.left.left;
        q = root.left.right.right;
        Assert.assertEquals(root.left, BinaryTreeSolutions.lowestCommonAncestor(root, p, q));
    }

    @Test
    public void serialize() {
        TreeNode root = null;
        Assert.assertEquals("[]", BinaryTreeSolutions.serialize(root));
        Assert.assertEquals("[]", BinaryTreeSolutions.serialize2(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Assert.assertEquals("[1,2,3,null,null,4,5]", BinaryTreeSolutions.serialize(root));
        Assert.assertEquals("[1,2,3,null,null,4,5]", BinaryTreeSolutions.serialize2(root));

        root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Assert.assertEquals("[1,null,3,4,5]", BinaryTreeSolutions.serialize(root));
        Assert.assertEquals("[1,null,3,4,5]", BinaryTreeSolutions.serialize2(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        Assert.assertEquals("[1,2,null,3,null,4,null,5]", BinaryTreeSolutions.serialize(root));
        Assert.assertEquals("[1,2,null,3,null,4,null,5]", BinaryTreeSolutions.serialize2(root));
    }

    @Test
    public void deserialize() {
        TreeNode root;
        root = BinaryTreeSolutions.deserialize("[]");
        Assert.assertEquals(null, root);

        root = BinaryTreeSolutions.deserialize("[1,2,3,null,null,4,5]");
        Assert.assertEquals(1, root.val);
        Assert.assertEquals(2, root.left.val);
        Assert.assertEquals(3, root.right.val);
        Assert.assertEquals(null, root.left.left);
        Assert.assertEquals(null, root.left.right);
        Assert.assertEquals(4, root.right.left.val);
        Assert.assertEquals(5, root.right.right.val);

        root = BinaryTreeSolutions.deserialize("[1,null,3,4,5]");
        Assert.assertEquals(1, root.val);
        Assert.assertEquals(null, root.left);
        Assert.assertEquals(3, root.right.val);
        Assert.assertEquals(4, root.right.left.val);
        Assert.assertEquals(5, root.right.right.val);

        root = BinaryTreeSolutions.deserialize("[1,2,null,3,null,4,null,5]");
        Assert.assertEquals(1, root.val);
        Assert.assertEquals(2, root.left.val);
        Assert.assertEquals(null, root.right);
        Assert.assertEquals(3, root.left.left.val);
        Assert.assertEquals(null, root.left.right);
        Assert.assertEquals(4, root.left.left.left.val);
        Assert.assertEquals(null, root.left.left.right);
        Assert.assertEquals(5, root.left.left.left.left.val);
        Assert.assertEquals(null, root.left.left.left.right);

        root = BinaryTreeSolutions.deserialize("[1,2]");
        Assert.assertEquals(1, root.val);
        Assert.assertEquals(2, root.left.val);

        root = BinaryTreeSolutions.deserialize("[1,null,2]");
        Assert.assertEquals(1, root.val);
        Assert.assertEquals(null, root.left);
        Assert.assertEquals(2, root.right.val);
    }
}