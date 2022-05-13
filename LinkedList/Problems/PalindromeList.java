Problem Description
Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.



Problem Constraints
1 <= |A| <= 105



Input Format
The first and the only argument of input contains a pointer to the head of the given linked list.



Output Format
Return 0, if the linked list is not a palindrome.

Return 1, if the linked list is a palindrome.



Example Input
Input 1:

A = [1, 2, 2, 1]
Input 2:

A = [1, 3, 2]


Example Output
Output 1:

 1 
Output 2:

 0 


Example Explanation
Explanation 1:

 The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.
Explanation 2:

 The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1].

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
    public int lPalin(ListNode A) {
       ListNode right = A;
        ListNode left = null;
        ListNode next_node = null;
        ListNode fast = A;
        if(A.next == null)
        {
            return 1;
        }
        //Using fast and slow pointer to find the middle as well as reversing along the way. 
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            next_node = right.next;
            right.next = left;
            left = right;
            right = next_node;
        }
        //In case of odd number of inputs, skip the middle one.
        if(fast != null)
            right = right.next;
        
        //check for Palindrome
        while(right != null)
        {
            if(right.val != left.val)
                return 0;
            right = right.next;
            left = left.next;
        }
        return 1;
    }
}
