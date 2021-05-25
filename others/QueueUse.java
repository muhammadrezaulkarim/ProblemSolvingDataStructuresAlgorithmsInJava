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
		que.remove(); //remove head e.g. 1
		
		// check whether the queue is empty or not
		//System.out.println(que.isEmpty());
		
		System.out.println(que.peek()); // retrieves but do not remove head of the queue
		//System.out.println(que.poll()); // retrieves and removes head of the queue
		//que.clear();
		System.out.println(que.contains(3));  //Returns true if this collection contains the specified element
	}

}
