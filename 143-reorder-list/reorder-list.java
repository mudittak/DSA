
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next; 
        slow.next = null;
        head2 = reverseList(head2); //Reverse second half
        mergeTwoLists(head, head2); //Merge alternately
    }
    static ListNode reverseList(ListNode head) {
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
    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode i = list1;
        ListNode j = list2;

        while(i!= null && j!= null){
            ListNode nextI = i.next;
            ListNode nextJ = j.next;

            i.next = j;
            j.next = nextI;

            i = nextI;
            j = nextJ;
        }
        return list1;
    }
}

        
  