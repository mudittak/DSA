/*logic:
 forw = curr.next
 curr.next = prev
 prev = curr
 curr = forw */
class Solution {
    public ListNode reverseList(ListNode head) {
        //recursive method
        if(head ==null || head.next==null) return head;
        ListNode a = head.next;
        head.next = null;
        ListNode newhead = reverseList(a);
        a.next = head;
        return newhead;
        
        
        
        
        
        
        
        //Iterative method
        // ListNode curr = head;
        // ListNode prev = null;
        // ListNode forw = null;

        // while(curr!= null){
        //     forw = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = forw;
        // }
        // return prev;

        
    }
}