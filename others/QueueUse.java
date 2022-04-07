import java.util.LinkedList;
import java.util.Queue;

public class QueueUse {
	
	public static void main(String args[])
	{
		Queue<Integer> que=new LinkedList<Integer>();
		
		que.add(1);
		que.add(2);
		que.add(3);
		
		//if you want to remove head of the queue
		que.remove(); // retrieves and removes head of the queue
		que.poll();  // Retrieves and removes the head of this queue, or returns null if this queue is empty.
		
		// check whether the queue is empty or not
		//System.out.println(que.isEmpty());
		
		que.peek(); Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
	
		//que.clear();
		System.out.println(que.contains(3));  //Returns true if this collection contains the specified element
	}

}
