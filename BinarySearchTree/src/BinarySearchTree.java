class Node {
    public int val;
    public Node left;
    public Node right;
    public Node(int val) {
        this.val = val;
    }
}

public class BinarySearchTree {
    public Node root = null;


    public Node search(int key) {
        Node cur = this.root;
        while (cur != null) {
            if (cur.val == key) return cur;
            else if (cur.val > key) cur = cur.left;
            else cur = cur.right;
        }
        return cur;
    }

    public boolean insert(int val) {
        if(root == null) {
            root = new Node(val);
            return true;
        }
        Node cur = this.root;
        Node parent = null;
        while (cur != null) {
            parent = cur;
            if (val > cur.val) cur = cur.right;
            else if (val < cur.val) cur = cur.left;
            else return false;
        }
        if (val > parent.val) {
            parent.right = new Node(val);
        } else {
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
                removeNode(cur,parent);
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
            Node tap  = null ;
            Node ta  = cur.right;
            while (ta.left != null) {
                tap = ta;
                ta = ta.left;
            }
            cur.val = ta.val;
            if (ta == tap.left) {
                tap.left = ta.right;
            } else {
                tap.right = ta.right;
            }

        }
    }
}
