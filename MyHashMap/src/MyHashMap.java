public class MyHashMap<K, V> {
    //默认哈希表初始数组大小16
    private final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    //默认负载因子为0.75
    private final double DEFAULT_LOAD_FACTOR = 0.75;
    //元素个数
    private int usedSize;
    //链表+数组实现哈希表
    //定义结点
    static class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    //链表数组
    public Node<K, V>[] array;

    public MyHashMap() {
        array = (Node<K, V>[]) (new Node[DEFAULT_INITIAL_CAPACITY]);
    }

    public void put(K key, V value) {
        //获取下标
        int hash = key.hashCode();
        int index = hash % array.length;
        //查找是否具有重复的元素，使用equals判断是否相等
        Node<K, V> cur = array[index];
        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        //如果没有重复的key则插入
        Node<K, V> node = new Node<>(key, value);
        node.next = array[index];
        array[index] = node;
        usedSize++;

        //检查负载因子是否需要扩容
        if (loadFactory() >= DEFAULT_LOAD_FACTOR) {
            resize();
        }
    }

    /**
     * 获取当前的负载因子
     * @return
     */
    private double loadFactory() {
        return 1.0 * usedSize % array.length;
    }

    private void resize() {
        //扩容需要对全部的元素进行重新哈希
        Node<K, V>[] newArray = (Node<K, V>[]) new Node[2 * usedSize];

        for (int i = 0; i < array.length; i++) {
            Node<K, V> cur = array[i];
            //遍历全部结点元素重新哈希到另外一个数组上面
            while (cur != null) {
                int hash = cur.key.hashCode();
                int index = hash % newArray.length;
                Node<K, V> next = cur.next;
                cur.next = newArray[index];
                newArray[index] = cur;
                cur = next;
            }
        }
        this.array = newArray;
    }

    public V get(K key) {
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K, V> cur = array[index];

        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }
}
