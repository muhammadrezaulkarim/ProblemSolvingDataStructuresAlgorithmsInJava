
public class MathMinimumFactorization 
{
	
    public int smallestFactorization(int a) 
    {
        if (a < 2)
            return a;
        
        long res = 0, mul = 1;
        for (int i = 9; i >= 2; i--) 
        {
            while (a % i == 0) 
            {
                a /= i;
                res = mul * i + res;
                mul *= 10;
            }
        }
        
        return a < 2 && res <= Integer.MAX_VALUE ? (int)res : 0;
    }

}

/*
Problem:

Given a positive integer a, find the smallest positive integer b whose multiplication of each digit equals to a.

If there is no answer or the answer is not fit in 32-bit signed integer, then return 0.


Input:
48 
Output:
68


Input:
15
Output:
35

*/

/* Solution:
	
We know that the final number generated, res, should be such that its digits should have a product equal to the given number a. 
In other words, the digits of res will be the factors of the given number a. 
Thus, our problem reduces to finding the factors(not necessarily prime) of a and finding their smallest possible arrangement. 

Thus, we start with trying with the largest possible factor 99, obtain as many such counts of this factor as possible in res 
and place such factors obtained at its least significant positions. 

Then, we go on decrementing the number currently considered as the possible factor 
and if it is a factor, we keep on placing it at relatively more significant positions in res. 
We go on getting such factors till we are done considering all the numbers from 9 to 2. At the end, resres gives the required result.  

comment ???:
I think the last line: return a < 2 && res <= Integer.MAX_VALUE ? (int)res : 0;
use a < 10 is more understandable then a < 2, since a < 10 means the remaining a has to contains only one digit to meet the algorithm

*/