public class Test16 {
    public static void main(String[] args) {
        StringBuilder stringBuilder1 = new StringBuilder("weijianhuawen");
        System.out.println(stringBuilder1.toString());
        stringBuilder1.delete(7,10);//删除hua ，区间是左闭右开
        System.out.println(stringBuilder1.toString());
        System.out.println("============");
        StringBuilder stringBuilder2 = new StringBuilder("nature");
        System.out.println(stringBuilder2.toString());
        stringBuilder2.insert(6,2021);//在最后插入2021
        System.out.println(stringBuilder2.toString());
        System.out.println("============");
        StringBuilder stringBuilder3 = new StringBuilder("csdn");
        System.out.println(stringBuilder3.toString());//逆序字符串
        System.out.println(stringBuilder3.reverse().toString());
    }
}
