package io.ajarara.traversals;

import jakarta.annotation.Nullable;

public record TreeNode(int value, @Nullable TreeNode left, @Nullable TreeNode right) { }

