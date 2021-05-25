import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.math.*;



public class MyHashMap<Key, Value>
{
	private static final int INITIAL_SIZE = 25000;
	private static int MAX_ENTRY_PER_LINKED_LIST = 10;
	
    //hash map using Seperate chaining hashing
	private List<KeyValuePair<Key, Value>> [ ] cellLists; 

		
    public MyHashMap( )
    {
        this(INITIAL_SIZE);
    }
    

    @SuppressWarnings("unchecked")
    public MyHashMap( int size )
    {
    	cellLists = new LinkedList[ nextPrime( size ) ];
    	
        for( int i = 0; i < cellLists.length; i++ )
        	cellLists[ i ] = new LinkedList<KeyValuePair<Key, Value>>( );
    }


    public void put( Key key, Value val )
    {
        List<KeyValuePair<Key, Value>> targetList = cellLists[ myHashFunction( key ) ];
        
    	KeyValuePair<Key, Value> pair = new KeyValuePair<Key, Value>(key,val);
    	
        if( !targetList.contains(pair))
        {
        	
        	targetList.add(pair);

            // if any list contain more than specified numbers, rehash
        	if(targetList.size() > MAX_ENTRY_PER_LINKED_LIST)
        	{
                //System.out.println("Rehash operation initiated");
                rehash();
        	}
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public Value get(Key key)
    {
    	int listIndex = myHashFunction( key );
    	

        
    	List<KeyValuePair<Key, Value>> whichList = cellLists[listIndex];
        
        return getValueFromList(key, whichList);
        	
    }


    public Value getValueFromList( Key key, List<KeyValuePair<Key, Value>> chainedList )
    {
    	Value retVal = null; 
    	
    	for( KeyValuePair<Key, Value> pair : chainedList)
    	{
    	   // object based comparision required
    		if (pair.key.equals(key))
    	   {
    		  retVal = pair.val;
    		  break;
    	   }
    	}
    	       
        return retVal;
    }
    


    public void clear( )
    {
        for( int i = 0; i < cellLists.length; i++ )
        	cellLists[ i ].clear( );
        
    }

    
    // compute polynomial function when key contains letters from English alphabet
    // 26 letters plus space
    public int hashEnglishAlphabet(Key x)
    {
       	String key = x.toString();
       	
       	int hashVal = 0, i=0;
       	
       	
        for( i = 0; i < key.length( ); i++ )
            hashVal += 27*i*key.charAt(i);

        hashVal %= cellLists.length;
        
        if( hashVal < 0 )
            hashVal += cellLists.length;
        
        return hashVal;
    }
    
    // compute polynomial function using Horner's rule for a string
    // rule: h[k_n] = ((k_2)*37 + k_1))*37 + k0
    public int hashPolynomialHornerRule(Key x)
    {
       	String key = x.toString();
       	
       	int hashVal = 0;
       	
        for( int i = 0; i < key.length( ); i++ )
            hashVal = 37 * hashVal + key.charAt( i );

        hashVal %= cellLists.length;
        if( hashVal < 0 )
            hashVal += cellLists.length;
        
        return hashVal;
    }
    
       
    // compute hash with a object's hash code value and Mod operation
    public int hashGeneric(Key x)
    {
    	int hashVal = x.hashCode( );

        hashVal %= cellLists.length;
        
        if( hashVal < 0 )
        {
            hashVal += cellLists.length;
        }

        return hashVal;
    }
    
    

    @SuppressWarnings("unchecked")
    private void rehash( )
    {
    	List<KeyValuePair<Key, Value>> [ ]  oldCellLists = cellLists;

        // Create new double-sized, empty table
        cellLists = new List[ nextPrime( 2 * cellLists.length ) ];
        for( int j = 0; j < cellLists.length; j++ )
        	cellLists[ j ] = new LinkedList<KeyValuePair<Key, Value>>( );

        // Copy table over
        for( int i = 0; i < oldCellLists.length; i++ )
        	for( KeyValuePair<Key, Value> pair : oldCellLists[i])
                put( pair.key, pair.val );
    }

    
    private int myHashFunction( Key key )
    {
    	int hashVal = -1;
    	
        if (key instanceof String)
        	hashVal = hashPolynomialHornerRule(key);
        else
        	hashVal = hashGeneric(key);

        
        return hashVal;
    }
    


    /**
     * Internal method to find a prime number at least as large as n.
     */
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


    // Simple main
    public static void main( String [ ] args )
    {
/*    	 // example 1 format: <1,2>,<2,3> etc.
    	
    	MyHashMap<Integer,Integer> H = new MyHashMap<Integer, Integer>( );

        System.out.println( "Creating Hash Map" );
        
       //contains 1 million entries
       for( int i = 1; i < 1000000; i++ )
            H.put( i,i+1 );
       
       System.out.println( "Searching in Hash Map" );
       
       System.out.println(H.get(1));*/
       
         
/*       // example 2 format: <text1,1>,<text2,2> etc.
       MyHashMap<String,Integer> H = new MyHashMap<String, Integer>( );

       System.out.println( "Creating Hash Map" );
       
 
      for( int i = 1; i < 1000000; i++ )
           H.put( "text"+i,i );
      
      
      System.out.println( "Searching in Hash Map" );
      System.out.println(H.get("text10000"));
       */
       
     //Test java builtin hashmap
       
   	    HashMap<Integer,Integer> H = new HashMap<Integer, Integer>( );

    	System.out.println( "Java Hash Map" );
    
	   //contains 1 million entries
	   for( int i = 1; i < 3000000; i++ )
	        H.put( i,i+1 );
	   
	   System.out.println( "Searching in Hash Map" );
	   
	   System.out.println(H.get(999999));
    	
    	//Test java builtin treemap
    	
    	/* This is how to declare TreeMap */
    	
    	TreeMap<Integer, Integer> H1 = new TreeMap<Integer, Integer>();
    	System.out.println( "Java tree Map" );
        
 	   //contains 1 million entries
 	   for( int i = 1; i < 3000000; i++ )
 	        H1.put( i,i+1 );
 	   
 	   System.out.println( "Searching in Hash Map" );
 	   
 	   System.out.println(H1.get(999999));
    
    	
   
   }
    

 class KeyValuePair<Key, Value>
 {
	 Key key;
	 Value val;
	 
	 public KeyValuePair(Key key, Value val)
	 {
		 this.key = key;
		 this.val = val;
	 }
	 
 }
 
}


