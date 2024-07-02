package DataStructures.BinaryTree;
import java.util.*;

public class BinaryTree {
	Node root;
	Scanner sc=new Scanner(System.in);
	private static class Node{
		int val;
		Node right;
		Node left;
		Node(int val){
			this.val=val;
			this.right=null;
			this.left=null;
		}
	}
	BinaryTree(){
		System.out.println("Enter the root of the tree:-");
		int a=sc.nextInt();
		insert(a);
		
	}
	private void insert(int val) {
		root=new Node(val);
		insert(root);
	}
	private void insert(Node root) {
		System.out.println("Do you want to insert at left of "+ root.val);
		boolean left=sc.nextBoolean();
		if(left) {
			System.out.println("Enter the element");
			root.left=new Node(sc.nextInt());
			insert(root.left);
		}
		System.out.println("Do you want to insert at right of "+ root.val);
		boolean right=sc.nextBoolean();
		if(right) {
			System.out.println("Enter the element");
			root.right=new Node(sc.nextInt());
			insert(root.right);
		}
	}
	
	void display(Node root) {
		if(root==null)
			 return;
		System.out.println(root.val+" ");
		display(root.left);
		display(root.right);
	}
	
	public static void main(String[]args) {
		BinaryTree tree=new BinaryTree();
		tree.display(tree.root);
	}

}
