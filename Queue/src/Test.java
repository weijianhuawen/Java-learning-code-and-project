import java.util.*;

public class Test {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.offer(24);
        myQueue.offer(48);
        myQueue.offer(86);
        myQueue.offer(98);
        myQueue.offer(100);
        System.out.println("入队offer[24,48,86,98,100]: "+ myQueue);
        System.out.println("出队poll:" + myQueue.poll());
        System.out.println("出队poll:" + myQueue.poll());
        System.out.println("出队poll:" + myQueue.poll());
        System.out.println("获取队头元素peek:" + myQueue.peek());
        System.out.println("队列中的元素:" + myQueue);
    }
    public static void main1(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        list.remove();
        System.out.println(list);

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        System.out.println(deque);
    }

}
