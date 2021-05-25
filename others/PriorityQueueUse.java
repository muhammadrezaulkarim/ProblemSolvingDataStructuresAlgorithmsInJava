import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Comparator;

public class PriorityQueueUse 
{
	public static void main(String args[])
	{
  
		PriorityQueueUse ob = new PriorityQueueUse();
		ob.testBuiltInObjectPriorityQueue();
		ob.testCustomObjectPriorityQueue();

  	}
	
	
	public void testBuiltInObjectPriorityQueue()
	{
		/*** Java Priority queue MinHeap example  ***/
		
		// Create a Priority Queue. Java Prioriy queue is a Min heap Queue by default
		// Java PriorityQueue is a min heap, which means the head of the queue is the minimum value. 
		// To make java PriorityQueue a max heap, which means the head of the queue is the item with maximum value, 
		// We must use customized comparator. 
		
		System.out.println("***Java Priority queue MinHeap example***");
		PriorityQueue<Integer> pqueue = new PriorityQueue<>();

        // ENQUEUE
        pqueue.add(750);
        pqueue.add(500);
        pqueue.add(900);
        pqueue.add(100);
        

        System.out.println("Print initial priority queue");
        
        Iterator queIterator = pqueue.iterator();
    
        while (queIterator.hasNext())
        	System.out.print(queIterator.next() + " ");
        
        System.out.println();
        System.out.println("Removing the head of the queue");
        // retrieves and  remove the head of the queue
        System.out.println(pqueue.poll());
        
        
        // DEQUEUE
        System.out.println("Removing elements one by one");
        while (!pqueue.isEmpty()) 
        {
            System.out.println("removed: " + pqueue.remove());
        }
        
        // retrieves but does not remove the head of the queue
        //pqueue.peek();
        
        
        /*** Java Priority queue MaxHeap example  ***/
        
        System.out.println();
        System.out.println("****Java Priority queue MaxHeap example***");
        
        PriorityQueue<Integer> pqueueMaxHeap = new PriorityQueue<>(new Comparator<Integer>() 
        		{
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        
        // ENQUEUE
        pqueueMaxHeap.add(750);
        pqueueMaxHeap.add(500);
        pqueueMaxHeap.add(900);
        pqueueMaxHeap.add(100);
        

        System.out.println("Print initial priority queue");
        
        Iterator queIterator1 = pqueueMaxHeap.iterator();
    
        while (queIterator1.hasNext())
        	System.out.print(queIterator1.next() + " ");
        
        System.out.println();
        System.out.println("Removing the head of the queue");
        // retrieves and  remove the head of the queue
        System.out.println(pqueueMaxHeap.poll());
        
        
        // DEQUEUE
        System.out.println("Removing elements one by one");
        while (!pqueueMaxHeap.isEmpty()) 
        {
            System.out.println("removed: " + pqueueMaxHeap.remove());
        }
	}
	
	public void testCustomObjectPriorityQueue()
	{
        
        /*** Java Priority queue with object  comparator***/
	    System.out.println();
	    System.out.println("****Java Priority queue custom object example***");
        
        PriorityQueue<Task> maxHeap2 = new PriorityQueue<>(new Comparator<Task>(){
        	 
            @Override
            public int compare(Task o1, Task o2) {
                return o2.priority.compareTo(o1.priority);
            }
        });
 
        // add objects one by one
        for(int i = 0; i < 5; i++) {
        	Task obj = new Task(i, "task-"+i);
            maxHeap2.add(obj);
        }

        System.out.println("Print initial priority queue");
        
       
        Iterator queIterator1 = maxHeap2.iterator();
    
        while (queIterator1.hasNext())
        	System.out.println(queIterator1.next());
        
        
        // remove the head of the queue
        System.out.println("Removing the head of the queue");
        System.out.println(maxHeap2.poll());
        
        
	}
	
	
	class Task implements Comparable<Task> 
	{
	    Double priority;
	    String name;
	 
	    Task(double priority, String name) {
	        this.priority = priority;
	        this.name = name;
	    }
	 
	    @Override
	    public int compareTo(Task o) {
	        return priority.compareTo(o.priority);
	    }
	 
	} 

}


