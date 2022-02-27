package com.csdn.test2;

public class TestDemo {
    public static void running(IRun iRun) {
        iRun.running();
    }
    public static void swimming(ISwim iSwim) {
        iSwim.swimming();
    }
    public static void skipping(ISkip iSkip) {
        iSkip.skipping();
    }
    public static void flying(IFly iFly) {
        iFly.flying();
    }
    public static void main(String[] args) {
        Bird bird = new Bird("小鸟");
        Cat cat = new Cat("小猫咪");
        Frog frog = new Frog("小青蛙");
        Duck duck = new Duck("小鸭子");

        flying(bird);
        running(cat);
        running(duck);
        skipping(frog);
        skipping(cat);
        swimming(frog);
        swimming(duck);
    }
}
