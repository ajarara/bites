package io.ajarara.traversals;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import io.ajarara.utils.Lists;

public class TraversalsTest {
    @Test
    public void testPreorderTraversal_emptyTree() {
        TreeNode root = null;
        var expected = List.of();
        var actual = Lists.from(Traversals.preorder(root));
        assertEquals(expected, actual);
    }

    @Test
    public void testPreorderTraversal_singleNode() {
        var root = new TreeNode(1, null, null);
        var expected = List.of(root);
        var actual = Lists.from(Traversals.preorder(root));
        assertEquals(expected, actual);
    }

    @Test
    public void testPreorderTraversal_smallTree() {
        TreeNode two = new TreeNode(2, null, null);
        TreeNode three = new TreeNode(2, null, null);
        TreeNode root = new TreeNode(1, two, three);
        List<TreeNode> expected = List.of(root, two, three);
        List<TreeNode> actual = Lists.from(Traversals.preorder(root));
        assertEquals(expected, actual);
    }

    @Test
    public void testPreorderTraversal_complexTree(){
        TreeNode one = new TreeNode(1, null, null);
        TreeNode four = new TreeNode(4, null, null);
        TreeNode three = new TreeNode(3, one, four);
        TreeNode six = new TreeNode(6, null, null);
        TreeNode nine = new TreeNode(9, null, null);
        TreeNode eight = new TreeNode(8, six, nine);
        TreeNode root = new TreeNode(5, three, eight);

        List<TreeNode> expected = List.of(root,three,one,four,eight,six,nine);
        List<TreeNode> actual = Lists.from(Traversals.preorder(root));
        assertEquals(expected, actual);
    }

    @Test
    public void postorder_nullTree() {
        List<TreeNode> result = Lists.from(Traversals.postorder(null));
        assertEquals(result, List.of());
    }


    @Test
    public void postorder_singleNode() {
        TreeNode root = new TreeNode(1, null, null);
        List<TreeNode> expected = List.of(root);

        List<TreeNode> result = Lists.from(Traversals.postorder(root));

        assertEquals(expected, result);
    }


    @Test
    public void postorder_leftChildOnly() {
        TreeNode left = new TreeNode(2, null, null);
        TreeNode root = new TreeNode(1, left, null);
        List<TreeNode> expected = List.of(left, root);

        List<TreeNode> result = Lists.from(Traversals.postorder(root));

        assertEquals(expected, result);
    }


    @Test
    public void postorder_rightChildOnly() {
        TreeNode right = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(1, null, right);
        List<TreeNode> expected = List.of(right, root);

        List<TreeNode> result = Lists.from(Traversals.postorder(root));

        assertEquals(expected, result);
    }



    @Test
    public void postorder_completeBinaryTree() {
        TreeNode leftLeft = new TreeNode(4, null, null);
        TreeNode leftRight = new TreeNode(5, null, null);
        TreeNode rightLeft = new TreeNode(6, null, null);
        TreeNode rightRight = new TreeNode(7, null, null);
        TreeNode left = new TreeNode(2, leftLeft, leftRight);
        TreeNode right = new TreeNode(3, rightLeft, rightRight);
        TreeNode root = new TreeNode(1, left, right);

        List<TreeNode> expected = List.of(leftLeft, leftRight, left, rightLeft, rightRight, right, root);
        List<TreeNode> result = Lists.from(Traversals.postorder(root));
        assertEquals(expected, result);

    }

    
}



