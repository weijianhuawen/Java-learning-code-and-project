import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    /**
     * 向下调整函数的实现
     * @param parent 每棵树的根节点
     * @param len 每棵树的调整的结束位置  10
     */
    public void shiftDown(int parent,int len) {
        int child = 2*parent+1;
        //1、最起码 是有左孩子的，至少有1个孩子
        while (child < len) {
            if(child+1 < len && elem[child] < elem[child+1]) {
                child++;//保证当前左右孩子最大值的下标
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;
                child = 2 * parent + 1;
            }else {
                break;
            }
        }
    }

    public void createHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
        for (int parent = (usedSize-1-1)/2; parent >= 0 ; parent--) {
            //调整
            shiftDown(parent,usedSize);
        }
    }
    private void shiftUp(int child) {
        int parent = (child-1)/2;
        while (parent >= 0) {
            if (elem[child] > elem[parent]) {
                int tmp = elem[parent];
                elem[parent] = elem[child];
                elem[child] = tmp;
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    public void offer(int val) {
        if(isFull()) {
            //扩容
            elem = Arrays.copyOf(elem,2*elem.length);
        }
        elem[usedSize++] = val;
        //注意这里传入的是usedSize-1
        shiftUp(usedSize-1);
    }
    public void heapSort() {
        //

        int end = usedSize - 1;
        while (end > 0) {
            int tmp = elem[end];
            elem[end] = elem[0];
            elem[0] = tmp;

            end--;
        }


    }
    public static int[] topK(int[] array,int k) {
//1、创建一个大小为K的大根堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
//2、遍历数组当中的元素，前K个元素放到队列当中
        for (int i = 0; i < array.length; i++) {
            if(maxHeap.size() < k) {
                maxHeap.offer(array[i]);
            }else {
//3、从第k+1个元素开始，每个元素和堆顶元素进行比较
                int top = maxHeap.peek();
                if(top > array[i]) {
//3.1 先弹出
                    maxHeap.poll();
//3.2 后存入
                    maxHeap.offer(array[i]);
                }
            }
        }
        int[] tmp = new int[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = maxHeap.poll();
        }
        return tmp;
    }
    public boolean isFull() {
        return usedSize == elem.length;
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o2.get(0)+o2.get(1))-(o1.get(0)+o1.get(1));
            }
        });


    }
}

