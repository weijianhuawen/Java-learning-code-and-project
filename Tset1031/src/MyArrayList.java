import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: 12629
 * Date: 2021/10/31
 * Time: 10:28
 * Description:顺序表
 */
public class MyArrayList {

    public int[] elem;
    public int usedSize;//有效的数据个数

    public MyArrayList() {
        this.elem = new int[10];
    }

    // 打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }

    // 获取顺序表的有效数据长度
    public int size() {
        return this.usedSize;
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if (pos < 0 || pos > this.usedSize) {
            System.out.println("插入位置不合法！");
            return;
        }
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        for (int i = this.usedSize - 1; i >= pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;

    }

    public boolean isFull() {
        if (this.usedSize == this.elem.length) {
            return true;
        }
        else {
            return false;
        }

    }
    public boolean isEmpty() {
        if (this.usedSize == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if (this.isEmpty()) {
            System.out.println("顺序标为空！");
            return -1;
        }
        if(pos > this.usedSize || pos < 0) {
            return -1;
        }
        return this.elem[pos];
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if (pos > this.usedSize || pos < 0) {
            return;
        }
        if (this.isEmpty()) {
            System.out.println("顺序表为空！");
            return;
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        if (this.isEmpty()) {
            System.out.println("顺序表为空！");
            return;
        }
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toRemove) {
                for (int j = i; j < this.usedSize - 1; j++) {
                    this.elem[j] = this.elem[j + 1];
                }
                break;
            }
        }
        this.usedSize--;
    }
    // 清空顺序表
    public void clear() {
        this.usedSize = 0;

    }
}