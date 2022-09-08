package com.fbokov.binarytree;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Traversals {
    private final Random rand = new Random();

    public List<Integer> preOrderTraversalIterative(TreeNode root) {
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

    public void inOrderTraversalIterative(TreeNode treeNode) {

    }

    public void postOrderTraversalIterative(TreeNode treeNode) {

    }

    public TreeNode createTree(Integer[] input) {
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
        return createTree(bound);
    }

    public TreeNode createTree(int count) {
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
