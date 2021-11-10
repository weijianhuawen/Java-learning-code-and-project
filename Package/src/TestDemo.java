class Animal {
    public int a;
    public int b;
    public Animal(int i3, int i4) {
        a = i3;
        b = i4;
    }

}
class Bird extends Animal{
    public int c;
    public Bird(int i1, int i2) {
        super(i1, i2);
    }
    public void fly() {
        System.out.println(a);
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Bird bird = new Bird(1,2);
        System.out.println(bird.a);
    }
}
