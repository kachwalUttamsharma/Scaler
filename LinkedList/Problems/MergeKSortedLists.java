Problem Description
Given a list containing head pointers of N sorted linked lists.
Merge these given sorted linked lists and return them as one sorted list.



Problem Constraints
1 <= total number of elements in given linked lists <= 100000



Input Format
The first and only argument is a list containing N head pointers.



Output Format
Return a pointer to the head of the sorted linked list after merging all the given linked lists.



Example Input
Input 1:

 1 -> 10 -> 20
 4 -> 11 -> 13
 3 -> 8 -> 9
Input 2:

 10 -> 12
 13
 5 -> 6


Example Output
Output 1:

 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
Output 2:

 5 -> 6 -> 10 -> 12 ->13


Example Explanation
Explanation 1:

 The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
Explanation 2:

 The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.

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
	public ListNode mergeKLists(ArrayList<ListNode> a) {
        ListNode temp = a.get(0);
        for(int i=1; i<a.size(); i++) {
            temp = mergeList(temp, a.get(i));
        }
        return temp;
	}

    public ListNode mergeList(ListNode a, ListNode b) {
        ListNode temp = new ListNode(0);
        ListNode res = temp;

        while(a != null && b != null) {
            if(a.val < b.val) {
                temp.next = a;
                temp = temp.next;
                a = a.next;
            } else {
                temp.next = b;
                temp = temp.next;
                b = b.next;
            }
        }
            if(a != null) {
                temp.next = a;
            } else {
                temp.next = b;
            }
        return res.next;
    }
}
