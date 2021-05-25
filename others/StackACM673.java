import java.util.Scanner;
import java.util.Stack;


public class StackACM673 
{
	
StringBuilder sb=new StringBuilder();
Stack<Character> st=new Stack<Character>();
  
  static final char LP='(';
  static final char RP=')';
  static final char LC='{';
  static final char RC='}';
  static final char LB='[';
  static final char RB=']';
  
	public void processInput()
	{
		Scanner sc=new Scanner(System.in);
		
/*	Scanner sc=null;
		try {
			sc = new Scanner(new File("input.txt"));
			//Scanner sc=new Scanner(System.in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		boolean invalid=false;
		int total=sc.nextInt();
		sc.nextLine();
		String x=null;
		int cases=0;
		
		
		while (cases<total)
		{
			x=sc.nextLine();
			cases++;
			
			if(x.isEmpty())
			{
				System.out.printf("Yes\n");
				continue;
			}
			sb.delete(0, sb.length());
			st.clear();
			sb.append(x);
	    
		
		invalid=false;
	
		
        for(int i=0;i<sb.length();i++)
        {
        	switch(sb.charAt(i))
        	{
        	case LP:
        	
        		st.push(sb.charAt(i));
        		break;
        		
        	case LC:
        	
        		st.push(sb.charAt(i));
        		break;
        		
        	case LB:
        		
        		st.push(sb.charAt(i));
        		break;
        		
        	case RP :
        		if(!st.isEmpty() )
        		{
        		  if(LP==st.peek())
        		    st.pop();
        		  else
          			invalid=true;
        		}
        		else
        			invalid=true;
        		break;
        		
        	case RC:
        		if(!st.isEmpty() )
        		{
        		  if(LC==st.peek())
        		    st.pop();
        		  else
          			invalid=true;
        		}
        		else
        			invalid=true;
        		break;
        		
        	case RB:
        		if(!st.isEmpty() )
        		{
        		  if(LB==st.peek())
        		    st.pop();
        		  else
          			invalid=true;
        		}
        		else
        			invalid=true;
        		break;
        		
        	default:
        		break;
        			
        	}
        	
        	if(invalid)
        		break;
        	
        }
        if(st.size()>0 || invalid)
        	System.out.printf("No\n");
        else
           	System.out.printf("Yes\n");
				
	
		}
			
	}
	
	
	
	public static void main(String args[])
	{
		StackACM673  ob =new StackACM673();
		ob.processInput();
	}

}

/*
You are given a string consisting of parentheses () and []. A string of this type is said to be correct:
(a) if it is the empty string
(b) if A and B are correct, AB is correct,
(c) if A is correct, (A) and [A] is correct.

Write a program that takes a sequence of strings of this type and check their correctness. Your
program can assume that the maximum string length is 128.


Input
The file contains a positive integer n and a sequence of n strings of parentheses ‘()’ and ‘[]’, one string
a line.


Output
A sequence of ‘Yes’ or ‘No’ on the output file.

Sample Input
3
([])
(([()])))
([()[]()])()


Sample Output
Yes
No
Yes
 */
