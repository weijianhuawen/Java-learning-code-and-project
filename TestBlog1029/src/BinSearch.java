public class BinSearch {
    public static int binSearch(int[] arr, int k) {
        if (arr == null) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = left + (right - left) / 2;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (k > arr[mid]) {
                left = mid + 1;
            }
            else if (k < arr[mid]) {
                right = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int k = 7;
        System.out.println(binSearch(arr, k));
    }
}
