public class Solution 
{
	    public int solution(int A, int B)
	    {
	        // write your code in Java SE 8
	        int result=getDecimalZip(A,B);
	        return result;
	    }
	    
	    public int getDecimalZip(int A, int B)
	    {
	        String firstNumber=String.valueOf(A);
	        String secondNumber=String.valueOf(B);
	        
	        int firstNumLength=firstNumber.length();
	        int secondNumLength=secondNumber.length();

	        StringBuilder decimalZipContainer=new StringBuilder();
	        int index=0;
	        
	        int indexNum1=0;
	        int indexNum2=0;
	        
	        while (index<firstNumLength + secondNumLength)
	        {
	          
	            if(index%2==0)
	            {
	                if(indexNum1<firstNumLength)
	                {
	                	
	                    decimalZipContainer.append(firstNumber.charAt(indexNum1));
	                    indexNum1++;
	                }
	                else
	                	break;
	            }
	            
	            if(index%2==1)
	            {
	                if(indexNum2<secondNumLength)
	                {
	                	
	                    decimalZipContainer.append(secondNumber.charAt(indexNum2));
	                    indexNum2++;
	                }
	                else
	                	break;
	            }
	            index++;
	        }
	        
	        decimalZipContainer.append(firstNumber.substring(indexNum1));
	        decimalZipContainer.append(secondNumber.substring(indexNum2));
	        
	        int decimalZipFinal= Integer.parseInt(decimalZipContainer.toString());
	        return decimalZipFinal;
	        
	    }
	

	public static void main(String args[])
	{
		Solution  ob=new Solution();
		System.out.println(ob.getDecimalZip(1, 6)); // expected output: 1652, actual output: 1652
		System.out.println(ob.getDecimalZip(15, 62)); // expected output: 1652, actual output: 1652
		System.out.println(ob.getDecimalZip(10, 29)); // expected output: 1209, actual output: 1209
		System.out.println(ob.getDecimalZip(1567, 62)); // expected output: 165267, actual output: 165267
		System.out.println(ob.getDecimalZip(14, 3299)); // expected output: 134299, actual output: 134299
	}


}
