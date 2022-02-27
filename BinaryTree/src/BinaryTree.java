import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode<E> {
    public E val;
    public TreeNode<E> left;
    public TreeNode<E> right;
    public TreeNode() {}
    public TreeNode(E val) {
        this.val = val;
    }
    public TreeNode(E val, TreeNode<E> left, TreeNode<E> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class BinaryTree<E> {
    private TreeNode<E> root;

    public BinaryTree() {
        this.root = new TreeNode<E>();
    }

    // 内部前序遍历
    List<E> preOrder() {
        if (this.root == null) return new ArrayList<E>();
        List<E> ret = new ArrayList<>();
        ret.add(this.root.val);
        ret.addAll(preOrder(this.root.left));
        ret.addAll(preOrder(this.root.right));
        return ret;
    }
    // 内部中序遍历
    List<E> inOrder() {
        if (this.root == null) return new ArrayList<E>();
        List<E> ret = new ArrayList<>(inOrder(this.root.left));
        ret.add(this.root.val);
        ret.addAll(inOrder(this.root.right));
        return ret;
    }
    // 内部后序遍历
    List<E> postOrde() {
        if (this.root == null) return new ArrayList<E>();
        List<E> ret = new ArrayList<>(postOrde(this.root.left));
        ret.addAll(postOrde(this.root.right));
        ret.add(this.root.val);
        return ret;
    }
    // 前序遍历
    List<E> preOrder(TreeNode<E> root) {
        if (root == null) return new ArrayList<E>();
        List<E> ret = new ArrayList<>();
        ret.add(root.val);
        ret.addAll(preOrder(root.left));
        ret.addAll(preOrder(root.right));
        return ret;
    }
    // 中序遍历
    List<E> inOrder(TreeNode<E> root) {
        if (root == null) return new ArrayList<E>();
        List<E> ret = new ArrayList<>(inOrder(root.left));
        ret.add(root.val);
        ret.addAll(inOrder(root.right));
        return ret;
    }
    // 后序遍历
    List<E> postOrde(TreeNode<E> root) {
        if (root == null) return new ArrayList<E>();
        List<E> ret = new ArrayList<>(postOrde(root.left));
        ret.addAll(postOrde(root.right));
        ret.add(root.val);
        return ret;
    }
    // 获取树中节点的个数
    int size(TreeNode<E> root) {
        if (root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    // 获取叶子节点的个数
    int getLeafNodeCount(TreeNode<E> root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return getLeafNodeCount(root.left) + getLeafNodeCount(root.left);
    }
    // 获取第K层节点的个数
    int getKLevelNodeCount(TreeNode<E> root, int k) {
        if (root == null || k <= 0) return 0;
        if (k == 1) return 1;//根的结点为1，每递归一层·k--
        return getKLevelNodeCount(root.left, k-1) + getKLevelNodeCount(root.right, k-1);
    }
    // 获取二叉树的高度
    int getHeight(TreeNode<E> root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    // 检测值为value的元素是否存在
    TreeNode<E> find(TreeNode<E> root, E val) {
        if (root == null) return null;
        if (root.val.equals(val)) return root;
        TreeNode<E> leftRet = find(root.left, val);
        TreeNode<E> rightRet = find(root.right, val);
        return leftRet != null ?  leftRet : rightRet;
    }
    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(TreeNode<E> root) {
        if (root == null) return true;
        Queue<TreeNode<E>> queue = new LinkedList<>();
        TreeNode<E> cur = root;
        while (cur != null) {
            queue.offer(cur.left);
            queue.offer(cur.right);
            cur = queue.poll();
        }
        while (!queue.isEmpty()) {
            if (queue.poll() != null) return false;
        }
        return true;
    }
}
