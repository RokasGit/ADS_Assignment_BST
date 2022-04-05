import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    BinarySearchTree bt;
    @BeforeEach
    void setUp() {
        System.out.println("====================> Set Up");
        bt = new BinarySearchTree();
        bt.insert(50);
        bt.insert(30);
        bt.insert(10);
        bt.insert(70);
        bt.insert(60);
        bt.insert(90);
        bt.insert(5);
    }

    @AfterEach
    void tearDown() {
        System.out.println("<================================== Tear Down");
    }

    @Test
    void insert() {
        Assertions.assertEquals(true,bt.insert(3));
    }

    @Test
    void removeElement() {
        Assertions.assertEquals(true,bt.removeElement(50));

    }

    @Test
    void findMin() {
        Assertions.assertEquals(5,bt.findMin());
    }

    @Test
    void contains() {
        Assertions.assertEquals(true,bt.contains(5));
    }

    @Test
    void rebalance() {
        bt.rebalance();
        Assertions.assertEquals("[5, 10, 30, 50, 60, 70, 90]",bt.inOrder().toString());
    }
}