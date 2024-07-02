package DataStructures.linkedlist;

public class DoublyLL {
    public static void main(String[] args) {
        Dll list=new Dll();
        list.insertAtFirst(23);
        list.insertAtFirst(24);
        list.insertAtFirst(25);
        list.insertAtFirst(26);
        list.insertAtFirst(27);
        list.display();

    }
}
class Dll{
    Node head;
    void insertAtFirst(int val){
        Node node=new Node(val);
        if(head==null){
            head=node;
            return;
        }
        node.next=head;
        node.prev=null;
        head.prev=node;
        head=node;
    }
    void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }


    }

    class Node{
        int data;
        Node next;
        Node prev;
        Node(int val){
            data=val;

        }

    }
}
