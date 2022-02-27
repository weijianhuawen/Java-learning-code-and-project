import java.util.Arrays;

public class MyArrayList<E> {
    public E[] elementData;
    public int size;
    public MyArrayList() {
        elementData = (E[]) new Object[10];
    }
    //插入元素
    public boolean add(E val) {
        if (isFull()) {
            this.elementData = Arrays.copyOf(elementData, 2 * elementData.length);
        }
        elementData[size++] = val;
        return true;
    }
    //检查顺序表是否满
    public  boolean isFull() {
        return this.size >= elementData.length;
    }
    //删除元素
    public boolean remove(int index) {
        if (index < 0 || index >= size) return false;
        for (int i = size - 1; i > index; i--) {
            elementData[i- 1] = elementData[i];
        }
        size--;
        return true;
    }
    //修改元素
    public boolean set(int index, E val) {
        if (index < 0 || index >= size) return false;
        elementData[index] = val;
        return true;
    }
    //查找元素
    public int search(E k) {
        for (int i = 0; i < size; i++) {
            if (k.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            stringBuilder.append(elementData[i]);
            stringBuilder.append(",");
        }
        stringBuilder.append(elementData[size-1]);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
