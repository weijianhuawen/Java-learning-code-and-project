

public class BinarySearchTree {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node(int val) {
            this.val = val;
        }
    }

    public Node root;


    public Node search(int key) {
        Node cur = this.root;
        while (cur != null) {
            //根与目标元素相等，表示找到了。
            if (cur.val == key) return cur;
            //根比目标元素大，去左子树找。
            else if (cur.val > key) cur = cur.left;
            //根比目标元素小，去右子树找。
            else cur = cur.right;
        }
        //此时cur = null, 左右子树找不到，那就找不到了。
        return cur;
    }
    public void set(int key, int val) {
        remove(key);
        insert(val);
    }

    public boolean insert(int val) {
        //结点为空，直接插
        if(root == null) {
            root = new Node(val);
            return true;
        }
        Node cur = this.root;   //当前查找位置
        Node parent = null;     //查找的上一个位置
        while (cur != null) {
            parent = cur;
            if (val > cur.val) cur = cur.right;
            else if (val < cur.val) cur = cur.left;
            else return false;
        }
        //开始插入，找到空位前一个位置，比插入元素小，空位在右边，插入右边
        if (val > parent.val) {
            parent.right = new Node(val);
        } else {
            //比插入元素大，空位在左边，插入左边
            parent.left = new Node(val);
        }
        return true;
    }

    public void remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if(cur.val == key) {
                //这里开始删除
                removeNode2(cur,parent);
                break;
            }else if(cur.val < key) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
    }

    public void removeNode(Node cur,Node parent) {
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            }else if(cur == parent.left) {
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        }else if(cur.right == null) {
            if(cur == root) {
                root = cur.left;
            }else if(cur == parent.left) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            Node preTarget  = cur ;
            Node target  = cur.right;
            while (target.left != null) {
                preTarget = target;
                target = target.left;
            }
            cur.val = target.val;
            if (target == preTarget.left) {
                preTarget.left = target.right;
            } else {
                preTarget.right = target.right;
            }
        }
    }

    public void removeNode2(Node cur,Node parent) {
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            }else if(cur == parent.left) {
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        }else if(cur.right == null) {
            if(cur == root) {
                root = cur.left;
            }else if(cur == parent.left) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            Node preTarget  = cur ;
            Node target  = cur.left;
            while (target.right != null) {
                preTarget = target;
                target = target.right;
            }
            cur.val = target.val;
            if (target == preTarget.left) {
                preTarget.left = target.left;
            } else {
                preTarget.right = target.left;
            }
        }
    }

    public void inOrder(Node root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int[] arr = {4,2,6,9,1,5,8,3,7};
        BinarySearchTree tree = new BinarySearchTree();

        for (int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }
        tree.remove(7);
        tree.inOrder(tree.root);
    }
}
