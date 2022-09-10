package com.fbokov.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversalRecursiveStrategy implements TraversalStrategy {
    @Override
    public List<Integer> traversal(TreeNode root) {
        if (root == null) return List.of();
        
        List<Integer> preOrder = new ArrayList<>();
        preOrder.add(root.val);

        if (root.left != null) {
            preOrder.addAll(traversal(root.left));
        } 

        if (root.right != null) {
            preOrder.addAll(traversal(root.right));
        }
        return preOrder;
    }
}
