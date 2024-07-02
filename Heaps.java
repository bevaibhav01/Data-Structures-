package DataStructures;

import java.util.ArrayList;
public class Heaps {
    public static void main(String[] args) throws Exception {

        Heap<Integer> h=new Heap<>();
        h.insert(10);
        h.insert(8);
        h.insert(9);
        h.insert(7);
        h.insert(6);
        h.insert(5);
        h.insert(4);
        System.out.println(h.remove());
        System.out.println(h.heapSort());

    }
}

class Heap<T extends Comparable<T>>{

    private ArrayList<T> list;
    public Heap(){
        list=new ArrayList<>();
    }

    void swap(int i,int j){
        T temp=list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }

    int parent(int i){

        //as we are using 0 index arraylist for 1index it will be i/2
        return (i-1)/2;
    }

    int left(int i){
        return (i*2)+1;
    }
    int right(int i){
        return (i*2)+2;
    }

    public void insert(T value){
        list.add(value);
        upHeap(list.size()-1);
    }

    void upHeap(int i){
        if(i==0){
            return;
        }
        int p=parent(i);

        if(list.get(i).compareTo(list.get(p))<0){
            swap(i,p);
            upHeap(p);
        }

    }

    T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("List is empty");
        }

        T temp=list.get(0);

        T last=list.remove(list.size()-1);
        if(! list.isEmpty()){
            list.set(0,last);
            downHeap(0);
        }
        return temp;

    }

    void downHeap(int i){
        int min=i;
        int left=left(i);
        int right=right(i);

        if(left<list.size() && list.get(min).compareTo(list.get(left))>0){
           min=left;
        }


        if(right<list.size() && list.get(min).compareTo(list.get(right))>0){
            min=right;
        }
        if(min!=i){
            swap(min,i);
            downHeap(min);
        }

    }
    ArrayList<T> heapSort() throws Exception {
        ArrayList<T> res=new ArrayList<>();
        while(!list.isEmpty()){
            res.add(this.remove());
        }
        return res;
    }

}
