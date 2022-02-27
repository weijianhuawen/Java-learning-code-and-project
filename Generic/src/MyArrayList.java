import java.lang.reflect.Array;

public class MyArrayList<T extends Number> {
    public T[] elem ;
    private int usedSize;

    public MyArrayList(int capacity) {
        this.elem = (T[])new Object[capacity];
    }
    public MyArrayList(Class<T> clazz, int capacity) {
        this.elem = (T[]) Array.newInstance(clazz, capacity);
    }

    public void add(T val) {
        if (this.usedSize == this.elem.length) return;
        this.elem[this.usedSize++] = val;
    }

    public T get() {
        if (this.usedSize == 0) return null;
        return this.elem[this.usedSize - 1];
    }

    public T removeLast() {
        if (this.usedSize == 0) return null;
        this.usedSize--;
        return this.elem[this.usedSize];
    }

    public static void main1(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<>(10);//正确
        MyArrayList<Double> list2 = new MyArrayList<>(10);//正确
        //MyArrayList<String> list3 = new MyArrayList<>(10);//错误，因为String不是Number的子类
    }

    public static void main(String[] args) {
        Integer[] data1 = {18, 16, 12, 23, 48, 24, 2, 32, 6, 1};
        String[] data2 = {"chinese", "abs","bbbbb","ydyl","wjhw"};
        MaxVal<Integer> maxValInt = new MaxVal<>();
        MaxVal<String> maxValStr = new MaxVal<>();
        int ret1 = maxValInt.max(data1);
        String ret2 = maxValStr.max(data2);
        System.out.println(ret1);
        System.out.println(ret2);
    }

}

class MaxVal<T extends Comparable<T>> {
    public T max(T[] data) {
        T max = data[0];
        for (int i = 0; i < data.length; i++) {
            if (max.compareTo(data[i]) < 0) max = data[i];
        }
        return max;
    }
}