import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Comparator;

public class PriorityQueueUseLambda
{
	public static void main(String args[])
	{
  
		PriorityQueueUseLambda ob = new PriorityQueueUseLambda();
		ob.testBuiltInObjectPriorityQueue();

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
		/*
		 * Iterator queIterator = pqueue.iterator();
		 * 
		 * while (queIterator.hasNext()) System.out.print(queIterator.next() + " ");
		 */
        
        
        pqueue.stream().forEach((entry) -> entry.intValue());
        
        
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
        
        System.out.println(String.format("Current Size: %s", pqueue.size()));
        
        // retrieves but does not remove the head of the queue
        //pqueue.peek();
        
        
        /*** Java Priority queue MaxHeap example  ***/
        
        System.out.println();
        System.out.println("****Java Priority queue MaxHeap example***");
        
		/*
		 * PriorityQueue<Integer> pqueueMaxHeap = new PriorityQueue<>(new
		 * Comparator<Integer>() {
		 * 
		 * @Override public int compare(Integer o1, Integer o2) { return
		 * o2.compareTo(o1); } });
		 */

        PriorityQueue<Integer> pqueueMaxHeap = new PriorityQueue<Integer>((Integer o1, Integer o2) -> o2.compareTo(o1));
        // ENQUEUE
        pqueueMaxHeap.add(750);
        pqueueMaxHeap.add(500);
        pqueueMaxHeap.add(900);
        pqueueMaxHeap.add(100);
        

        System.out.println("Print initial priority queue");
        
		/*
		 * Iterator queIterator1 = pqueueMaxHeap.iterator();
		 * 
		 * while (queIterator1.hasNext()) System.out.print(queIterator1.next() + " ");
		 */
        pqueueMaxHeap.stream().forEach((entry) -> entry.intValue());
        
        
        System.out.println();
        System.out.println("Removing the head of the queue");
        // retrieves and  remove the head of the queue
        System.out.println(pqueueMaxHeap.poll());
        
        
        // DEQUEUE
        System.out.println("Removing elements one by one");
        while (!pqueueMaxHeap.isEmpty()) 
        {
            System.out.println("removed: " + pqueueMaxHeap.poll());
        }
        
        System.out.println(String.format("Current Size: %s", pqueueMaxHeap.size()));
	}
	

}
