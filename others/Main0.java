import java.util.*;
import java.lang.*;
import java.io.*;

class Main0
{
	public static void main (String[] args) throws java.lang.Exception
	{
		RunTests();
	}

	public static void TestTakeBetween(String testName, String input, String left, String right, boolean takeUntilEndIfRightMissing, String expected)
    {
        String output;
        try {
          output = TakeBetween(input, left, right, takeUntilEndIfRightMissing);
        } catch (Exception e){
          output = "exception";
        }
        
        if((output != null && output.equals(expected)) || (output == null && expected == null) || (expected==null && "".equals(output)))
          System.out.println("Succeeded for " + testName);
        else
        System.out.println("Failed for " + testName + ": Failed with [" + output + "] rather than [" + expected + "]");
    }
	
	public static void RunTests()
	{
	    TestTakeBetween("Simple Case", "<p>Simple case</p>", "<p>", "</p>", false, "Simple case");
	    TestTakeBetween("Flipped And False", "</p>Flipped<p>End", "<p>", "</p>", false, null);
	    TestTakeBetween("Flipped And True", "</p>Flipped<p>End", "<p>", "</p>", true, "End");
	    TestTakeBetween("Not String Ends", "Not<p>String</p>Ends", "<p>", "</p>", false, "String");
	    TestTakeBetween("Matching", "Both<p>Ends<p>Match", "<p>", "<p>", false, "Ends");
	    TestTakeBetween("No Left And False", "No Right</p>", "<p>", "</p>", false, null);
	    TestTakeBetween("No Left And True", "No Right</p>", "<p>", "</p>", true, null);
	    TestTakeBetween("No Right And False", "<p>No Right", "<p>", "</p>", false, null);
	    TestTakeBetween("No Right And True", "<p>No Right", "<p>", "</p>", true, "No Right");
	    TestTakeBetween("Regex Escaping", "lead (a+*)regex escape test(a+*)follow", "(a+*)", "(a+*)", false, "regex escape test");
	    TestTakeBetween("Multiple", "<p><p>Multiple</p></p>", "<p>", "</p>", false, "<p>Multiple");
	    TestTakeBetween("Empty Input", "", "<p>", "</p>", false, "");
	    TestTakeBetween("Empty Delim", "Something", "", "", false, "exception");
	    TestTakeBetween("Empty Middle", "<p></p>", "<p>", "</p>", false, "");
	}
	
	public static String TakeBetween(String input, String left, String right, Boolean takeUntilEndIfRightMissing)
	{
	   if(input.trim().isEmpty())
		   return "";
	   
	   if(left.trim().isEmpty() && right.trim().isEmpty())
		   return "exception";
		   
	   int leftIndex=input.indexOf(left);
	   int rightIndex=input.indexOf(right);
	    
	    if (leftIndex==-1)
	        return null;
	    
	    int modifiedLeftIndex=leftIndex + left.length();
	    
	    if(rightIndex<leftIndex && !takeUntilEndIfRightMissing)
	    	return null;
	    else if(rightIndex<leftIndex && takeUntilEndIfRightMissing)
	    {
	    	input=input.substring(modifiedLeftIndex);
	    	return input;
	    }
	        
	  //now do normal processing when right Index greater than left index
	    
	    String tempInput=input.substring(modifiedLeftIndex);
	    rightIndex=tempInput.indexOf(right);
	    rightIndex=modifiedLeftIndex + rightIndex;
	    
	    
	
	    
	     if (rightIndex==-1 && !takeUntilEndIfRightMissing)
	        return null;
	    

	    
	    if (rightIndex==-1 && takeUntilEndIfRightMissing)
	    	 input=input.substring(modifiedLeftIndex);
	    else if(rightIndex>-1 && !takeUntilEndIfRightMissing)
	    	input=input.substring(modifiedLeftIndex,rightIndex);
	    else if(rightIndex>-1 && takeUntilEndIfRightMissing)
	    	input=input.substring(modifiedLeftIndex);
	    
	    return input;
	}
}


