package DataStructures.BinaryTree;

import java.util.Random;
import java.util.Scanner;

public class interview2 {
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
		Random newRandom=new Random();
		
		for (int i = n - 1; i > 0; i--) {
            int j = newRandom.nextInt(i+1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
	}


}
