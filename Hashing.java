package DataStructures;

import java.util.*;

public class Hashing {
    public static void main(String[] args) {
        HashMap1<String,Integer> hm=new HashMap1<>();
//        hm.put("vaibhav",71);
//        hm.put("deep",73);
//        hm.put("ronak",72);
//        hm.put("krish",74);
//        hm.put("ksh",74);
//        hm.put("krsh",74);
//        hm.put("kadadrish",74);
//        hm.put("ksdsh",74);
//        
//        hm.put("krdsdish",74);
//        hm.put("kzcvrish",74);
//        hm.put("kxcxrish",74);
//        hm.put("kradadadadadish",74);
//        hm.put("krzcczish",74);
        
       // hm.put("krish",74);
       // System.out.println(hm);
        System.out.println(hm.remove("vaibhav"));
        System.out.println(hm.remove("vaibhav"));
        System.out.println(hm.isEmpty());
        
        
        //For iteration we can use it to store all the keys in key set and then iterate through it.
//        Set<String> keys= hm.keySet();
//        //System.out.println(keys);
//        for(String k:keys) {
//        	System.out.println(k);
//        }
        
    }

}
class HashMap1<K,V>{
	class node{
		K key;
		V value;
		
		node(K key, V value){
			this.key=key;
			this.value=value;
		}
	}
	int N;
	int n;
	LinkedList<node> buckets[];
	@SuppressWarnings("unchecked")
	HashMap1(){
		N=4;
		n=0;
		buckets=new LinkedList[4];
		for(int i=0;i<4;i++) {
			buckets[i]=new LinkedList<>();
		}
	}
	
	int hashFunction(K key) {
		int bi=key.hashCode();
		return Math.abs(bi)%N;
	}
	int search(K key,int bi) {
		LinkedList<node> ll=buckets[bi];
		for(int i=0;i<ll.size();i++) {
			node n=ll.get(i);
			if(n.key==key) {
				return i;
			}
		}
		return -1;
	}
	void put(K key, V value) {
		int bi=hashFunction(key);
		int sl=search(key,bi);
		if(sl!=-1) {
			node n=buckets[bi].get(sl);
			n.value=value;
		}
		else {
			buckets[bi].add(new node(key,value));
			n++;
			
		}
		double lambda=(double)n/N;
		if(lambda>2.0) {
			reHash();
		}
		
	}
	V get(K key) {
		int bi=hashFunction(key);
		int sl=search(key,bi);
		if(sl!=-1) {
			node n=buckets[bi].get(sl);
			return n.value;
		}
		return null;
	}
	boolean containsKey(K key) {
		int bi=hashFunction(key);
		int sl=search(key,bi);
		if(sl!=-1) {
			return true;
		}
		return false;
	}
	
	V remove(K key) {
		int bi=hashFunction(key);
		int sl=search(key,bi);
		if(sl!=-1) {
			node n=buckets[bi].remove(sl);
			this.n--;
			return n.value;
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	void reHash() {
		System.out.println("fffurum");
		LinkedList<node> oldBucket[]=buckets;
		buckets=new LinkedList[2*N];
		N=2*N;
		for(int i=0;i<buckets.length;i++) {
			buckets[i]=new LinkedList<>();
			
		}
		
		for(int i=0;i<oldBucket.length;i++) {
			LinkedList<node> ll=oldBucket[i];
			for(int j=0;j<ll.size();j++) {
				node n=ll.get(j);
				put(n.key,n.value);
			}
		}
		
	}
	boolean isEmpty() {
		return n==0;
	}
}
