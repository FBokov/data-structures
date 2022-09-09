package com.fbokov.binarytree;

import java.util.Arrays;
import java.util.Random;

public class BinaryTree {
    private final Random rand = new Random();
    
    public TreeNode create(Integer[] input) {
        int nodesCount = input.length;
        TreeNode[] initialization = new TreeNode[nodesCount];

        initialization[0] = newTreeNode(input[0]);
        for (int i = 0; i < nodesCount / 2 + nodesCount % 2; i++) {
            var root = initialization[i];
            if (root == null) continue;

            var base = i * 2;

            var left = base + 1 < nodesCount 
                ? initialization[base + 1] = newTreeNode(input[base + 1])
                : null;

            var right = base + 2 < nodesCount 
                ? initialization[base + 2] =newTreeNode(input[base + 2])
                : null;

            root.left = left;
            root.right = right;
        }

        System.out.println("Input: " + Arrays.toString(initialization));
        return initialization[0];
    }

    public TreeNode createRandomTree() {
        int bound = rand.nextInt(100);
        return create(bound);
    }

    public TreeNode create(int count) {
        int nodesCount = count;
        if (nodesCount == 0) return null;

        TreeNode[] initialization = new TreeNode[nodesCount];

        initialization[0] = newTreeNode();
        for (int i = 0; i < nodesCount / 2 + nodesCount % 2; i++) {
            var root = initialization[i];
            var base = i * 2;

            var left = base + 1 < nodesCount 
                ? initialization[base + 1] = newTreeNode()
                : null;

            var right = base + 2 < nodesCount 
                ? initialization[base + 2] = newTreeNode()
                : null;

            root.left = left;
            root.right = right;
        }

        System.out.println("Input: " + Arrays.toString(initialization));
        return initialization[0];
    }

    private TreeNode newTreeNode() {
        return new TreeNode(nextVal());
    }

    private TreeNode newTreeNode(Integer val) {
        if (val == null) return null;
        return new TreeNode(val);
    }

    private int nextVal() {
        return rand.nextInt(200) - 100;
    }
}
