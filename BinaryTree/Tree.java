package DataStructures.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.math.*;

public class Tree {
    public static void main(String[] args) {
        int node[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree1 tree=new BinaryTree1();
        BinaryTree1.Node root = tree.buildTree(node);
//        System.out.println(root.data);
//        tree.preOrderDisplay(root);
//        System.out.println();
//        tree.inOrderDisplay(root);
//        System.out.println();
//        tree.postOrderDisplay(root);
//        System.out.println();
//        tree.levelOrderDisplay(root);
//        System.out.println("the height iss");
//        System.out.println(tree.height(root));
//        System.out.println(tree.countNode(root));
       // System.out.println(tree.sumNodes(root));
        System.out.println(tree.diameter(root));
    }
}
class BinaryTree1{
  int i=-1;
  Node buildTree(int node[]){
      i++;
      if(node[i]==-1){
          return null;
      }
      Node newNode=new Node(node[i]);
      newNode.left=buildTree(node);
      newNode.right=buildTree(node);
      return newNode;
  }
  //count the nodes
  int countNode(Node root){
      if(root==null){
          return 0;
      }
      int lh=countNode(root.left);
      int rh=countNode(root.right);
      return lh+rh+1;
  }
  //preorder display root rootLeft rootRight
  void preOrderDisplay(Node root){
      if(root==null){
        //  System.out.print(-1+" ");
          return;
      }
      System.out.print(root.data+" ");
      preOrderDisplay(root.left);
      preOrderDisplay(root.right);


  }

  //inOrderDisplay left root right
  void inOrderDisplay(Node root){

      if(root==null){
          return;
      }
      inOrderDisplay(root.left);
      System.out.print(root.data+" ");
      inOrderDisplay(root.right);

  }
  void postOrderDisplay(Node root){
      if(root==null){
          return;
      }
      postOrderDisplay(root.left);
      postOrderDisplay(root.right);
      System.out.print(root.data+" ");
  }
  //print data level wise
  void levelOrderDisplay(Node root){
      if(root == null){
          return ;
      }
      Queue<Node> list = new LinkedList<>();
      list.add(root);
      list.add(null);
      while(!list.isEmpty()){
          Node curr=list.remove();
          if(curr==null){
              System.out.println();
              if(list.isEmpty())
                   break;
              else
                  list.add(null);
          }
          else {
              System.out.print(curr.data+" ");
              if(curr.left!=null)
                   list.add(curr.left);
              if(curr.right!=null)
                  list.add(curr.right);
          }
      }
  }
    class Node{
        int data;
        Node left;
        Node right;
        Node(int i){
            data=i;
        }

    }
    int height(Node root){
      if(root==null){
          return 0;
      }
      int lh=height(root.left);
      int rh=height(root.right);
      return Math.max(lh,rh)+1;
    }
    int sumNodes(Node root){
      if(root==null){
          return 0;
      }
      int lh=sumNodes(root.left);
      int rh=sumNodes(root.right);
      return lh+rh+root.data;
    }
    int diameter(Node root){
      if(root==null){
          return 0;
      }
      int lh=diameter(root.left);
      int rh=diameter(root.right);
      int ld=height(root.left);
      int hd=height(root.right);
      return Math.max(Math.max(lh,rh),ld+hd+1);

    }




}


