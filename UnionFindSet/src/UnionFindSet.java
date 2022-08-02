import java.util.Arrays;

public class UnionFindSet {
    public int[] elem;
    public int usedSize;

    public UnionFindSet(int n) {
        this.elem = new int[n];
        Arrays.fill(elem,-1);
    }

    /**
     * 查找数据x 的根节点
     * @param x
     * @return 下标
     */
    public int findRoot(int x) {
        if(x < 0) {
            throw new IndexOutOfBoundsException("下标不合法，是负数");
        }
        while (elem[x] >= 0 ) {
            x = elem[x];//1  0
        }
        return x;
    }

    /**
     * 查询x1 和 x2 是不是同一个集合
     * @param x1
     * @param x2
     * @return
     */
    public boolean isSameUnionFindSet(int x1,int x2) {
        int index1 = findRoot(x1);
        int index2 = findRoot(x2);
        if(index1 == index2) {
            return true;
        }
        return false;
    }

    /**
     * 这是合并操作
     * @param x1
     * @param x2
     */
    public void union(int x1,int x2) {
        int index1 = findRoot(x1);
        int index2 = findRoot(x2);

        if (index1 == index2) {
            return;
        }
        this.elem[index1] += this.elem[index2];
        this.elem[index2] = index1;
    }
}