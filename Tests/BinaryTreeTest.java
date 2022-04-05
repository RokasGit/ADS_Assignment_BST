import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    BinaryTree bt;
    @BeforeEach
    void setUp() {
        System.out.println("---------------------------> Set Up");
        bt = new BinaryTree();
        bt.setRoot(new BinaryTreeNode<>(1));
        bt.getRoot().addLeftChild(new BinaryTreeNode<>(2));
        bt.getRoot().addRightChild(new BinaryTreeNode<>(3));
        bt.getRoot().getLeftChild().addLeftChild(new BinaryTreeNode<>(4));
        bt.getRoot().getRightChild().addLeftChild(new BinaryTreeNode<>(5));
        bt.getRoot().getRightChild().addRightChild(new BinaryTreeNode<>(6));
        bt.getRoot().getRightChild().getRightChild().addRightChild(new BinaryTreeNode<>(7));
        bt.getRoot().getRightChild().getRightChild().getRightChild().addRightChild(new BinaryTreeNode<>(8));
    }

    @AfterEach
    void tearDown() {
        System.out.println("<---------------------- Tear Down");
    }

    @Test
    void isEmpty() {
        Assertions.assertEquals(false,bt.isEmpty());
        Assertions.assertEquals(true,new BinaryTree().isEmpty());
    }

    @Test
    void getSize() {
        Assertions.assertEquals(8,bt.getSize());
    }

    @Test
    void contains() {
        Assertions.assertEquals(true,bt.contains(8));
    }

    @Test
    void inOrder() {
        Assertions.assertEquals("[4, 2, 1, 5, 3, 6, 7, 8]",bt.inOrder().toString());
    }

    @Test
    void preOrder() {
        Assertions.assertEquals("[1, 2, 4, 3, 5, 6, 7, 8]",bt.preOrder().toString());

    }

    @Test
    void levelOrder() {
        Assertions.assertEquals("[1, 2, 3, 4, 5, 6, 7, 8]",bt.levelOrder().toString());
    }

    @Test
    void postOrder() {
        Assertions.assertEquals("[4, 2, 5, 8, 7, 6, 3, 1]",bt.postOrder().toString());
    }

    @Test
    void height() {
        Assertions.assertEquals(5,bt.height());
    }
}