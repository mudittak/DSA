
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode d1 = new ListNode(-1);
        ListNode d2 =  new ListNode(-1);
        ListNode t1 = d1; // for smaller value
        ListNode t2 = d2; // for larger value
        ListNode t = head;
        int idx = 1;

        while(t!=null){
            if(idx % 2 == 1){  //odd idx
                t1.next = t;
                t1 = t1.next;
            }
            else{           //even idx
                t2.next = t;
                t2 = t2.next;
            }
            t = t.next;
            idx++;

        }
        t1.next = d2.next;
        t2.next = null;
        return d1.next;
        
    }
}