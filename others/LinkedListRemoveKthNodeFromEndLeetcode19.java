/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class LinkedListRemoveKthNodeFromEndLeetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(n == 0)
           return head;

        if(n == 1 && head.next == null) // linked list with one node
            return null;


        ListNode ahead = head;
        ListNode slow = head;

        int i=0;
        while(i < n)
        {
            ahead = ahead.next;

            if(ahead == null)
            {
               return head.next; // we need to remove the root node
            }

            i++;
        }


        // we are using ahead.next!=null as we need to delete the target node
        // If we were asked to return that taget node, we had to use ahead!=null

        while(ahead.next != null) 
        {
            ahead = ahead.next;
            slow = slow.next;
        }   
        
 
        slow.next = slow.next.next; // delete the target node

        return head;
    }
}
