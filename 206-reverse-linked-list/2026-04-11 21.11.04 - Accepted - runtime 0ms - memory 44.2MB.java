/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while(current != null){
        ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            if(next != null){
            next = next.next;
            }
        }
        return prev;
    }
}




        // ListNode current = head;
        // ListNode prev = null;
        // if(head != null){
        //     ListNode next = current.next;
        //     while(current != null){
        //         current.next = prev;
        //         prev = current;
        //         current = next;
        //         if(next != null){
        //             next = next.next;
        //         }
        //     }
        // }

        // return prev;