package DataStructures.BinaryTree;

public class Trees {
    public static void main(String[] args) {
        int values[]={5,1,3,4,2,7};
        BinarySearchTree.Node root=null;
        BinarySearchTree list = new BinarySearchTree();
        for(int i=0;i<values.length;i++){
            root=list.buildTree(root,values[i]);
        }
        list.inorderDisplay(root);



    }
}

class BinarySearchTree{
    class Node{
        int value;
        Node left;
        Node right;
        Node(int data){
            value=data;
        }
    }
    Node buildTree(Node root , int data){
        if(root==null){
            root=new Node(data);
            return root;
        }
        if(root.value>data){
            root.left=buildTree(root.left,data);
        }
        else{
            root.right=buildTree(root.right,data);
        }
         return root;
    }
    void inorderDisplay(Node root){
        if(root==null){
            return;
        }
        inorderDisplay(root.left);
        System.out.print(root.value+" ");
        inorderDisplay(root.right);
    }



}
