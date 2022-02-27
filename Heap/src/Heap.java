import java.util.Arrays;

public class Heap {
    private int[] elem;
    private int usedSize;
    public Heap() {
        this.elem = new int[10];
    }

    /**
     *
     * @param arr 目标交换数组对象
     * @param index1 下标1
     * @param index2 下标2
     */
    private void swap(int arr[], int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    /**
     * 向下调整
     * @param parent 父节点下标
     * @param len 堆大小
     */
    public void shiftDown(int parent, int len) {
        int child = 2 * parent + 1;
        while (child < len) {
            if (child + 1 < len && this.elem[child] < this.elem[child + 1]) {
                child++;
            }
            if (this.elem[child] > this.elem[parent]) {
                swap(this.elem, child, parent);
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    /**
     * 创建大根堆
     * @param data 堆中的数据
     */
    public void creatCopyBigHeap(int[] data) {
        //拷贝数据
        for (int i = 0; i < data.length; i++) {
            if (isFull()) {
                this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
            }
            this.elem[i] = data[i];
            usedSize++;
        }
        //从最后一棵完全二叉树子树开始调整
        int child = this.usedSize - 1;
        int parent = (child - 1) / 2;

        while (parent >= 0) {
            shiftDown(parent, usedSize);
            parent--;
        }

    }

    public void creatBigHeap(int[] data) {
        //拷贝数据
        this.elem = data;
        usedSize = data.length;
        //从最后一棵完全二叉树子树开始调整
        int child = this.usedSize - 1;
        int parent = (child - 1) / 2;

        while (parent >= 0) {
            shiftDown(parent, usedSize);
            parent--;
        }
    }
    public boolean isFull() {
        return this.elem.length == this.usedSize;
    }
    public boolean idEmpty() {
        return this.usedSize == 0;
    }

    //向上调整
    private void shiftUp(int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (this.elem[parent] < this.elem[child]) {
                swap(this.elem, parent, child);
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    /**
     * 基于大堆的优先队列进队
     */
    public void offer(int val) {
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        //1.将元素插入堆尾
        this.elem[usedSize++] = val;
        //2.重新调整为大堆：向上调整
        shiftUp(usedSize - 1);
    }

    /**
     * 基于大堆的优先队列出队
     * @return 堆顶元素
     */
    public int poll() {
        if (idEmpty()) {
            throw new RuntimeException("优先队列为空!");
        }
        //1.将堆顶元素与堆尾元素交换
        swap(this.elem, 0, usedSize - 1);
        //2.保存原堆顶元素的值，并删除堆中原堆顶元素的值
        int ret = this.elem[--usedSize];
        //3.调整堆顶为根结点的树，使其调整为大堆
        shiftDown(0, usedSize);
        return ret;
    }

    /**
     * 获取优先队列（基于大堆）队头元素
     * @return 堆顶元素
     */
    public int peek() {
        if (idEmpty()) {
            throw new RuntimeException("优先队列为空!");
        }
        return this.elem[0];
    }

    /**
     * 堆排序
     * @param arr 排序对象
     * @return 返回排序好的对象
     */
    public int[] heapSort(int[] arr) {
        creatBigHeap(arr);
        int end = usedSize - 1;
        for (int i = end; i > 0; i--) {
            swap(this.elem, 0, i);
            shiftDown(0,i);
        }
        return this.elem;
    }
}
