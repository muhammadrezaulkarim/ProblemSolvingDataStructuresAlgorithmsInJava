import java.util.Stack;
public class StackUse 
{
	public static void main(String args[])
	{
		Stack<Integer> st=new Stack<Integer>(); 
		
		st.add(1);
		st.add(2);
		st.add(-1);
		
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
