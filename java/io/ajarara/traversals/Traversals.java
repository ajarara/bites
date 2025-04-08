package io.ajarara.traversals;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayDeque;

class Traversals {
    public static Iterator<TreeNode> preorder(TreeNode root) {
        if (root == null) {
            return List.<TreeNode>of().iterator();
        }
        var stack = new ArrayDeque<TreeNode>();
        stack.add(root);
        return new Iterator<TreeNode>() {

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public TreeNode next() {
                TreeNode node = stack.removeLast();
                if (node.right() != null) {
                    stack.add(node.right());
                }
                if (node.left() != null) {
                    stack.add(node.left());
                }
                return node;
            }
        };
    }
}
