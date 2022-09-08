package com.fbokov.binarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

class TraversalsTest {
    Traversals traversals = new Traversals();

    @Test
    void shouldGenerateTree() {
        // given

        // when
        var tree = traversals.createTree(100);

        // then - just check that we have correctly generated root
        assertNotNull(tree);
        assertNotNull(tree.val);
        assertNotNull(tree.left);
        assertNotNull(tree.right);
    }

    @Test
    void shouldCreateTree() {
        // when
        var preOrder = traversals.createTree(new Integer[] {1, 2, 3, 4});

        // then
        assertEquals(1, preOrder.val);
        assertEquals(2, preOrder.left.val);
        assertEquals(3, preOrder.right.val);
        assertEquals(4, preOrder.left.left.val);

        assertNull(preOrder.left.right);
        assertNull(preOrder.right.left);
        assertNull(preOrder.right.right);
    }

    @Test
    void preOrderTraversalIterativeShouldProcessNull() {
        // when
        var preOrder = traversals.preOrderTraversalIterative(null);

        // then
        assertEquals(List.of(), preOrder);
    }

    @Test
    void preOrderTraversalIterativeShouldProcessEmptyTree() {
        // given
        var tree = traversals.createTree(0);
        
        // when
        var preOrder = traversals.preOrderTraversalIterative(tree);

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
        var tree = traversals.createTree(new Integer[] {13, 30, 51, 93, 67, 69, -64, -59, 95, 2, -4, -53, 43, 35});

        // when
        var preOrder = traversals.preOrderTraversalIterative(tree);

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
        var preOrder = traversals.preOrderTraversalIterative(root);

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
        var preOrder = traversals.preOrderTraversalIterative(root);

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
        var preOrder = traversals.preOrderTraversalIterative(root);

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
        var preOrder = traversals.preOrderTraversalIterative(root);

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
        var preOrder = traversals.preOrderTraversalIterative(root);

        // then
        assertEquals(List.of(1), preOrder);
    }
}
