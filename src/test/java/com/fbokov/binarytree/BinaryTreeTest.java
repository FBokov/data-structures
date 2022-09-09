package com.fbokov.binarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class BinaryTreeTest {
    BinaryTree bt = new BinaryTree();

    @Test
    void shouldGenerateTree() {
        // given

        // when
        var tree = bt.create(100);

        // then - just check that we have correctly generated root
        assertNotNull(tree);
        assertNotNull(tree.val);
        assertNotNull(tree.left);
        assertNotNull(tree.right);
    }

    @Test
    void shouldCreateTree() {
        // when
        var preOrder = bt.create(new Integer[] {1, 2, 3, 4});

        // then
        assertEquals(1, preOrder.val);
        assertEquals(2, preOrder.left.val);
        assertEquals(3, preOrder.right.val);
        assertEquals(4, preOrder.left.left.val);

        assertNull(preOrder.left.right);
        assertNull(preOrder.right.left);
        assertNull(preOrder.right.right);
    }
}
