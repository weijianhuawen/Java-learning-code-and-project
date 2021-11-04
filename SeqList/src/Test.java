public class Test {
    public static void main(String[] args) {
        SeqList sl = new SeqList();
        for (int i = 0; i < 12; i++) {
            sl.seqAdd(i+1);
        }
        sl.display();
        System.out.println("------------");
        sl.add(2,99);
        sl.add(13,99);
        sl.add(0,99);
        sl.display();
        System.out.println("------------");
        System.out.println(sl.contains(78));
        System.out.println(sl.contains(2));
        System.out.println("------------");
        System.out.println(sl.search(78));
        System.out.println(sl.search(5));
        System.out.println("------------");
        System.out.println(sl.getPos(98));
        System.out.println(sl.getPos(5));
        System.out.println("------------");
        sl.setPos(45, 88);
        sl.display();
        sl.setPos(1, 88);
        sl.display();
        System.out.println("------------");
        sl.remove(99);
        sl.display();
        sl.remove(99);
        sl.display();
        sl.remove(99);
        sl.display();
        sl.remove(122);
        sl.display();
        System.out.println("------------");
        System.out.println(sl.size);
        System.out.println("------------");
        sl.clear();
        sl.display();
    }
}
