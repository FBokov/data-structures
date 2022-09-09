package com.fbokov.binarytree;

import java.util.List;

public interface TraversalStrategy {
    List<Integer> traversal(TreeNode root);
}
