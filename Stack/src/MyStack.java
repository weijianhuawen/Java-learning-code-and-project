import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyStack<E> {
    private E[] elem;
    private int top;
    public MyStack() {
        this.elem =  (E[])new Object[10];
        this.top = 0;
    }
    public void push(E e) {
        if (top == this.elem.length) {
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        this.elem[this.top] = e;
        top++;
    }
    public E peek() {
        if (this.top <= 0) {
            throw new StackOverflowError("栈为空！");
        }
       return this.elem[this.top - 1];
    }
    public E pop() {
        if (this.top <= 0) {
            throw new StackOverflowError("栈为空！");
        }
        this.top--;
        return this.elem[this.top];
    }
    public boolean empty() {
        return this.top <= 0;
    }

    @Override
    public String toString() {
        if (this.top <= 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < this.top - 1; i++) {
            stringBuilder.append(this.elem[i]);
            stringBuilder.append(",");
        }
        stringBuilder.append(this.elem[this.top - 1]);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

