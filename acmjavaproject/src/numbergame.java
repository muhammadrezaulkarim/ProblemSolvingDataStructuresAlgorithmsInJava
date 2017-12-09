/*import java.io.File;
import java.io.FileNotFoundException;*/

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
public class numbergame  {
	
	StringBuilder sb=new StringBuilder();
  Stack<Character> st=new   Stack<Character>();
  
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
		numbergame  ob =new numbergame();
		ob.processInput();
	}

}
