public class ArraryOrder {
    public static boolean arrOrder(int[] arr) {
        if (arr == null) {
            return false;
        }
        int cnt1 = 1;
        int cnt2 = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i+1]) {
                cnt1++;
            }
            if (arr[i] >= arr[i+1]) {
                cnt2++;
            }
        }
        if (cnt1 == arr.length || cnt2 == arr.length) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8,9};
        int[] arr2 = {9,8,7,6,5,4,3,2,1};
        int[] arr3 = {2,1,4,7,5,9,8,3,6};
        System.out.println(arrOrder(arr1));
        System.out.println(arrOrder(arr2));
        System.out.println(arrOrder(arr3));
    }
}
