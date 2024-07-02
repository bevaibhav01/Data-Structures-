package DataStructures.BinaryTree;
import java.util.*;

//import BinaryTree.BinaryTree.Node;

public class CreateTreeUsingLevelOrder {
	public static void main(String []args) {
		String []arr= {"1","2","3","4","5","6"," "};
		Node root=constructTree(arr);
		display(root);
		
	}
	static Node constructTree(String arr[]){
		Queue<Node> q=new LinkedList<>();
		Node node=new Node(Integer.parseInt(arr[0]));
		q.add(node);
		int i=1;
		
		
		while(i<arr.length-1) {
			if(arr[i]!=" ")
			{
				q.peek().left=new Node(Integer.parseInt(arr[i]));
				q.add(q.peek().left);
			}
			if(arr[i+1]!=" ")
			{
				q.peek().right=new Node(Integer.parseInt(arr[i+1]));
				q.add(q.peek().right);
			}
			q.remove();
			i+=2;
			
			
			
		}
		return node;
		
		
		
		
		
	}
	static void display(Node root) {
		if(root==null)
			 return;
		System.out.print(root.val+" ");
		display(root.left);
		display(root.right);
	}

}
class Node{
	
	int val;
	Node left;
	Node right;
	
	Node(int val){
		this.val=val;
	}
	
}
