package com.fbokov.binarytree;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class PreOrderTraveralOnStackStrategy implements TraversalStrategy {

    @Override
    public List<Integer> traversal(TreeNode root) {
        if (root == null) return List.of();

        TreeNode[] preOrder = new TreeNode[100];
        Stack<TreeNode> tree = new Stack<>();

        TreeNode curr = root;
        for(int i = 0; i < 100; i++) {
            preOrder[i] = curr;
            tree.push(curr);

            if (curr.left != null) {
                curr = curr.left;
                continue;
            }

            boolean found = false;
            while(true) {
                curr = curr.right;
                if (curr == null) {
                    if (tree.empty()) break;
                    curr = tree.pop();
                    continue;
                }
                found = true;
                break;
            }

            if (found) continue;
            preOrder = Arrays.copyOf(preOrder, i + 1);
            break;
        }

        var result = Arrays.stream(preOrder).map(x -> x.val).collect(Collectors.toList());
        return result;
    }
}
