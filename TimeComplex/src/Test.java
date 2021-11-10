import java.util.*;

class ListNode {
    public int val;
    ListNode next;
}
public class Test {

    public static int sumAdd(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (int)Math.pow(-1, i);
        }
        return sum;
    }
    public static int sumAddPlus(int n) {
        int sum = 0;

        if (n % 2 == 1) {
            sum = -1;
        }

        return sum;
    }
    public static void main(String[] args) {
        System.out.println(sumAdd(5));
        System.out.println(sumAdd(6));
        System.out.println(sumAddPlus(5));
        System.out.println(sumAddPlus(6));
        String str = "123";

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        ListNode pl = headA;
        ListNode ps = headB;
        int lenA = 0;
        int lenB = 0;
        while (pl != null) {
            lenA++;
            pl = pl.next;
        }
//pl==null
        pl = headA;
        while (ps != null) {
            lenB++;
            ps = ps.next;
        }
//ps==null
        ps = headB;
        int len = lenA-lenB;//差值步
        if(len < 0) {
            pl = headB;
            ps = headA;
            len = lenB-lenA;
        }
//1、pl永远指向了最长的链表   ps 永远指向了最短的链表  2、求到了差值len步

//pl走差值len步
        for (int i = 0 ;i < len; i++) {
            pl = pl.next;
        }
//同时走 直到相遇
        while (pl != ps) {
            pl = pl.next;
            ps = ps.next;
        }
        return pl;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode first = head;
                while (first != fast) {
                    fast = fast.next;
                    first = first.next;
                }
                return first;
            }
        }
        return null;
    }
}
