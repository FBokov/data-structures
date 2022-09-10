package com.fbokov.binarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@DisplayName("Traversal strategies tests")
class TraversalStrategyTest {
    BinaryTree bt = new BinaryTree();
   
    @ParameterizedTest
    @EnumSource
    @DisplayName("Should return empty list if tree is null")
    void shouldProcessNull(TraversalStrategies strategy) {
        // when
        var preOrder = strategy.instance.traversal(null);

        // then
        assertEquals(List.of(), preOrder);
    }

    @ParameterizedTest
    @EnumSource
    @DisplayName("Should return empty list if tree is empty")
    void shouldProcessEmptyTree(TraversalStrategies strategy) {
        // given
        var tree = bt.create(0);
        
        // when
        var preOrder = strategy.instance.traversal(tree);

        // then
        assertEquals(List.of(), preOrder);
    }

    @ParameterizedTest
    @EnumSource
    @DisplayName("Should process full tree")
    void shouldProcessFullTree(TraversalStrategies strategy) {
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
        var preOrder = strategy.instance.traversal(tree);

        // then
        assertEquals(List.of(13, 30, 93, -59, 95, 67, 2, -4, 51, 69, -53, 43, -64, 35), preOrder);
    }

    @ParameterizedTest
    @EnumSource
    @DisplayName("Should procedd not balanced tree")
    void shouldProcessNotBalancedTree(TraversalStrategies strategy) {
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
        var preOrder = strategy.instance.traversal(root);

        // then
        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), preOrder);
    }

    @ParameterizedTest
    @EnumSource
    @DisplayName("Should process tree with right branch only")
    void shouldProcessTreeWithRightOnly(TraversalStrategies strategy) {
        // given: binary tree
        //           1
        //             \
        //               2
        //              /
        //             3   
        // Input: bt = [1,x,2,x,x,3]
        var root  = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        // when
        var preOrder = strategy.instance.traversal(root);

        // then
        assertEquals(List.of(1, 2, 3), preOrder);
    }

    @ParameterizedTest
    @EnumSource
    @DisplayName("Should process tree with left branch only")
    void shouldProcessTreeWithLeftOnly(TraversalStrategies strategy) {
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
        var preOrder = strategy.instance.traversal(root);

        // then
        assertEquals(List.of(1, 2, 3, 4), preOrder);
    }

    @ParameterizedTest
    @EnumSource
    @DisplayName("Should process tree with right branch only")
    void shouldProcessTreeWithRightBranchOnly(TraversalStrategies strategy) {
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
        var preOrder = strategy.instance.traversal(root);

        // then
        assertEquals(List.of(1, 2, 3, 4), preOrder);
    }

    @ParameterizedTest
    @EnumSource
    @DisplayName("Should process tree with root only")
    void shouldProcessTreeWithRootOnly(TraversalStrategies strategy) {
        // given
        //         1
        // input: root = [1]
        var root  = new TreeNode(1);

        // when
        var preOrder = strategy.instance.traversal(root);

        // then
        assertEquals(List.of(1), preOrder);
    }
}
