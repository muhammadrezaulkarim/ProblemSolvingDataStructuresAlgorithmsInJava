import java.util.*;

/*
We are given a set of coins of various denominations.
We need to use these coins to accumulate a sum of money using the minimum (or optimal) number of coins. 
A particular denomination has an infinite number of coins. 

*/

public class DynamicCoinChange
{
    public static int DPMinimumCoins(int amount)
    {
        // available denominations
         int [] denominations = {1, 3, 4, 5};
         int [] dp = new int[amount+1];
    
        //Setting the first element to 0
        //when the amount is zero, we cannot select any coin
        dp[0] = 0;
        
        for(int i = 1; i<=amount; i++)
        {
            for(int j = 0; j<denominations.length; j++)
            {
               // if the denomination value less than or equal to the amount,
               // the denomination can be selected
                if(denominations[j] <= i)
                {
                    if(j == 0) // edge case
                        // no need to compare with dp[i] as no coins has been selected yet
                        // j=0 is the first denomination index, dp[i] will be initialized
                        dp[i] = dp[i-denominations[j]] + 1;
                    else
                        // needs comparision with dp[i] as other demonitations has been tried
                        // for each amount, we need to try all denomination and find the minimum
                        dp[i] = Math.min(dp[i], dp[i-denominations[j]] + 1); // 1 means 1 coin selected
                }
                
            }
        }
    
        return dp[amount];
    }

    public static void main(String args[])
    {
        System.out.println(DPMinimumCoins(12));
    }
}
