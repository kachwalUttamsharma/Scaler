Problem Description
Sort a linked list, A in O(n log n) time using constant space complexity.



Problem Constraints
0 <= |A| = 105



Input Format
The first and the only arugment of input contains a pointer to the head of the linked list, A.



Output Format
Return a pointer to the head of the sorted linked list.



Example Input
Input 1:

A = [3, 4, 2, 8]
Input 2:

A = [1]


Example Output
Output 1:

[2, 3, 4, 8]
Output 2:

[1]


Example Explanation
Explanation 1:

 The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
Explanation 2:

 The sorted form of [1] is [1].

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
    public ListNode sortList(ListNode A) {
        if(A == null || A.next == null) {
            return A;
        }
        ListNode mid = getMid(A);
        ListNode B = mid.next;
        mid.next = null;
        ListNode C = sortList(A);
        B = sortList(B);
        A = merge(B, C);
        return A;
    }

    public ListNode getMid(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode A, ListNode B) {
        ListNode head;
        if(A.val < B.val) {
            head = A;
            A = A.next;
        } else {
            head = B;
            B = B.next;
        }
        ListNode temp = head;
        while( A != null && B != null) {
            if(A.val  < B.val) {
                temp.next = A;
                A = A.next;
                temp = temp.next;
            } else {
                temp.next = B;
                B = B.next;
                temp = temp.next;
            }
        }
        if( A == null) {
            temp.next = B;
        } else {
            temp.next = A;
        }
        return head;
    }
}
