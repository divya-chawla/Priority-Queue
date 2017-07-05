/*

* The Heap is a binary tree data structure that has both a structural and ordering property. 
  •The structural property is that it is a complete tree, meaning that for each level k, except the lowest level, there are exactly 
   2k-1 nodes at that level. The lowest level has all its nodes as far left as possible.
  •The ordering property is that for every node n in the tree, the comparable item contained in that node comes before the items in both the
   left and right child of n.
  The elements in the Heap implements Comparable.
  Heap is implemented through The vector class because it has all the functionality of a resizable array and it can handle generic objects.
 */

import java.util.NoSuchElementException;
import java.util.Vector;

public class Heap<E extends Comparable<E>> {
    // private data field "heapArray" is a vector which stores elements of the heap binary tree structure
	private Vector<E> heapArray;
 
    //Creates an empty heap
	public Heap() {
 	    //initializes the heapArray vector here 
        heapArray = new Vector<E>();
		//first element is null just to make insert and remove methods easy 
		heapArray.add(null);
	}
 	
 	//Returns true if the heap is empty, false if it is not
	public boolean isEmpty(){
		return size()== 0;
	}
	
	//Returns the number of items in the heap
	public int size(){
		//size of the heapArray - 1 because the first element of heapArray is null
		return heapArray.size()-1;
	}
	
	//Inserts an item into the heap
    public void insert(E item){
		//add to position 1 of heapArray if the heap is empty
		if(isEmpty()){
			heapArray.add(item);
		}
		// else add item to the correct position without disturbing structural and ordering property of heap
		else{
			// add item to the last position
			heapArray.add(item);
			// bubble up to the correct place
			bubbleUp();
		}
	}
	
	//helper method of insert to bubble up the item to the correct place
	public void bubbleUp(){
		int curIndex = size();
		int parentIndex = (curIndex)/2;
		while((parentIndex > 0) && (heapArray.get(curIndex).compareTo(heapArray.get(parentIndex)) < 0)){
			//bubble up by swaping the cur and parent
			swap(curIndex, parentIndex);
			//update values of cur and parent
			curIndex = parentIndex;
			parentIndex = curIndex/2;
		}
	}	
    //helper method that swap two items a and b( for bubble up and bubble down)
	private void swap(int a, int b){
		E temp = heapArray.get(a);
		heapArray.set(a, heapArray.get(b));
		heapArray.set(b, temp);
	}
	
	//Retrieves, without removing the top item in the root
	public E getRootItem(){
		//if the heap is empty
		if(isEmpty()){
			throw  new NoSuchElementException("The heap is empty");
		}
		//returns element at position 1 since position 0 is filled null
		return heapArray.get(1);
	}
	
	//Removes the item at the root node of the heap
	public E removeRootItem(){
		//cannot remove if heap is empty
	    if (isEmpty()){
			throw  new NoSuchElementException("The heap is empty");
        }
		else{
			E top = getRootItem();
			//copying the last element to the first element
			heapArray.set(1 , heapArray.get(size()));
			//deleting the last element
			heapArray.remove(size());
			//bubble down
			bubbleDown(1);
			//returns the removed item
			return top;
        }
	}	
	
	//helper method of removeRootItem to bubble down the item to the correct place
	public void bubbleDown(int cur){
		int left = cur * 2;
		int right = left + 1;
		int min = left;
		if(right > size()){
			if((left > size())){
				// if there are no childen, then bubbling up is over
			    return;
		    }
		}	
		//finding if right child has min value
		else{
			if(heapArray.get(left).compareTo(heapArray.get(right)) > 0){
			    min = right;
			}
		}	
		//bubbling down to correct position 
		if (heapArray.get(cur).compareTo(heapArray.get(min)) > 0) {
            swap(cur, min);
			bubbleDown(min);
        }
	}			
	
	//to print heap array
 	public String toString() {
	 	return heapArray.toString();	
 	}

	//main method to test the other methods
	public static void main(String[] args) {		
		Heap<Integer> testHeap = new Heap<Integer>();
		//inserting some numbers
		System.out.println("Inserting 4 ");
		testHeap.insert(4);
		System.out.println("Inserting 6 ");
		testHeap.insert(6);
		// testing the insert method
        System.out.println(testHeap);	
		System.out.println("Inserting 2 ");
		testHeap.insert(2);
		System.out.println(testHeap);
		//testing the getRootItem method
		System.out.println("root of the heap is now: " + testHeap.getRootItem());
		//inserting some more numbers
		System.out.println("Inserting 8 ");
		testHeap.insert(8);
		System.out.println(testHeap);
		//testing the isEmpty method
		System.out.println("Is the heap empty: " + testHeap.isEmpty());
		System.out.println("Inserting 5 ");
		testHeap.insert(5);
		System.out.println("Inserting 9 ");
		testHeap.insert(9);
		// testing the print (toString) method
		System.out.println(testHeap);
		//testing the size method
		System.out.println("Size of the heap: " + testHeap.size());
		System.out.println("Inserting 1 ");
		testHeap.insert(1);
		System.out.println(testHeap);
		//testing the getRootItem method again
		System.out.println("root of the heap is now: " + testHeap.getRootItem());	
        System.out.println(testHeap);		
		// removing the remove root method
		System.out.println("removing the root item:" + testHeap.removeRootItem());
		// testing the removeRootItem method
		System.out.println(testHeap);
		System.out.println("removing the root item:" + testHeap.removeRootItem());
		System.out.println(testHeap);
		System.out.println("removing the root item:" + testHeap.removeRootItem());
		System.out.println(testHeap);
		System.out.println("removing the root item:" + testHeap.removeRootItem());
		System.out.println(testHeap);
		System.out.println("removing the root item:" + testHeap.removeRootItem());
		System.out.println(testHeap);
		System.out.println("removing the root item:" + testHeap.removeRootItem());
		System.out.println(testHeap);
		System.out.println("removing the root item:" + testHeap.removeRootItem());
		System.out.println(testHeap);
		//testing the isEmpty method
		System.out.println("Is the heap empty: " + testHeap.isEmpty());
		System.out.println("The end!");
	}
}
