/* MRU cache replacement algorithm:

Store cache items in order of access inside a doubly-linked list so that the
most-recently-used element is stored at the head position and
the least-recently-used element is stored at the tail
when we fill up the cache we make room for the new element
by evicting the head element.

*/

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;
 
public class CacheMRU {
    public Deque<Page> doubleEndedQueue = new LinkedList<Page>();
   
    public int CACHE_CAPACITY = -1;
   
    public CacheMRU(int capacity) {
        this.CACHE_CAPACITY = capacity;
    }
   
    public void resolve(Page page)
    {
        // if the frame already in the queue, remove it
        // we need to bring the page to the front of the queue
       
        if(doubleEndedQueue.contains(page))
        {
            doubleEndedQueue.remove(page);
        }
       
        // if the cache is full, we need to remove the most recently
        // used page (from the front of the queue)
       
        if(doubleEndedQueue.size() == this.CACHE_CAPACITY)
        {
            doubleEndedQueue.removeFirst();
        }
       
        // we need to push the new element at the front of the queue
        doubleEndedQueue.addFirst(page);
    }
   
    public void show()
    {
        Iterator<Page> iter = doubleEndedQueue.iterator();
       
        while(iter.hasNext())
        {
            System.out.println(iter.next());
        }
    }
   
    public void simulate()
    {
       /* Order: 0,1,2,3,4, 3*/
       
        resolve(new Page(0));
        resolve(new Page(1));
        resolve(new Page(2));
        resolve(new Page(3));
        resolve(new Page(4));
        resolve(new Page(3));
        show();
    }
 
    public static void main(String[] args)
    {
        CacheMRU cache = new CacheMRU(3);
        cache.simulate();
    }
   
    class Page
    {
        int frameNum;
       
        public Page(int frameNum)
        {
            this.frameNum = frameNum;
        }
       
        public boolean equals(Object other)
        {
            Page otherPage = (Page)other;
           
            if(getFrameNum() == otherPage.getFrameNum())
                return true;
            else
                return false;
        }
       
        public int getFrameNum()
        {
            return frameNum;
        }
       
        public String toString()
        {
            return "Page:=" + frameNum;
        }
       
    }
} 
