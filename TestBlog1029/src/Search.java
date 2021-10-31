public class Search {
    public static void main(String[] args) {
        //顺序查找元素，找到其下标，未找到则输出未找到
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int k = 7;
        int flag = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                System.out.println("找到了！下标为：" + i);
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("未找到！");
        }
    }
}
