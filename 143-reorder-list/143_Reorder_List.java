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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode sechead = reverse(slow.next);
        ListNode fhead = head;
        slow.next = null;
        while(sechead != null){
            ListNode temp1 = fhead.next;
            ListNode temp2 = sechead.next;
            fhead.next = sechead;
            fhead = temp1;
            sechead.next = fhead;
            sechead = temp2;

        }
        
    }
    ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode current = node;
        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}

// if(head == null || head.next == null){
//             return;
//         }
//          ListNode first = head;
//         ListNode second = head;
//         while(second != null && second.next != null){
//             first = first.next;
//             second = second.next.next;
//         }
//         ListNode sechead = reverse(first);
//         ListNode fhead = head;

//         while(sechead != null){
//             ListNode temp1 = fhead.next;
//             ListNode temp2 = sechead.next;
//             fhead.next = sechead;
//             fhead = temp1;
            
//             sechead.next = fhead;
//             sechead = temp2;
//         }

//         if(fhead != null){
//             fhead.next = null;
//         }
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