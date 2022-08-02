import java.util.BitSet;

class SimpleHash {

    public int cap;//当前容量
    public int seed;//随机

    public SimpleHash(int cap,int seed) {
        this.cap = cap;
        this.seed = seed;
    }

    //根据seed不同 创建不能的哈希函数
    int hash(String key) {
        int h;
//(n - 1) & hash
        return (key == null) ? 0 : (seed * (cap-1)) & ((h = key.hashCode()) ^ (h >>> 16));
    }

}


public class MyBloomFilter {

    public static final int DEFAULT_SIZE = 1 << 20;
    //位图
    public BitSet bitSet;
    //记录存了多少个数据
    public int usedSize;

    public static final int[] seeds = {5,7,11,13,27,33};

    public SimpleHash[] simpleHashes;

    public MyBloomFilter() {
        bitSet = new BitSet(DEFAULT_SIZE);
        simpleHashes = new SimpleHash[seeds.length];
        for (int i = 0; i < simpleHashes.length; i++) {
            simpleHashes[i] = new SimpleHash(DEFAULT_SIZE,seeds[i]);
        }
    }

    /**
     * 添加元素 到布隆过滤器
     * @param val
     */
    public void add(String val) {
//让3个哈希函数  分别处理当前的数据
        for (int i = 0; i < simpleHashes.length; i++) {
            int index = simpleHashes[i].hash(val);
            bitSet.set(index);
        }
        usedSize++;
//把他们 都存储在位图当中即可
    }
    /**
     * 是否包含val ，这里会存在一定的误判的
     * @param val
     * @return
     */
    public boolean contains(String val) {
        for (SimpleHash s : simpleHashes) {
            int index = s.hash(val);

            if (!bitSet.get(index)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MyBloomFilter myBloomFilter = new MyBloomFilter();

    }
}