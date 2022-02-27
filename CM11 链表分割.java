import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if (pHead == null && pHead.next == null) {
            return pHead;
        }
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.val < x) {
                if (bs == null) {
                    bs = cur;
                    be = cur;
                }
                else {
                    be.next = cur;
                    be = be.next;
                }
            }
            else {
                if (as == null) {
                    as = cur;
                    ae = cur;
                }
                else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if (bs == null) {
            return as;
        }
        be.next = as;
        if (as != null) {
            ae.next = null;
        }
        return bs;
    }
}