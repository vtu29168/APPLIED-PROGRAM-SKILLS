/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Base case: if either list is empty, there's no intersection
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        
        // Loop until both pointers meet at the intersection node or reach null
        while (ptrA != ptrB) {
            // For list A: move to next, or switch to headB if end is reached
            ptrA = (ptrA != null) ? ptrA.next : headB;
            
            // For list B: move to next, or switch to headA if end is reached
            ptrB = (ptrB != null) ? ptrB.next : headA;
        }
        
        // Returns either the intersection node or null (if no intersection)
        return ptrA;
    }
}