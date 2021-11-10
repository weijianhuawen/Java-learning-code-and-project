public class Test {
    public static void main(String[] args) {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(3);
        ListNode s4 = new ListNode(4);
        ListNode s5 = new ListNode(5);
        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        SList list = new SList();
        list.head = s1;
        list.display();
        list.addFirst(12);
        list.addFirst(12);
        list.addFirst(14);
        list.display();
        list.addLast(15);
        list.addLast(15);
        list.addLast(17);
        list.display();
        list.addIndex(0, 22);
        list.addIndex(12,23);
        list.addIndex(2,24);
        list.display();
        list.remove(23);
        list.remove(22);
        list.remove(24);
        list.display();
        list.removeAllKey(12);
        list.removeAllKey(17);
        list.removeAllKey(15);
        list.removeAllKey(14);
        list.display();
        System.out.println(list.contains(1));
        System.out.println(list.contains(2));
        System.out.println(list.contains(5));
        System.out.println(list.contains(13));
        System.out.println("------------");
        list.clear();
        list.display();
    }
}
