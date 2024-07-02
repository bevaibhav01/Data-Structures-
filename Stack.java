package DataStructures;

public class Stack {
    int [] arr;
    int start=-1;
    static final int size=10;
    //IF SIZE IS GIVEN THIS CONSTRUCTOR
    Stack(int n){
        this.arr=new int[n];
    }
    Stack(){
        this.arr=new int[size];
    }

    void push(int item){
        if(isFull()){
            System.out.println("Stack is full");
            return;
        }
        start++;
        arr[start]=item;

    }
    boolean isFull(){
        return start==arr.length-1;
    }

    boolean isEmpty(){
        return start==-1;
    }

    int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        int a=arr[start];
        start--;
        return a;
    }
    int peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr[start];
    }




}
