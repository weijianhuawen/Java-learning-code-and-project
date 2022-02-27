import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static int i = 0;
    public static void add() {
        i++;
        i++;
        i++;
    }

    public static boolean isCompeletTree(TreeNode root) {
        if (root == null) {
            return true;//空树也是一颗完全二叉树
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //从root结点开始，将root的左右结点依次入队，然后再出队，将出队结点的左右结点入队
        //如果出队的结点为null，判断队列里面的结点是否均为null，如果是则该树是完全二叉树，否则不是
        TreeNode cur = root;
        while (cur != null) {
            queue.offer(cur.left);
            queue.offer(cur.right);
            cur = queue.poll();
        }
        while (!queue.isEmpty()) {
            if (queue.poll() != null) {
                return false;
            }
        }
        return true;
    }
    /**
     *
     * @param array1 有序的
     * @param array2 有序的
     * @return
     */
    public static int[] mergeArray(int[] array1,int[] array2) {
        if (array1 == null || array2 == null) {
            return array1 != null ? array1 : array2;
        }
        int s1 = 0;
        int s2 = 0;
        int e1 = array1.length - 1;
        int e2 = array2.length - 1;
        int[] ret = new int[e1+e2+2];
        int i = 0;
        while (s1 <= e1 && s2 <= e2) {
            if (array1[s1] <= array2[s2]) {
                ret[i] = array1[s1];
                s1++;
            } else {
                ret[i] = array2[s2];
                s2++;
            }
            i++;
        }
        while (s1 <= e1) {
            ret[i++] = array1[s1++];
        }
        while (s2 <= e2) {
            ret[i++] = array2[s2++];
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {5,6,7,8,9};
        System.out.println(Arrays.toString(mergeArray(arr1, arr2)));
    }

}
