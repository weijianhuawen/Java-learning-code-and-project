import java.util.Arrays;

public class SeqList {
    public int[] elem;
    public int size;

    //初始化顺序表
    public void initSeqList(){
        this.elem = new int[10];
    }
    // 打印顺序表
    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.elem[i] + "  ");
        }
        System.out.println();
    }
    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if (this.elem == null) {
            this.initSeqList();
        }
        if (pos < 0 || pos > this.size) {
            System.out.println("插入位置非法！");
            return;
        }
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        for (int i = size - 1; i >= pos; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.size++;
    }
    public boolean isFull() {
        return this.size == this.elem.length;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int j : this.elem) {
            if (j == toFind) {
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.size; i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
    //顺序插入元素
    public void seqAdd(int value) {
        if (this.elem == null) {
            this.initSeqList();
        }
        if (this.isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }

        this.elem[this.size] = value;
        this.size++;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if (pos < 0 || pos >= this.size) {
            System.out.println("位置非法！");
            return -1;

        }
        return this.elem[pos];
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if (pos < 0 || pos >= this.size) {
            System.out.println("修改位置非法！");
            return;
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        if (isEmpty()) {
            System.out.println("顺序表为空！");
            return;
        }
        for (int i = 0; i < this.size; i++) {
            if (this.elem[i] == toRemove) {
                for (int j = i; j < this.size - 1; j++) {
                    this.elem[j] = this.elem[j+1];
                }
                this.size--;
                return;
            }
        }
        System.out.println("未找到！");
    }
    // 获取顺序表长度
    public int size() {
        return this.size;
    }
    // 清空顺序表
    public void clear() {
        this.size = 0;
    }
}
