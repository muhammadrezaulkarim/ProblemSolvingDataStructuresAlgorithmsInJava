import java.util.ArrayList;
import java.util.Scanner;

public class Permutation 
{
	static String number1, number2;
    static ArrayList<Integer> number1List = new ArrayList<Integer>(), number2List = new ArrayList<Integer>();
     
	static int [] num1, num2;
	static Scanner sc=null;
	
	static Boolean [] flag ;
    static Boolean foundFlag = false;
	
	static int[] permutationHolder;
    static char[] permutationCharHolder;
	
	public static void main(String args[])
	{
		try
		{
			// foundFlag = false;
			sc=new Scanner(System.in);
			number1=sc.nextLine();
			number2=sc.nextLine();
		    GenerateAndCheckWithPermutation();
		    
		    // if (foundFlag == true)
            //   System.out.println("YES");
           //else
              // System.out.println("NO"); 
			
		}
		catch(Exception ex)
		{
			
		}

	}
	
    public static void GenerateAndCheckWithPermutation()
    {
        char[] cr = new char[1];
        cr[0] = ' ';

        String[] inputNumbers1 = number1.split(" ");
        String[] inputNumbers2 = number2.split(" ");

        for (int i = 0; i < inputNumbers1.length; i++)
        {
            if (!inputNumbers1.equals(" "))
                number1List.add(Integer.parseInt(inputNumbers1[i]));

            if (!inputNumbers2.equals(" "))
            	 number2List.add(Integer.parseInt(inputNumbers2[i]));
        }


        
        num1 = new int [number1List.size()];
        num2 = new int [number2List.size()];
        
        for(int i=0;i<num1.length;i++)
        {
        	  num1[i]=number1List.get(i);
        	  num2[i]=number2List.get(i);
        }


        // permuteDigits(num1, 0, num1.Length - 1);

      flag = new Boolean[num1.length];
      permutationHolder = new int[num1.length];

      for (int i = 0; i < flag.length; i++)
      {
            flag[i] = false;
      }
        // only required if we are matching with a specific number
       // foundFlag = false;  
        for (int i = 0; i < num1.length; i++)
        {
            //	second parameter level=0;
            permuteDigit(i, 0);
           // permuteWithNumber(i, 0);
            
            // only required if we are matching with a specific number
           // if (foundFlag == true)
            // break;
        }

    }
  /* //number 1 is a string 
    public static void permuteChar(int k, int posInNextPerm)
    {
        //permutationHolder: holds the next permutation
        flag[k] = true; //at the beginning set the flag to true
        permutationCharHolder[posInNextPerm] = number1.charAt(k);
        posInNextPerm++;

        if (posInNextPerm == number1.length())
        {
            
            flag[k] = false; //before returning set the flag to false

            System.out.println();
            for (int l = 0; l < permutationCharHolder.length; l++)
                System.out.print(permutationCharHolder[k] + " ");

            return; // we have reached the limit of nextPermutation index. need to backtrack
        }


        for (int i = 0; i < number1.length(); i++)
        {
            if (flag[i] == false)
            {
                //permuteDigit(i, posInNextPerm);
                permuteWithNumber(i, posInNextPerm);
            }
        }

        flag[k] = false; //before returning set the flag to false
    } */
    
    public static void permuteDigit(int k, int posInNextPerm)
    {
        //permutationHolder: holds the next permutation
        flag[k] = true; //at the beginning set the flag to true
        permutationHolder[posInNextPerm] = num1[k];
        posInNextPerm++;

        if (posInNextPerm == num1.length)
        {
            
            flag[k] = false; //before returning set the flag to false

            System.out.println();
            for (int l = 0; l < permutationHolder.length; l++)
                System.out.print(permutationHolder[l] + " ");

            return; // we have reached the limit of nextPermutation index. need to backtrack
        }


        for (int i = 0; i < num1.length; i++)
        {
            if (flag[i] == false)
            {
                permuteDigit(i, posInNextPerm);
                //permuteWithNumber(i, posInNextPerm);
            }
        }

        flag[k] = false; //before returning set the flag to false
    }
    

    public static void permuteWithNumber(int k, int posInNextPerm)
    {
        //permutationHolder: holds the next permutation
        // only required if we are matching with a specific number
        // if (foundFlag == true)
        // return;

        flag[k] = true;
        permutationHolder[posInNextPerm] = num1[k];
        posInNextPerm++;

        if (posInNextPerm == num1.length)
        {

            flag[k] = false; //before returning set the flag to false
            
            // print the permutation

            System.out.println();
            for (int l = 0; l < permutationHolder.length; l++)
            	 System.out.print(permutationHolder[l] +" " );

            // This part is required if we are matching with a specific number
            /* int matchCount = 0;
                          for (int l = 0; l < permutationHolder.length; l++)
                              if (permutationHolder[l] == num2[l])
                                  matchCount++;
                          if (matchCount == num2.length)
                          {
                              foundFlag = true;
                        
                          } */

            return;  // we have reached the limit of nextPermutation index. need to backtrack
        }


        for (int i = 0; i < num1.length; i++)
        {
            if (flag[i] == false)
            {
                permuteWithNumber(i, posInNextPerm);
            }
        }

        flag[k] = false; //before returning set the flag to false
     }

}
