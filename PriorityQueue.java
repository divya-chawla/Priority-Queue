/*

* The PriorityQueue is a Queue of Comparable objects, where the item in the queue with the highest priority, determined by its
  compareTo method, is always the next item to be removed.
  It prioritizes the list of waiting patients for the ER physician.
 */


import java.util.NoSuchElementException;

public class PriorityQueue<E extends Comparable<E>> {
	// hidden Heap data structure that does all the work in each of the PriorityQueue methods.
	private Heap<E>  heap;
    //Creates an empty priority queue
	public PriorityQueue() {
	    heap = new Heap<E>();
	}

	//Inserts an item into the queue
	public void enqueue(E item){
		heap.insert(item);
	}	

	//Removes the highest priority item from the queue
    public E dequeue(){
		//cannot remove if queue is empty
		if(isEmpty()){
			throw  new NoSuchElementException("The priority queue is empty");
		}
		//remove the highest priority that is the root of the heap and return it
		return heap.removeRootItem(); 
	}	
	
	//Retrieves, but does not remove the next item out of the queue
	public E peek(){
		//cannot remove if queue is empty
		if(isEmpty()){
			throw  new NoSuchElementException("The priority queue is empty");
		}
		//returns the top most priority
		return heap.getRootItem();
	}
	
	//returns true if the queue is empty, false if it is not
	public boolean isEmpty(){
		return heap.isEmpty();
	}
	
	//printing the priority queue
	public String toString() {
	 	return heap.toString();	
 	}
	
	//main method
	public static void main(String[] args){
		ER_Patient[] patients = new ER_Patient[8];
		PriorityQueue<ER_Patient> q = new PriorityQueue<ER_Patient>();
		String[] complaints = {"Walk-in", "Life-threatening","Walk-in","Chronic","Major fracture","Walk-in", "Chronic","Life-threatening"};
		for (int i=0; i<8; i++) {
			patients[i] = new ER_Patient(complaints[i]);
			// spread out the admission times by 1 second
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("sleep interrupted");
				return;
			}
		}
		
		System.out.println("\nPatients waiting before priority:");
		for (int i=0; i<8; i++) {
			System.out.println(patients[i]);
		}
		
		for (int i=0; i<8; i++) {
			// enqueuing 8 patients in the priority queue
			q.enqueue(patients[i]);
		}
		//testing the isEmpty method
		System.out.println("\nIs the waiting list empty? : "+ q.isEmpty());
		//testing the peek method
		System.out.println("The highest priority patient is: "+ q.peek());
		//printing patients according to the priority till the queue is empty
		System.out.println("\nPatients waiting after giving appropriate priority :");
		while(!(q.isEmpty())){
			//testing the dequeue method
			System.out.print(q.dequeue());
			System.out.println();
		}
		//testing the isEmpty method
		System.out.println("Is the waiting list empty? : "+ q.isEmpty());
		
	}
}
	
