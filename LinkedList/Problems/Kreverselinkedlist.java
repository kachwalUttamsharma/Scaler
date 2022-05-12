Problem Description
Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.

Problem Constraints
1 <= |A| <= 103

B always divides A

Input Format
The first argument of input contains a pointer to the head of the linked list.

The second arugment of input contains the integer, B.


Output Format
Return a pointer to the head of the modified linked list.


Example Input
Input 1:

 A = [1, 2, 3, 4, 5, 6]
 B = 2
Input 2:

 A = [1, 2, 3, 4, 5, 6]
 B = 3


Example Output
Output 1:

 [2, 1, 4, 3, 6, 5]
Output 2:

 [3, 2, 1, 6, 5, 4]


Example Explanation
Explanation 1:

 For the first example, the list can be reversed in groups of 2.
    [[1, 2], [3, 4], [5, 6]]
 After reversing the K-linked list
    [[2, 1], [4, 3], [6, 5]]
Explanation 2:

 For the second example, the list can be reversed in groups of 3.
    [[1, 2, 3], [4, 5, 6]]
 After reversing the K-linked list
    [[3, 2, 1], [6, 5, 4]]


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
    public ListNode reverseList(ListNode A, int B) {
        if(A == null || B == 1) {
            return A;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = A;

        ListNode cur = dummy, nex = dummy, pre = dummy;

        int count = 0;
        while(cur.next != null) {
            cur = cur.next;
            count++;
        }

        while(count >= B) {
            cur = pre.next;
            nex = cur.next;
            for(int i=1; i<B; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            count -= B;
        }
        return dummy.next;
    }
}
