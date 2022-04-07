import java.util.Stack;
public class StackUse 
{
	public static void main(String args[])
	{
		Stack<Integer> st=new Stack<Integer>(); 
		
		st.push(1); //Pushes an item onto the top of this stack
		st.push(2);
		st.push(-1);  
		
		st.pop(); //Removes the object at the top of this stack and returns that object as the value of this function.
		
		st.search(-1); // returns how far an item is from the top. the topmost item on the stack is considered to be at distance 1.
		
		// check whether the stack is empty or not
		//st.isEmpty()
		//System.out.println(st.size());  // print the current size
		 st.clear();
		
		//System.out.println(st.peek()); // inspect the top of the stack but do not remove it
		
		System.out.println(st.size()); 
		System.out.println(st.contains(-1)); 
		
		
		
		// StringBuilder Example
		StringBuilder sb = new StringBuilder();
		sb.append('a');
		sb.append('b');
		
		sb.delete(0, sb.length());
	}
}
