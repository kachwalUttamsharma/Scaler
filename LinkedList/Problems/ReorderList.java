Problem Description
Given a singly linked list A

 A: A0 → A1 → … → An-1 → An 
reorder it to:

 A0 → An → A1 → An-1 → A2 → An-2 → … 
You must do this in-place without altering the nodes values.



Problem Constraints
1 <= |A| <= 106



Input Format
The first and the only argument of input contains a pointer to the head of the linked list A.



Output Format
Return a pointer to the head of the modified linked list.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5] 
Input 2:

 A = [1, 2, 3, 4] 


Example Output
Output 1:

 [1, 5, 2, 4, 3] 
Output 2:

 [1, 4, 2, 3] 


Example Explanation
Explanation 1:

 The array will be arranged to [A0, An, A1, An-1, A2].
Explanation 2:

 The array will be arranged to [A0, An, A1, An-1, A2].

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
    public ListNode reorderList(ListNode A) {
         // defining a deque
        Deque<Integer> deque = new ArrayDeque<>();
        ListNode temp = A;
         
        // push all the elements of linked list in to deque
        while(temp != null)
        {
            deque.addLast(temp.val);
            temp = temp.next;
        }
        temp = A;
        int i = 0;
         
        // Alternatively push the first and last elements
        // from deque to back to the linked list and pop
        while(!deque.isEmpty())
        {
            if(i % 2 == 0)
            {
                temp.val = deque.removeFirst();
            }
            else
            {
                temp.val = deque.removeLast();
            }
            i++;
            temp = temp.next;
        }
        return A;
    }
}
