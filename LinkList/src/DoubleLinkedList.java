class IndexExcept extends RuntimeException{
    public IndexExcept(String message) {
        super(message);
    }
}
class LinkedListElemNull extends RuntimeException{
    public LinkedListElemNull(String message) {
        super(message);
    }
}

class DoubleLinkedListNode {
    public int val;
    public DoubleLinkedListNode next;
    public DoubleLinkedListNode prev;

    public DoubleLinkedListNode(int val) {
        this.val = val;
    }
}
public class DoubleLinkedList {
    public DoubleLinkedListNode head;//头结点
    public DoubleLinkedList() {
        this.head = new DoubleLinkedListNode(0);
    }
    //头插法
    public void addFirst(int data){
        DoubleLinkedListNode node = new DoubleLinkedListNode(data);
        node.next = head.next;
        if (head.next != null) {
            head.next.prev = node;
        }
        head.next = node;
        node.prev = head;
    }
    //尾插法
    public void addLast(int data) {
        DoubleLinkedListNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        DoubleLinkedListNode node = new DoubleLinkedListNode(data);
        cur.next = node;
        node.prev = cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) throws IndexExcept{
        if (index < 0 || index > size()) {
            throw new IndexExcept(index + "位置非法！");
        }
        if (size() == 0) {
            addFirst(data);
            return;
        }
        if (size() == index) {
            addLast(data);
            return;
        }
        DoubleLinkedListNode node = new DoubleLinkedListNode(data);
        DoubleLinkedListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next.prev = node;
        node.prev = cur;
        cur.next = node;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        if (this.head.next == null) {
            return false;
        }
        DoubleLinkedListNode cur = head.next;
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
        if (this.head.next == null) {
            throw new LinkedListElemNull("LinkedList is null");
        }
        DoubleLinkedListNode cur = this.head.next;

        while (cur != null) {
            if (cur.val == key) {
                cur.prev.next = cur.next;
                if (cur.next != null) {
                    cur.next.prev = cur.prev;
                }
                return;
            }
            cur = cur.next;
        }
        System.out.println("没有找到目标结点！");
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        if (this.head.next == null) {
            throw new LinkedListElemNull("LinkedList is null");
        }
        DoubleLinkedListNode cur = this.head.next;
        while (cur != null) {
            if (cur.val == key) {
                cur.prev.next = cur.next;
                if (cur.next != null) {
                    cur.next.prev = cur.prev;
                }
            }
            cur = cur.next;
        }
    }
    //得到双链表的长度
    public int size(){
        int cnt = 0;
        DoubleLinkedListNode cur = this.head.next;
        while (cur != null) {
            cnt++;
            cur = cur.next;
        }
        return cnt;
    }
    public void display(){
        DoubleLinkedListNode cur = head.next;
        while (cur != null) {
            System.out.print(cur.val + "   ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void clear(){
        DoubleLinkedListNode cur = this.head.next;
        DoubleLinkedListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = null;
            cur.prev = null;
            cur = next;
        }
        this.head.next = null;
    }
}
