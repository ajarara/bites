package io.ajarara.traversals;

import jakarta.annotation.Nullable;

public class TreeNode {
    final int value;
    final @Nullable TreeNode left;
    final @Nullable TreeNode right;
    
    public TreeNode (int value, @Nullable TreeNode left, @Nullable TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
