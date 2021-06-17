import java.util.*;
import java.time.*;
import java.text.*;

public class NWayAssociativeCache<K,V>
{
    private int associativity;
    private int numSets;
    private Entry<V>[] entries;
   
   
    public NWayAssociativeCache(int associativity, int cacheSize)
    {
        this.associativity = associativity;  // how many cache blocks each set can have
        this.numSets = cacheSize/associativity; // determine the number of sets
       
        this.entries = new Entry[associativity * numSets];
       
        for (int i = 0; i < entries.length; i++) {
            entries[i] = new Entry<V>();
        }
    }
   
   
    public V get(K key)
    {
        int hashCode = hash(key); //use the object hash code as a tag
        int setNumber =  hashCode % this.numSets;
       
        int startIndex = setNumber * associativity;
        int endIndex = startIndex + associativity - 1;
       
       
        for(int i=startIndex; i<=endIndex; i++)
        {
            if(this.entries[i].occupied == true && this.entries[i].tag == hashCode)
            {
               
                this.entries[i].referenceTime = Instant.now();  //update reference time
                return this.entries[i].value;
            }
        }
       
        return null;
    }
   
    public void put(K key, V value)
    {
        int hashCode = hash(key); //use the object hash code as a tag
        int setNumber =  hashCode % this.numSets;
       
        int startIndex = setNumber * associativity;
        int endIndex = startIndex + associativity - 1;
       
        Entry<V> newEntry = new Entry<V>(value, Instant.now(), hashCode, true);
       
        // the entry already is in the cache
        for(int i=startIndex; i<=endIndex; i++)
        {
            if(this.entries[i].occupied && this.entries[i].tag == hashCode)
            {
               
                this.entries[i]  = newEntry;
                return;
            }
        }
       
        // An unoccupied entry found
        for(int i=startIndex; i<=endIndex; i++)
        {
            if(!this.entries[i].occupied)
            {
               
                this.entries[i]  = newEntry;
                return;
            }
        }
       
        // all entries occupied, we need apply an eviction policy
        int evictIndex = getEvictionEntryIndex(setNumber);
        this.entries[evictIndex] = newEntry;
    }
   
    // Cache replacement policy
    // Get least recently used or most recently used entry
    // LRU used here
    public int getEvictionEntryIndex(int setNumber)
    {
        int startIndex = setNumber * associativity;
        int endIndex = startIndex + associativity - 1;
       
        int lruIndex = startIndex;
        long lruTimeStamp = this.entries[startIndex].referenceTime.toEpochMilli();
       
        for(int i=startIndex+1; i<=endIndex; i++)
        {
            if(this.entries[i].referenceTime.toEpochMilli() < lruTimeStamp)
            {
                lruIndex = i;
                lruTimeStamp = this.entries[i].referenceTime.toEpochMilli();
            }
        }
       
        return lruIndex;
    }
   
   
    public int hash(K key)
    {
       return hashPolynomialRolling(key);
    }
   
   
    public int hashPolynomialRolling(K key)
    {
        int p = 53; // polynomial
        String str = key.toString();
        int hashVal = 0;
         
        for(int i = 0; i < str.length(); i++ )
            hashVal += str.charAt(i)*Math.pow(p, i);
               
        return hashVal;
    }
   
   
    public static void main(String []args){
        NWayAssociativeCache<String,String> ob = new NWayAssociativeCache<String,String>(2, 4);
        ob.put("a","a-val");
        ob.put("b","b-val");
        ob.put("c","c-val");
       
        System.out.println("Checking cache entries: ");
        System.out.println(ob.get("c"));
    }
     
    class Entry<V>
    {
        V value;
        Instant referenceTime;
        int tag;
        boolean occupied;
       
       
        public Entry()
        {
            this.value = null;
            this.referenceTime = null;
            this.tag = -1;
            this.occupied = false;
        }
       
        public Entry(V value, Instant referenceTime, int tag, boolean occupied) {
            this.value = value;
            this.referenceTime = referenceTime;
            this.tag = tag;
            this.occupied = occupied;
        }
    }
}
