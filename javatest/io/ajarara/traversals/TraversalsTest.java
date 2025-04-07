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
        var expected = List.of(root);
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
}



