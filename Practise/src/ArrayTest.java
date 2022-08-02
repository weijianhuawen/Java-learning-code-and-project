import java.util.Arrays;
import java.util.Random;

public class ArrayTest {
    /**
     * 归并排序
     * @param array 待排序数组对象
     */
    public static void mergeSort(int[] array) {
        mergeSortFunc(array, 0, array.length-1);
    }
    private static void mergeSortFunc(int[] array, int start, int end) {
        if (start >= end) return;
        int mid = start +((end - start) >>> 1);
        //对数组进行分解
        mergeSortFunc(array, start, mid);
        mergeSortFunc(array, mid + 1, end);
        //对数组进行有序合并
        merge(array, start, mid, end);
    }

    /**
     * 合并有序序列 降序
     * @param arrray 目标序列
     * @param left 第一组序列左边界
     * @param mid   第一组序列右边界（记为中点）
     * @param right 第二组序列右边界
     */
    private static void merge(int[] arrray, int left, int mid, int right){
        int[] tmp = new int[right - left + 1];//临时数组，用来存放合并后的数组
        int start1 = left;
        int start2 = mid + 1;
        int index = 0;
        while (start1 <= mid && start2 <= right) {
            //有序向临时数组中传入数据
            if (arrray[start1] <= arrray[start2]) {
                tmp[index++] = arrray[start2++];
            } else {
                tmp[index++] = arrray[start1++];
            }
        }
        //将剩下的元素放入临时数组中
        while (start1 <= mid) tmp[index++] = arrray[start1++];
        while (start2 <= right) tmp[index++] = arrray[start2++];

        //将临时数组中的元素对应拷贝到array中
        for (int i = 0; i < index; i++) {
            arrray[i + left] = tmp[i];
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();
        double sum = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(81) + 20;
            sum += arr[i];
            if (arr[i] > max) max = arr[i];
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println(arr[arr.length - 1]);
        double avg = sum / arr.length;
        System.out.println(avg);
        System.out.println(max);

        //升序排列
        Arrays.sort(arr);
        for (int i = 0; i < 3; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
        //归并排序降序
        mergeSort(arr);
        for (int i = 0; i < 3; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}
