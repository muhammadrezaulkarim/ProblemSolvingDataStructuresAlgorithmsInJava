import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;


public class MathCommonFunctions 
{
	
    private static int nextPrime( int n )
    {
        // if even number, increment to start with a odd number
    	if( n % 2 == 0 )
            n++;

        while(!isPrime(n))
        	n += 2 ;

        return n;
    }


    private static boolean isPrime( int n )
    {
        if( n == 2 || n == 3 )
            return true;

        if( n == 1 || n % 2 == 0 )
            return false;

        int sqrtN = (int)Math.sqrt((double) n);
        
        for( int i = 3; i <= sqrtN ; i += 2 )
            if( n % i == 0 )
                return false;
        
        return true;
    }
    
    public static int gcd(int num1, int num2)
    {
    	return num2==0? num1:gcd(num2, num1%num2);
    }
    
    public static int lcm(int num1, int num2)
    {
    	return num1*(num2/gcd(num1,num2));
    }
    
    
    public static int fibonacci(int n)
    {
    	if (n==0)
    		return 0;
      	
    	if (n==1)
    		return 1;
    	
    	
    	int [] memo = new int[n];
    	
    	memo[0] = 0;
    	memo[1] = 1;
    	
    	for(int i=2;i<n;i++)
    		memo[i] = memo[i-1] + memo[i-2];
    
        return memo[n-1] +memo[n-2];    
    }
    
    
    public static int factorial(int n)
    {
    	if (n==0)
    		return 1;
    	else
    	   return n*factorial(n-1);
    	
    }
    
    // Returns value of Binomial  Coefficient o C(n, k) 
    public static int binomialCoeff(int n, int k)  
    { 
        // Base Cases 
        if (k == 0 || k == n) 
            return 1; 
          
        return binomialCoeff(n - 1, k - 1) +  binomialCoeff(n - 1, k); 
    } 
    
    public static void bigIntegerOperations()
    {
 
    	BigDecimal tax = new BigDecimal("980000000000000000000009.0084578639");
    	tax = tax.setScale(2, RoundingMode.CEILING);
    	//RoundingMode.FLOOR

    	BigDecimal arbitraryVal = new BigDecimal("100000000000000000000009.0084578639");
    	arbitraryVal = arbitraryVal.setScale(2, RoundingMode.CEILING);
    			
    	System.out.println(arbitraryVal.toBigInteger());
    			
    	BigInteger num1=new BigInteger("50000000000000000000000000");
    	BigInteger num2=new BigInteger("10000000000000000000000000");
    	System.out.println(num1.add(num2));
    		
    	
    	BigInteger numOne=BigInteger.ONE;  // assignment
    			
    	System.out.println("remainder:");
    	BigInteger remainder = num2.mod(num1);
    	System.out.println(remainder);
    			
    	System.out.println("power:");
    	BigInteger power = num1.pow(3);
    	System.out.println(power);
    }
    
    

}
