Problem Description
You are given a linked list that contains a loop.
You need to find the node, which creates a loop and break it by making the node point to NULL.


Problem Constraints
1 <= number of nodes <= 1000


Input Format
Only argument is the head of the linked list.


Output Format
return the head of the updated linked list.



Example Input
Input 1:

 
1 -> 2
^    |
| - - 
Input 2:

3 -> 2 -> 4 -> 5 -> 6
          ^         |
          |         |    
          - - - - - -


Example Output
Output 1:

 1 -> 2 -> NULL
Output 2:

 3 -> 2 -> 4 -> 5 -> 6 -> NULL


Example Explanation
Explanation 1:

 Chain of 1->2 is broken.
Explanation 2:

 Chain of 4->6 is broken.


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
    public ListNode solve(ListNode A) {
        ListNode prev = null;        // previous pointer
        ListNode curr = A;        // main pointer
 
        // maintain a set to store visited nodes
        Set<ListNode> set = new HashSet<>();
 
        // traverse the list
        while (curr != null)
        {
            // set the previous pointer to null if the current node is seen before
            if (set.contains(curr))
            {
                prev.next = null;
                return A;
            }
 
            // insert the current node into the set
            set.add(curr);
 
            // update the previous pointer to the current node and
            // move the main pointer to the next node
            prev = curr;
            curr = curr.next;
        }
        return null;
    }
}
