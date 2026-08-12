/*logic:
 forw = curr.next
 curr.next = prev
 prev = curr
 curr = forw */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode forw = null;

        while(curr!= null){
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;

        
    }
}