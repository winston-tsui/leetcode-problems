/*
 * Leetcode 206: Reverse Linked List. Java. Easy.
 * Interesting linkedList problem. O(n) runtime and O(1) space complexity.
 * Uses a pointer to keep track of next element after head so that head.next
 * does not get wiped out after we assign it to prev;
 * 2/10/2024 Winston Tsui
*/

class Solution {
    // Iterative Solution
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode after = head.next;
            head.next = prev;
            prev = head;
            head = after;
        }

        return prev;
    }

    // /*
    //  * Recursive solution: O(n) time and space complexity. Break down problem into subproblems and base case. 
    //  * In this case, it is when head.next==null. Keep track of end of linkedlist because this is what we return.
    //  */
    // public ListNode reverseList(ListNode head) {
    //     if (head == null || head.next == null)
    //         return head;
    //     ListNode after = reverseList(head.next);
    //     head.next.next = head;
    //     head.next = null; // Prevents cycles
    //     return after;
    // }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
