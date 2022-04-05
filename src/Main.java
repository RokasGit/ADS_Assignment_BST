public class Main {
    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        bt.insert(50);
        bt.insert(30);
        bt.insert(10);
        bt.insert(70);
        bt.insert(60);
        bt.insert(90);
        boolean bool = bt.removeElement(50);
        bool = bt.removeElement(999);
        new BinaryTreePrint().printTree(bt.getRoot());
    }
}
