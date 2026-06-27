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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode sechead = reverse(slow);
        while(sechead != null){
            if(sechead.val != head.val){
            return false;
            }
            sechead = sechead.next;
            head = head.next;
        }
        return true;
    }
    ListNode reverse(ListNode node){
        ListNode current = node;
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


// ListNode first = head;
//         ListNode second = head;
//         while(second != null && second.next != null){
//             first = first.next;
//             second = second.next.next;
//         }
//         ListNode sechead = reverse(first);
//         ListNode fhead = head;
//         ListNode rereverse = sechead;
//         reverse(first);
//         while(head != null && sechead != null){
//             if(head.val != sechead.val){
//                 break;
//             }
//             head = head.next;
//             sechead = sechead.next;
//         }
//         reverse(rereverse);
//         if(head == null || sechead == null){
//             return true;
//         }
//         return false;
//     }
//     public ListNode reverse(ListNode node){
//         ListNode prev = null;
//         ListNode current = node;

//         ListNode next = node.next;
        
//         while(current != null){
//             current.next = prev;
//             prev = current;
//             current = next;
//             if(next != null){
//                 next = next.next;
//             }
//         }
//         return prev;