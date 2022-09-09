package com.fbokov.binarytree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PreOrderTraversalOnArraysStrategy implements TraversalStrategy {
    public List<Integer> traversal(TreeNode root) {
        if (root == null) return List.of();

        TreeNode[] preOrder = new TreeNode[100];
        int[] roots = new int[100];

        TreeNode curr = root;
        int rootIndex = -1;

        for(int i = 0; i < 100; i++) {
            preOrder[i] = curr;
            roots[i] = rootIndex;

            if (curr.left != null) {
                rootIndex = i;
                curr = curr.left;
                continue;
            }

            boolean found = false;
            while (true) {
                if (curr.right != null) {
                    curr = curr.right;
                    found = true;
                    break;
                } 
                if (rootIndex == -1) break;
                curr = preOrder[rootIndex];
                rootIndex = roots[rootIndex];
            }

            if (found) continue;

            preOrder = Arrays.copyOf(preOrder, i + 1);
            break;
        }

        var result = Arrays.stream(preOrder).map(x -> x.val).collect(Collectors.toList());
        return result;
    }
}
