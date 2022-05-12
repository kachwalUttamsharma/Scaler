Problem Description
Given a linked list A, remove the B-th node from the end of the list and return its head.

For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end, the linked list becomes 1->2->3->5.

NOTE: If B is greater than the size of the list, remove the first node of the list.

NOTE: Try doing it using constant additional space.



Problem Constraints
1 <= |A| <= 106



Input Format
The first argument of input contains a pointer to the head of the linked list.

The second argument of input contains the integer B.



Output Format
Return the head of the linked list after deleting the B-th element from the end.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = 2
Input 2:

A = [1]
B = 1


Example Output
Output 1:

[1, 2, 3, 5]
Output 2:

 [] 


Example Explanation
Explanation 1:

In the first example, 4 is the second last element.
Explanation 2:

In the second example, 1 is the first and the last element.


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
    public static ListNode removeNthFromEnd(ListNode A, int B) {
     
         ListNode p1 = A;
         ListNode p2 = A;
         ListNode previous = A;
 
         //Keep moving B times the P1
         while(B>0 && p1.next!=null){
             p1 = p1.next;
             B--;
         }
 
         if(B>0){
             return A.next;
         }
 
         //Need to keep P2 at 2nd node and previous behind it.
         p2 = p2.next;
         while(p1.next!=null){
             p1 = p1.next;
             previous = p2;
             p2 = p2.next;
         }
 
         //The P2 will be at Bth location from end now skip it
         previous.next = p2.next;
        
         return A;    
         }
 }
 