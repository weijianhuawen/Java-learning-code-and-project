class ListNode {
    public int val;//数据域
    ListNode next;//引用（指针）域
    ListNode() {}
    public ListNode(int val) {
        this.val = val;//初始化链表结点值构造方法
    }
}


public class SList {

    public ListNode head;
    //头插法
    public void addFirst(int data){
        ListNode node  = new ListNode(data);
        if (this.head == null) {
            this.head = node;
        }
        node.next = this.head;
        this.head = node;
    }
    //尾插法
    public void addLast(int data){
        ListNode node  = new ListNode(data);
        if (this.head == null) {
            this.head = node;
        }
        ListNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if (index < 0 || index > size()) {
            System.out.println("插入位置非法！");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        ListNode node  = new ListNode(data);
        ListNode prev = this.head;
        while (index - 1 != 0) {
            prev = prev.next;
            index--;
        }
        node.next = prev.next;
        prev.next = node;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        if (this.head == null) {
            return false;
        }
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if (this.head == null) {
            return;
        }
        if (this.head.val == key) {
            this.head = this.head.next;
            return;
        }
        ListNode cur = this.head.next;
        ListNode prev = this.head;
        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
        System.out.println("未找到目标结点！");
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        if (this.head == null) {
            return;
        }
        while (this.head.val == key) {
            this.head = this.head.next;
            if (this.head == null) {
                return;
            }
        }
        ListNode cur = this.head.next;
        ListNode prev = this.head;
        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            }
            else {
                prev = cur;
                cur = cur.next;
            }
        }
    }
    //得到单链表的长度
    public int size(){
        int len = 0;
        ListNode cur = this.head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }
    public void display(){
        ListNode cur  = this.head;
        while (cur != null) {
            System.out.print(cur.val + "  ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void clear(){
        if (this.head == null) {
            return;
        }
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            head = next;
        }
    }
}
