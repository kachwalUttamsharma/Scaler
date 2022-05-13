Problem Description
Given a doubly linked list of integers with one pointer of each node pointing to the next node (just like in a single link list) while the second pointer, however, can point to any node in the list and not just the previous node.

You have to create a copy of this list and return the head pointer of the duplicated list.



Problem Constraints
1 <= length of the list <= 100000

1 <= Value of node <= 100000



Input Format
The only argument given is head pointer of the doubly linked list.



Output Format
Return the head pointer of the duplicated list.



Example Input
Input 1:

1 -> 2 -> 3 -> 4 -> 5
random pointer of each node 
1 -> 5 2 -> 4 3 -> 3 4 -> 2 5 -> 1
Input 2:

1 -> 2 -> 3 -> 4 -> 5
random pointer of each node 
1 -> 5 2 -> 4 3 -> 3 4 -> 2 5 -> 1


Example Output
Output 1:

1 -> 2 -> 3 -> 4 -> 5
random pointer of each node 
1 -> 5 2 -> 4 3 -> 3 4 -> 2 5 -> 1
Output 2:

1 -> 2 -> 3 -> 4 -> 5
random pointer of each node 
1 -> 5 2 -> 4 3 -> 3 4 -> 2 5 -> 1


Example Explanation
Explanation 1:

 Just clone the given list.
Explanation 2:

 Just clone the given list

 // solution

 /*
class ListNode {
    int val;
    ListNode next, random;
    ListNode(int x) {
        val = x;
        next = random = null;
    }
} 
*/
ListNode cloneList(ListNode A) {
    ListNode iter = A, next;

    while(iter != null) {
        next = iter.next;
        ListNode copy = new ListNode(iter.val);
        iter.next = copy;
        copy.next = next;
        iter = next;
    }

    iter = A;
    while(iter != null) {
        if(iter.random != null) {
            iter.next.random = iter.random.next;
        }
        iter = iter.next.next;
    }

    iter = A;
    ListNode pseudoHead = new ListNode(0);
    ListNode copy, copyIter = pseudoHead;

    while (iter != null) {
        next = iter.next.next;

        // extract the copy
        copy = iter.next;
        copyIter.next = copy;
        copyIter = copy;

        // restore the original list
        iter.next = next;

        iter = next;
    }

    return pseudoHead.next;
}