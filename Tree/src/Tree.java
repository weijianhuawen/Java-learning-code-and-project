import java.util.*;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Tree {
    public TreeNode root;

    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        //E.right = H;
        return A;
    }
    public int size(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return 0;
        }
        ans += 1;
        ans += size(root.left);
        ans += size(root.right);
        return ans;
    }
    public int size_1(TreeNode root) {
        if (root == null) return 0;
        return 1 + size_1(root.left) + size_1(root.right);
    }
    public int getLeafNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount(root.left) + getLeafNodeCount(root.right);
    }
    public int getKLevelNodeCount(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelNodeCount(root.left, k-1) + getKLevelNodeCount(root.right, k-1);
    }
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    public TreeNode find(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        TreeNode retLeft = find(root.left, val);
        TreeNode retRight = find(root.right, val);

        if (retLeft != null) return retLeft;
        else return retRight;
    }
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = queue.poll();
        while (node != null) {
            queue.offer(node.left);
            queue.offer(node.right);
            node = queue.poll();
        }
        for (TreeNode e : queue) {
            if (e != null) {
                return false;
            }
        }
        return true;
    }
    public void levelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
        }
        System.out.print("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }else if (cur.right != null){
                queue.offer(cur.right);
            }
        }
        System.out.println("]");
    }


    public static void main(String[] args) {
        int[] arr = {7,57,13,31,17,65,32,3,97,22,7,20,69,35,69,75,13,33,50,80,64,71,15,28,2,27,39,48,13,22,84,5,51,46,26,78,56,63};
        ArrayList<Integer> list2 = new ArrayList<>();

    }
}
class BSTIterator {
    private int index;
    List<TreeNode> list;

    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        inorder(root);
        this.index = -1;
    }

    public int next() {
        this.index++;
        return list.get(index).val;
    }

    public boolean hasNext() {
        if (list.get(index+1) != null) {
            return true;
        }
        return false;
    }
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        this.list.add(root);
        inorder(root.right);
    }


}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public int pairSum(ListNode head) {
        ListNode cur = head;
        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        if (n == 2) {
            return head.val + head.next.val;
        }
        cur = head;
        //先让一个指针指向偏后中间结点
        ListNode mid = head;
        for (int i = 0; i < n / 2; i++) {
            mid = mid.next;
        }
        int max = 0;
        //cur指针指向首结点，mid指向偏后中间结点，使用快慢指针思路
        //
        for (int i = 0; i <= n / 2 - 1; i++) {
            ListNode last = mid;//mid无记忆后移
            for (int j = 0; j < n / 2 - 1 - i; j++) {
                last = last.next;
            }
            if (cur.val + last.val > max) {
                max = cur.val + last.val;
            }
            cur = cur.next;
        }
        //最中间两个情况，上面循环考虑不到
        if (cur.val + mid.val > max) {
            max = cur.val + mid.val;
        }
        return max;
    }
}
