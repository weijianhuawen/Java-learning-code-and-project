public class Test {
    public static void main(String[] args) {
        DoubleLinkedList dls = new DoubleLinkedList();
        dls.addLast(1);
        dls.addLast(2);
        dls.addFirst(3);
        dls.display();
        System.out.println("============");
        dls.addIndex(0, 4);
        dls.addIndex(4, 5);
        dls.addIndex(2,6);
        dls.display();
        System.out.println(dls.contains(4));
        System.out.println(dls.contains(99));
        System.out.println("=========");
        try{
            dls.addIndex(20, 10);
        }catch (IndexExcept e) {
            e.printStackTrace();
            dls.display();
        }
        System.out.println("============");
        dls.remove(5);
        dls.remove(6);
        dls.remove(4);
        dls.display();
        System.out.println("===========");
        dls.addIndex(0,7);
        dls.addIndex(3,7);
        dls.addIndex(3,7);
        dls.addIndex(3,7);
        dls.addIndex(7,7);
        dls.display();
        dls.removeAllKey(7);
        dls.display();
        System.out.println("=============");
        dls.clear();
        dls.display();
    }
}
