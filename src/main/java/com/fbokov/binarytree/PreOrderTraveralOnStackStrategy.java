package com.fbokov.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraveralOnStackStrategy implements TraversalStrategy {

    @Override
    public List<Integer> traversal(TreeNode root) {
        if (root == null) return List.of();

        ArrayList<Integer> preOrder = new ArrayList<>(50);
        Stack<TreeNode> tree = new Stack<>();

        TreeNode curr = root;
        for(int i = 0; i < 100; i++) {
            preOrder.add(curr.val);

            if (curr.left != null) {
                tree.push(curr);
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
            break;
        }

        return preOrder;
    }
}
