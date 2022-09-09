package com.fbokov.binarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class TraversalsTest {
    PreOrderOnArraysTraversalStrategy strategy = new PreOrderOnArraysTraversalStrategy();
    BinaryTree bt = new BinaryTree();
   
    @Test
    void preOrderTraversalIterativeShouldProcessNull() {
        // when
        var preOrder = strategy.traversal(null);

        // then
        assertEquals(List.of(), preOrder);
    }

    @Test
    void preOrderTraversalIterativeShouldProcessEmptyTree() {
        // given
        var tree = bt.create(0);
        
        // when
        var preOrder = strategy.traversal(tree);

        // then
        assertEquals(List.of(), preOrder);
    }

    @Test
    void preOrderTraversalIterativeCase1() {
        // given: binary tree
        //              13
        //            /    \
        //        30          51
        //       / \         /    \
        //     93    67     69     -64
        //    / \    / \   /  \     /  
        //  -59 95  2 -4  -53 43   35
        // Input: bt=[13,30,51,93,67,69,-64,-59,95,2,-4,-53,43,35] 
        var tree = bt.create(new Integer[] {13, 30, 51, 93, 67, 69, -64, -59, 95, 2, -4, -53, 43, 35});

        // when
        var preOrder = strategy.traversal(tree);

        // then
        assertEquals(List.of(13, 30, 93, -59, 95, 67, 2, -4, 51, 69, -53, 43, -64, 35), preOrder);
    }

    @Test
    void preOrderTraversalTestCase1() {
        // given: binary
        //            1
        //          /  \
        //        2      7
        //       / \      \
        //     3     4     8
        //          / \   /
        //         5   6 9
        // Input: bt = [1,2,7,3,4,x,8,x,x,5,6,9]

        var tree5 = new TreeNode(5);
        var tree6 = new TreeNode(6);        
        var tree9 = new TreeNode(9);
        var tree3 = new TreeNode(3);

        var tree4 = new TreeNode(4, tree5, tree6);
        var tree2 = new TreeNode(2, tree3, tree4);
        var tree8 = new TreeNode(8, tree9, null);
        var tree7 = new TreeNode(7, null, tree8);
        var tree1 = new TreeNode(1, tree2, tree7);

        var root  = tree1;

        // when
        var preOrder = strategy.traversal(root);

        // then
        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), preOrder);
    }

    @Test
    void preOrderTraversalTestCase2() {
        // given: binary tree
        //           1
        //             \
        //               2
        //              /
        //             3   
        // Input: bt = [1,x,2,x,x,3]
        var root  = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        // when
        var preOrder = strategy.traversal(root);

        // then
        assertEquals(List.of(1, 2, 3), preOrder);
    }

    @Test
    void preOrderTraversalTestCase3() {
        // given: binary tree
        //           1
        //          /
        //         2 
        //        /
        //       3   
        //      /
        //     4
        // Input: root = [1,2,x,3,x,x,x,4]
        var root  = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), null);

        // when
        var preOrder = strategy.traversal(root);

        // then
        assertEquals(List.of(1, 2, 3, 4), preOrder);
    }

    @Test
    void preOrderTraversalTestCase4() {
        // given: binary tree
        //           1
        //            \
        //             2 
        //              \
        //               3   
        //                \
        //                 4
        // Input: bt = [1,x,2,x,x,3,x,x,x,4]
        var root  = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));

        // when
        var preOrder = strategy.traversal(root);

        // then
        assertEquals(List.of(1, 2, 3, 4), preOrder);
    }

    @Test
    void preOrderTraversalTestCase5() {
        // given
        //         1
        // input: root = [1]
        var root  = new TreeNode(1);

        // when
        var preOrder = strategy.traversal(root);

        // then
        assertEquals(List.of(1), preOrder);
    }
}
