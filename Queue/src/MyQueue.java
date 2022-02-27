
class ListNode<E> {
    public E val;
    public ListNode<E> next;
    public ListNode(E val) {
        this.val = val;
    }
}
public class MyQueue<E> {
    public ListNode<E> head;//指向单链表的头
    public ListNode<E> last;//指向单链表的尾

    public boolean offer(E e) {
        //队尾(单链表的尾)入队,尾插
        ListNode<E> node = new ListNode<>(e);
        if (isEmpty()) {
            this.head = node;
            this.last = node;
            return true;
        }
        this.last.next = node;
        this.last = node;
        return true;
    }
    public E poll() {
        //队头出队(单链表的头),头删
        if (isEmpty()) {
            return null;
        }
        ListNode<E> cur = this.head;
        this.head = cur.next;
        return cur.val;
    }
    public E peek() {
        //获取队头（单链表的头）的元素
        if (isEmpty()) {
            return null;
        }
        return this.head.val;
    }
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public String toString() {
        ListNode<E> cur = this.head;
        if (cur == null) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        while (cur.next != null) {
            stringBuilder.append(cur.val);
            stringBuilder.append(",");
            cur = cur.next;
        }
        stringBuilder.append(cur.val);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
