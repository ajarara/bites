package io.ajarara.traversals;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayDeque;
import java.util.function.Consumer;

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

    public static Iterator<TreeNode> postorder(TreeNode root) {
        if (root == null) {
            return List.<TreeNode>of().iterator();
        }
        // left, right, then root
        // so descend all the way down from root, keep track
        var stack = new ArrayDeque<TreeNode>();
        var descendLeft = new Consumer<TreeNode>() {
                @Override
                public void accept(TreeNode treeNode) {
                    if (treeNode != null) {
                        stack.addFirst(treeNode);
                        this.accept(treeNode.left());
                    }
                }
            };
        descendLeft.accept(root);
        return new Iterator<TreeNode>() {
            private TreeNode prevNode = null;

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public TreeNode next() {
                var curr = stack.peek();
                if (curr.right() == prevNode || curr.right() == null) {
                    prevNode = curr;
                    stack.pop();
                    return curr;
                }
                descendLeft.accept(curr.right());
                prevNode = stack.remove();
                return prevNode;
            }
        };
    }
}
