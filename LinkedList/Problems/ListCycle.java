Problem Description

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example:

Input: 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3.

// solution

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode detectCycle(ListNode a) {
        // If list is empty or has
  // only one node without loop
  if (a == null || a.next == null) {
      return null;
  }
    
  ListNode slow = a, fast = a;
 
  // Move slow and fast 1
  // and 2 steps ahead
  // respectively.
  slow = slow.next;
  fast = fast.next.next;
 
  // Search for loop using
  // slow and fast pointers
  while (fast != null &&
         fast.next != null)
  {
    if (slow == fast) {
      break;
    }  
    slow = slow.next;
    fast = fast.next.next;
  }
 
  // If loop does not exist
  if (slow != fast)
    return null;
 
  // If loop exists. Start slow from
  // head and fast from meeting point.
  slow = a;
  while (slow != fast)
  {
    slow = slow.next;
    fast = fast.next;
  }
 
  return slow;
	}
}
