package out1;

import java.util.Arrays;

interface Selector{
    //判断是否迭代完全部元素
    public boolean end();
    //获取当前元素
    public Object current();
    //迭代下一个元素
    public void next();
}

public class SequeArray {
    private Object[] items;
    private int usedSize;

    public SequeArray(int capacity) {
        items = new Object[capacity];
    }
    public void add(Object val) {
        if (usedSize == items.length) items = Arrays.copyOf(items, 2 * usedSize);

        items[usedSize++] = val;
    }

    private class SequeSelector implements Selector{
        private int index;

        public boolean end() {
            return index == usedSize;
        }
        public Object current() {
            return items[index];
        }
        public void next() {
            if (index < usedSize) index++;
        }
    }
    public SequeSelector sequeSelector() {
        return new SequeSelector();
    }

    public static void main(String[] args) {
        SequeArray array = new SequeArray(10);

        for (int i = 0; i < 10; i++) {
            array.add(i+1);
        }
        //发生了向上转型
        Selector selector = array.sequeSelector();

        while (!selector.end()) {
            System.out.print(selector.current() + "   ");
            selector.next();
        }
    }
}
