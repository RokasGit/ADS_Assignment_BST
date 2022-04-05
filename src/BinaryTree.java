import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree {
    private BinaryTreeNode<Integer> root;
    private int size;
    public BinaryTree(){
        root = null;
        size = 0;
    }
    public BinaryTree(BinaryTreeNode<Integer> root) {
        this.root = root;
        size=1;
    }

    public BinaryTreeNode<Integer> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<Integer> root) {
        this.root = root;
        size = 1;
    }

    public boolean isEmpty() {
        return root==null;
    }

    public int getSize() {
        size=inOrder().size();
        return size;
    }

    public boolean contains(int element) {
        return true;
    }

    public ArrayList<Integer> inOrder() {
        if (isEmpty()) {
            return null;
        }
        ArrayList<Integer> elementTraversal = new ArrayList<>();
        inOrderTraversal(root,elementTraversal);
        return elementTraversal;
    }
    private void inOrderTraversal(BinaryTreeNode<Integer> node,ArrayList<Integer> elementTraversal){
            if(node.getLeftChild()!=null){
                inOrderTraversal(node.getLeftChild(),elementTraversal);
            }
            elementTraversal.add(node.getElement());
            if(node.getRightChild()!=null){
                inOrderTraversal(node.getRightChild(),elementTraversal);
            }
    }
    public ArrayList<Integer> preOrder() {
        if (isEmpty()) {
            return null;
        }
        ArrayList<Integer> elementTraversal = new ArrayList<>();
        preOrderTraversal(root,elementTraversal);
        return elementTraversal;
    }
    private void preOrderTraversal(BinaryTreeNode<Integer> node, ArrayList<Integer> elementTraversal){
        elementTraversal.add(node.getElement());
        if(node.getLeftChild()!=null){
            preOrderTraversal(node.getLeftChild(), elementTraversal);
        }
        if(node.getRightChild()!=null){
            preOrderTraversal(node.getRightChild(),elementTraversal);
        }

    }

    public ArrayList<Integer> levelOrder() {
        if(isEmpty()){
            return null;
        }
        int h= height();
        ArrayList<Integer> elementTraversal = new ArrayList<>();
        for(int i=0;i<h;i++){
            levelOrderTraversal(root,elementTraversal,i);
        }
        return elementTraversal;
    }
    private void levelOrderTraversal(BinaryTreeNode<Integer> node, ArrayList<Integer> elementTraversal,int level){
        if(level==0){
            elementTraversal.add(node.getElement());
        }else if(level >0){
            if(node.getLeftChild()!=null){
                levelOrderTraversal(node.getLeftChild(), elementTraversal, level - 1);
            }
            if(node.getRightChild()!=null){
                levelOrderTraversal(node.getRightChild(), elementTraversal, level - 1);
            }
        }
    }

    public ArrayList<Integer> postOrder() {
        if (isEmpty()) {
            return null;
        }
        ArrayList<Integer> elementTraversal = new ArrayList<>();
        postOrderTraversal(root,elementTraversal);
        return elementTraversal;
    }
    private void postOrderTraversal(BinaryTreeNode<Integer> node, ArrayList<Integer> elementTraversal){
        if(node.getLeftChild()!=null){
            postOrderTraversal(node.getLeftChild(),elementTraversal);
        }
        if(node.getRightChild()!=null){
            postOrderTraversal(node.getRightChild(),elementTraversal);
        }
        elementTraversal.add(node.getElement());
    }
    private int findHeight(BinaryTreeNode<Integer> node) {
        if (root == null) {
            return -1;
        } else {
            int leftHeight = 0, rightHeight = 0;
            if(node.getLeftChild()!=null){
                leftHeight=findHeight(node.getLeftChild());
            }
            if(node.getRightChild()!=null){
                rightHeight= findHeight(node.getRightChild());
            }
            return 1+ Math.max(leftHeight,rightHeight);
        }

    }

    public int height() {
        return findHeight(root);
    }

}
