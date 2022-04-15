import java.util.Scanner;

public class Permutation 
{
	private static String inputStr; 
	private static Boolean [] flag ;

	private StringBuilder permutationHolder = new StringBuilder();

	public static void main(String args[])
	{
        Scanner sc = null;

		try
		{
			sc = new Scanner(System.in);
			inputStr = sc.nextLine();
		   
            flag = new Boolean[inputStr.length()];

            for (int i = 0; i < flag.length; i++)
            {
                flag[i] = false;
            }

            System.out.println();

            Permutation permGenerator = new Permutation();

            // requires to search for a sepecific string
           // boolean found = false;

            for (int i = 0; i < inputStr.length(); i++)
            {

               permGenerator.permuteChar(i);

               /*
               // search for a sepcific string
               found = permGenerator.findStringWithPermuation(i, "dbca");

               if(found)
               {
                   System.out.println("found");
                   break;
               } */
            }		
		}
		catch(Exception ex)
		{
			
		}
        finally {
            if(sc != null) {
                sc.close();
            }
        }
	}

    public void permuteChar(int k)
    {
        //permutationHolder: holds the next permutation
        flag[k] = true; //at the beginning set the flag to true
        permutationHolder.append(inputStr.charAt(k));

        int currentLength = permutationHolder.toString().length();

        if (currentLength == inputStr.length())
        {     
            System.out.println(permutationHolder.toString());

            //before returning set the flag to false so that the symbol can be reached again in the search
            flag[k] = false; 

            // backtrack: remove the character appended in this call to the current permuation.
            permutationHolder.delete(currentLength-1, currentLength); // end index exclusive

            return; // need to backtrack
        }


        for (int i = 0; i < inputStr.length(); i++)
        {
            if (flag[i] == false)
            {
                permuteChar(i);
            }
        }

        //before returning set the flag to false so that the symbol can be reached again in the search
        flag[k] = false; 

        // backtrack: remove the character appended in this call to the current permuation.
        permutationHolder.delete(currentLength-1, currentLength); // end index exclusive
    } 

    
    public boolean findStringWithPermuation(int k, String targetStr)
    {
        //permutationHolder: holds the next permutation
        flag[k] = true; //at the beginning set the flag to true
        permutationHolder.append(inputStr.charAt(k));

        int currentLength = permutationHolder.toString().length();

        if (currentLength == inputStr.length())
        {     

            //before returning set the flag to false so that the symbol can be reached again in the search
            flag[k] = false; 

            if(permutationHolder.toString().equals(targetStr)) 
            {
                // backtrack: remove the character appended in this call to the current permuation.
                permutationHolder.delete(currentLength-1, currentLength); // end index exclusive

                return true;
            }
            else
            {
                // backtrack: remove the character appended in this call to the current permuation.
                permutationHolder.delete(currentLength-1, currentLength); // end index exclusive

                return false;
            }
        }


        for (int i = 0; i < inputStr.length(); i++)
        {
            if (flag[i] == false)
            {
                boolean found = findStringWithPermuation(i, targetStr);
                
                if(found) // prune the search space
                    return true;
            }
        }

        //before returning set the flag to false so that the symbol can be reached again in the search
        flag[k] = false; 

        // backtrack: remove the character appended in this call to the current permuation.
        permutationHolder.delete(currentLength-1, currentLength); // end index exclusive

        return false;
    }
}
