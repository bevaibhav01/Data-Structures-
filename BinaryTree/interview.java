package DataStructures.BinaryTree;
import java.lang.*;
import java.util.*;


public class interview {
	public static void main(String []args) {
		System.out.println("Enter the size of the array");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int array[]=new int[n];
		generateRandom(array);
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
	
		
	}
	static void generateRandom(int []array) {
		int n=array.length;
		for(int i=0;i<n;i++) {
			array[i]=i+1;
		}
		
		
		for (int i = n - 1; i > 0; i--) {
            int j = (int)Math.random()*(i+1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
	}

}
