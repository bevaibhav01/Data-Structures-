package DataStructures.linkedlist;

public class MyLL {
    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.insertFirst(5);
        list.insertLast(4);
        list.insertLast(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.insertLast(55);
        list.insertLast(53);
        list.insertLast(33);
        list.insertLast(32);

        list.insert(23,3);
        //System.out.println(list.tail.value);
        System.out.println(list.deleteFirst());
        System.out.println(list.deleteLast());
        System.out.println(list.deleteLast());
       System.out.println(list.delete(2));
        list.display();
    }
}
class LinkedList{
    Node head;
    Node tail;
    int size;
    Node temp;
    LinkedList(){
        size=0;
    }
    void insertFirst(int input){
        Node a=new Node(input);
        a.next=head;
        head=a;
        if(tail==null) {
            tail = head;
        }
        size++;

    }
    //DO THIS INSERT LAST THIS WILL TAKE 0(1) TIME TO INSERT THE ELEMENT AT LAST
//    void insertLast(int input){
//        if(tail==null)
//             insertFirst(input);
//        else{
//            Node a=new Node(input);
//            tail.next=a;
//            tail=a;
//
//
//        }
//    }
    //DO THIS IF YOU DONT WANT TO CREAT EXTRA TAIL NODE TO POINT AT LAST THIS WILL TAKE TIME 0(N)
    void insertLast(int input){
        if(tail==null)
            insertFirst(input);
        else {
            Node t = head;
            while (t.next != null) {
                t = t.next;

            }
            Node a =new Node(input);
            t.next=a;
            tail=a;
            size++;
        }

    }
    int delete(int position){
        if(position==1)
             return deleteFirst();
        if(position==size)
             return deleteLast();
        Node a=getNode(position-1);
        int val=a.next.value;
        a.next=a.next.next;
        size--;
        return val;


    }
    int deleteLast(){
        if(size==1)
           return deleteFirst();

            Node a = getNode(size - 1);
            int b=tail.value;
            tail = a;
            tail.next = null;
            size--;
      //  System.out.println(b);
            return b;

         //return b;



    }
    Node getNode(int index){
        Node temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;

        }
        return temp;

    }
    void insert(int input,int position){
        if(position==1)
             insertFirst(input);
     else   if(position==size)
             insertLast(input);
      else {
           temp=head;
          for (int i=1;i<position-1;i++)
               temp=temp.next;
            Node node=new Node(input,temp.next);
            temp.next=node;
            size++;

        }


    }
    int deleteFirst(){
        int a=head.value;
        head=head.next;
        if(head==null)
            tail=null;
        size--;
        return a;

    }
    void display(){
         temp=head;
        while(temp!=null){
            System.out.print(temp.value+"  ");
            temp=temp.next;
        }

    }

    class Node{
        int value;
        Node next;
        Node(int input){
            value=input;
        }
        Node(int input,Node next){
            value=input;
            this.next=next;
        }

    }
}
