import java.util.ArrayList;

public class BinarySearchTree extends BinaryTree {
    public BinarySearchTree() {
        super();
    }

    public BinarySearchTree(BinarySearchTreeNode<Integer> root) {
        super(root);
    }

    public boolean insert(int element) {
        BinarySearchTreeNode<Integer> node = new BinarySearchTreeNode<>(element);
        if (super.getRoot() == null) {
            super.setRoot(node);
            return true;
        } else {
            BinarySearchTreeNode<Integer> current = (BinarySearchTreeNode<Integer>) super.getRoot();
            BinarySearchTreeNode<Integer> parent = null;
            while (true) {
                parent = current;
                if (element < current.getElement()) {
                    current = (BinarySearchTreeNode<Integer>) current.getLeftChild();
                    if (current == null) {
                        parent.addLeftChild(node);
                        return true;
                    }
                } else {
                    current = (BinarySearchTreeNode<Integer>) current.getRightChild();
                    if (current == null) {
                        parent.addRightChild(node);
                        return true;
                    }
                }
            }
        }
    }

    public boolean removeElement(int element) {
        BinarySearchTreeNode<Integer> toRemove=deleteNode((BinarySearchTreeNode<Integer>) super.getRoot(), element);
        return toRemove.getElement()!=element;
    }

    private BinarySearchTreeNode<Integer> deleteNode(BinarySearchTreeNode<Integer> node, int element) {
        if (node == null) {
            return null;
        } else {
            if (element < node.getElement()) {
                node.addLeftChild(deleteNode((BinarySearchTreeNode<Integer>) node.getLeftChild(), element));
            } else if (element > node.getElement()) {
                node.addRightChild(deleteNode((BinarySearchTreeNode<Integer>) node.getRightChild(), element));
            } else {
                if (node.getLeftChild() == null && node.getRightChild() == null) {
                    node = null;
                } else if (node.getLeftChild() == null) {
                    node = (BinarySearchTreeNode<Integer>) node.getRightChild();
                } else if (node.getRightChild() == null) {
                    node = (BinarySearchTreeNode<Integer>) node.getLeftChild();
                } else {
                    BinarySearchTreeNode<Integer> tempNode = minNode((BinarySearchTreeNode<Integer>) node.getRightChild());
                    node.setElement(tempNode.getElement());
                    node.addRightChild(deleteNode((BinarySearchTreeNode<Integer>) node.getRightChild(), tempNode.getElement()));
                }

            }
            return node;
        }
    }

    private BinarySearchTreeNode<Integer> minNode(BinarySearchTreeNode<Integer> root) {
        if (root.getLeftChild() != null) {
            return minNode((BinarySearchTreeNode<Integer>) root.getLeftChild());
        } else {
            return root;
        }
    }
    public int findMin(){
        return minNode((BinarySearchTreeNode<Integer>) super.getRoot()).getElement();
    }
    private BinarySearchTreeNode<Integer> maxNode(BinarySearchTreeNode<Integer> root){
        if(root.getRightChild()!=null){
            return maxNode((BinarySearchTreeNode<Integer>) root.getRightChild());
        }else{
            return root;
        }
    }

    @Override
    public boolean contains(int element) {
        return super.contains(element);
    }
    public void rebalance(){
        ArrayList<BinarySearchTreeNode<Integer>> nodes = new ArrayList<>();
        storeNodes((BinarySearchTreeNode<Integer>) getRoot(),nodes);
        setRoot(rebuildTree(nodes,0,nodes.size()-1));
    }
    private void storeNodes(BinarySearchTreeNode<Integer> node,ArrayList<BinarySearchTreeNode<Integer>> elementTraversal){
        if(node.getLeftChild()!=null){
            storeNodes((BinarySearchTreeNode<Integer>) node.getLeftChild(),elementTraversal);
        }
        elementTraversal.add(node);
        if(node.getRightChild()!=null){
            storeNodes((BinarySearchTreeNode<Integer>) node.getRightChild(),elementTraversal);
        }
    }
    private BinarySearchTreeNode<Integer> rebuildTree(ArrayList<BinarySearchTreeNode<Integer>> nodes, int start, int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        BinarySearchTreeNode<Integer> node = nodes.get(mid);
        node.addLeftChild(rebuildTree(nodes,start,mid-1));
        node.addRightChild(rebuildTree(nodes,mid+1,end));
        return node;
    }
}
