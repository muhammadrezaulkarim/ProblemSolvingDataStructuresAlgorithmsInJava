
public class DynamicBionomialCoefficient 
{
    public static void main(String[] args) 
    {
        
    	DynamicBionomialCoefficient ob = new DynamicBionomialCoefficient();
        System.out.println(ob.binomialCoeff(5, 2));
    }
    
    // Returns value of Binomial Coefficient C(n, k) 
    public int binomialCoeff(int n, int k) 
    { 
	    int C[][] = new int[n+1][k+1]; 
	    int i, j; 
	      
	        // Calculate  value of Binomial Coefficient in bottom up manner 
	    for (i = 0; i <= n; i++) 
	    { 
	        for (j = 0; j <= min(i, k); j++) 
	        { 
	            // Base Cases 
	            if (j == 0 || j == i) 
	                C[i][j] = 1; 
	       
	            // Calculate value using previosly stored values 
	            else
	                C[i][j] = C[i-1][j-1] + C[i-1][j]; 
	          } 
	     } 
	       
	    return C[n][k]; 
    } 
    
    public int min(int a, int b) 
    { 
    	return (a<b)? a: b;  
    }
}
