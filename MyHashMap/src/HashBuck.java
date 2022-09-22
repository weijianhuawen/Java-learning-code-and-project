public class HashBuck {
    //默认哈希表初始数组大小16
    private final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    //默认负载因子为0.75
    private final double DEFAULT_LOAD_FACTOR = 0.75;
    //元素个数
    private int usedSize;
    //链表+数组实现哈希表
    //定义结点
    static class Node {
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    //链表数组
    public Node[] array;

    public HashBuck() {
        this.array = new Node[DEFAULT_INITIAL_CAPACITY];
    }

    /**
     * 插入键值对
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        //找到key所在的位置
        int index = key % this.array.length;

        //查找是否存在重复的元素
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        //如果不存在重复的元素，那就插入结点，头插也行尾插也行
        Node node = new Node(key, value);
        node.next = array[index];
        array[index] = node;
        usedSize++;
        //插入完成之后，检查负载因子
        if (loadFactory() >= DEFAULT_LOAD_FACTOR) {
            //扩容
            resize();
        }
    }

    /**
     * 扩容
     */
    private void resize() {
        //扩容需要对全部的元素进行重新哈希
        Node[] newArray = new Node[2 * usedSize];

        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            //遍历全部结点元素重新哈希到另外一个数组上面
            while (cur != null) {
                int index = cur.key % newArray.length;
                Node next = cur.next;
                cur.next = newArray[index];
                newArray[index] = cur;
                cur = next;
            }
        }
        this.array = newArray;
    }


    public int get(int key) {
        int index = key % this.array.length;

        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }

    /**
     * 计算负载因子
     * @return 当前负载因子的大小
     */
    public double loadFactory() {
        return 1.0 * this.usedSize / this.array.length;
    }

    public int size() {
        return this.usedSize;
    }
}
