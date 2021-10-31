public class testDemo {
    public static String myToString(int[] array) {
        if (array == null) {
            return "[]";
        }
        String str = "[";
        //System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            //System.out.print(array[i] + ",");
            str = str + array[i] + ",";
        }
        str = str + array[array.length - 1] + "]";
        //System.out.print(array[array.length - 1] + "]");
        return str;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        System.out.println(myToString(array));
    }
}
