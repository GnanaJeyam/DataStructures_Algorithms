/**
 * This is leetcode problem to rearrange the linked list 
 * to this fashion reorder it to: L0→ Ln → L1→ Ln-1 → L2 → Ln-2→…
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3430
 */

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

class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null) return;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        // Splitting the list into mulitple parts
        while(null != fast && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // Removing the pointer in the middle node.
        ListNode n1 = slow.next;
        slow.next = null;
        slow = n1;
        fast = null;
        
        // Reversing the second half list
        while(slow != null){
            ListNode n = slow.next;
            slow.next = fast;
            fast = slow;
            slow = n;
        }
        
        // Altering the pointers as per requirement.
        while(head != null && fast != null) {
            n1 = head.next;
            head.next = fast;
            head = n1;
            slow = fast.next;
            fast.next = head;
            fast = slow;            
        }
        
    }
}