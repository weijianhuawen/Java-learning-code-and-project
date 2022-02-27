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

}

