import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class TreeSetTreeMapHashMapHashSet 
{
	
	public static void main(String args[])
	{
	 	/******** TreeSet with Number *****************/
		System.out.println( "...Java Tree Set 1..." );
		TreeSet<Integer> treeSetObj = new TreeSet<Integer>();
		treeSetObj.add(12);
		treeSetObj.add(63);
		treeSetObj.add(34);
		treeSetObj.add(45);
		treeSetObj.add(45);
	
		// data stored in sorted order. Print in reverse order
		//System.out.println(treeSetObj.descendingSet());
		for(Integer item : treeSetObj.descendingSet())
			System.out.println(item.intValue());
		
		
	/*	
		// immediate next number higher than the argument
		System.out.println(treeSetObj.higher(12));
		// immediate next number lower than the argument
		System.out.println(treeSetObj.lower(34));*/
	 
		// data stored in sorted order
		Iterator<Integer> iterator = treeSetObj.iterator();
		System.out.print("Tree set stored data: ");
	 
		while (iterator.hasNext()) 
		{
		
			System.out.print(iterator.next().intValue() + " ");
			//System.out.print(iterator.next().doubleValue() + " ");
		}
		
		System.out.println();
		System.out.println();
			
	 	/******** TreeSet with String *****************/
		    System.out.println( "...Java Tree Set 2..." );
			TreeSet<String> treeSetObj1 = new TreeSet<String>();
			treeSetObj1.add("Abul");
			treeSetObj1.add("Anam");
			treeSetObj1.add("Karim");
			treeSetObj1.add("Karim");
			treeSetObj1.add("Rahim");
			treeSetObj1.add("Rahim");
			

			// data stored in sorted order. Print in reverse order
			//System.out.println(treeSetObj.descendingSet());
			for(String item :  treeSetObj1.descendingSet())
				System.out.println(item);
			
			// immediate next number higher than the argument
			//System.out.println(treeSetObj1.higher("Abul"));
			
			// immediate next number lower than the argument
			//System.out.println(treeSetObj1.lower("Anam"));
		 
			// data stored in sorted order
			Iterator<String> iterator1 = treeSetObj1.iterator();
			System.out.print("Tree set stored data: ");
		 
			while (iterator1.hasNext()) 
			{
			
				System.out.print(iterator1.next() + " ");
			}
		
			
			System.out.println();
			System.out.println();
			
			
			
		   	/******** TreeMap *****************/
	    	
	    	TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
	    	System.out.println( "...Java Tree Map..." );
	        
	 	   //contains 1 million entries
	 	   for( int i = 1; i < 5; i++ )
	 		  treeMap.put( i,i+1 );
	 	   
	 	   System.out.println( "Searching in Tree Map" );
	 	   
	 	   System.out.println(treeMap.get(2));
	 	   
	 	   System.out.println( "Keys contain in the Tree Map" );
	 	   // print keys
	 	   for(Integer item : treeMap.keySet())
			 System.out.println(item.intValue());
		   

	 	   // print values
	 	   for(Integer item : treeMap.values())
			 System.out.println(item.intValue());
	 	   
	 	  
/*	 	    Display content using Iterator
	       Set set = treeMap.entrySet();
	    
	       Iterator iteratorTreeMap =  set.iterator();
	       while(iterator.hasNext()) {
	          Map.Entry mentry = (Map.Entry)iteratorTreeMap.next();
	          System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
	          System.out.println(mentry.getValue());
	       }*/
	       
	       for (Map.Entry<Integer, Integer> entry1 : treeMap.entrySet()) {
			    System.out.println(entry1.getKey() + " = " + entry1.getValue());
	       }
	       
	       System.out.println();
	       System.out.println();
	       
	       
	       
		   	/******** HashSet *****************/
	       System.out.println( "...Java Hash Set...." );
	       Set<String> daysOfWeek = new HashSet<>();

	        // Adding new elements to the HashSet
	        daysOfWeek.add("Monday");
	        daysOfWeek.add("Tuesday");
	        daysOfWeek.add("Wednesday");
	        daysOfWeek.add("Thursday");
	        daysOfWeek.add("Friday");
	        daysOfWeek.add("Saturday");
	        daysOfWeek.add("Sunday");

	        // Adding duplicate elements will be ignored
	        daysOfWeek.add("Monday");

	        //System.out.println(daysOfWeek);
	        
	        
		    Iterator iteratorHashSet =  daysOfWeek.iterator();
		    while(iteratorHashSet.hasNext()) 
		    {

		        System.out.println(iteratorHashSet.next());
		    }
		
		    System.out.println();
		    System.out.println();
		    
		    
		    /******** HashMap *****************/
		    System.out.println( "...Java Hash Map...." );
		    Map<String, String> map = new HashMap<String, String>();
			map.put("key1", "value1");
			map.put("key2", "value2");
			
			System.out.println( "Searching in Hash Map" );
		 	System.out.println(treeMap.get(2));
		 	   
			System.out.println( "Printing Hash Map contents" );
			for (Map.Entry<String, String> entry : map.entrySet()) 
			{
			    System.out.println(entry.getKey() + " = " + entry.getValue());
			}
	}

}
