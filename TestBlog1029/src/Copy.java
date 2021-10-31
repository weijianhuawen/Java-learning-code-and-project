import java.util.Arrays;

public class Copy {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8,9};
        System.out.println("arr1:" + Arrays.toString(arr1));
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        System.out.println("arr2:" + Arrays.toString(arr2));
        int[] arr3 = Arrays.copyOf(arr1, arr1.length * 2);
        System.out.println("arr3:" + Arrays.toString(arr3));
        int[] arr4 = Arrays.copyOfRange(arr1, 1, 5);
        System.out.println("arr4:" + Arrays.toString(arr4));
        int[] arr5 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr5, 0, arr1.length);
        System.out.println("arr5:" + Arrays.toString(arr5));
        int[] arr6 = arr1.clone();
        System.out.println("arr6:" + Arrays.toString(arr6));
    }
}

/*import java.util.Arrays;

public class Copy {
    public static int[] copy(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] copy = new int[arr.length];//新建一个数组
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];//遍历拷贝
        }
        return copy;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8,9};
        System.out.println("数组1：");
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = copy(arr1);
        System.out.println("数组2：");
        System.out.println(Arrays.toString(arr2));
    }
}*/

