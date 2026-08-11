/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 // when fast move with 2x 
// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         ListNode slow = head;
//         ListNode fast = head;
//         while(fast!=null && fast.next!=null){
//             slow = slow.next;
//             fast = fast.next.next;
//             if(fast==slow) return true;
//         }
//         return false;
        
//     }
// }
// if we want to move fast with 3x speed just some changes
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next.next;
            if(fast==slow) return true;
        }
        return false;
        
    }
}