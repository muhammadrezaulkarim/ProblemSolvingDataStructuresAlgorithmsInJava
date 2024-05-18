/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkListHasCycleLeetcode141 {
    public boolean hasCycle(ListNode head) {
        
        if(head == null)
            return false;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null)
        {
            fast=fast.next.next;
            slow = slow.next;

            if(fast == slow)
                break;
        }

        if(fast == null || fast.next == null)
            return false;

        
        slow = head;
        while(fast != slow)
        {
            fast = fast.next;
            slow = slow.next;
        }

        if(fast != null)
            return true;
        
        return false;
    }
}
/* The explanation for the slow and fast pointer implementation can be found in exercise 2.4 of the Cracking the coding interview book
*/
/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Constraints:

The number of the nodes in the list is in the range [0, 104].
-10^5 <= Node.val <= 10^5
pos is -1 or a valid index in the linked-list.
 

Follow up: Can you solve it using O(1) (i.e. constant) memory?
*/
