import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;

class Animal{}
class Cat extends Animal{}
class Dog extends Animal{}
class Bird extends Animal{}

public class WildCard {
    //使用泛型打印顺序表
    public static<T> void printList1(ArrayList<T> list) {
        for (T x:list) {
            System.out.println(x);
        }
    }
    public static <T extends Animal> void printAnimal1(ArrayList<T> list) {
        for (T animal: list) {
            System.out.println(animal);
        }
    }
    //使用通配符打印顺序表
    public static void printList2(ArrayList<?> list) {
        for (Object x:list) {
            System.out.println(x);
        }
    }
    public static void printAnimal2(ArrayList<? extends Animal> list) {
        for (Animal animal: list) {
            System.out.println(animal);
        }
    }
    public static void printAll(ArrayList<? super Number> list) {
        for (Object n: list) {
            System.out.println(n);
        }
    }

    public static void main6(String[] args) {
        printAll(new ArrayList<Number>());//ok
        printAll(new ArrayList<Object>());//ok

        //printAll(new ArrayList<Double>());//error
        //printAll(new ArrayList<String>());//error
        //printAll(new ArrayList<Integer>());//error
    }
    public static void main(String[] args) {
        ArrayList<? super Animal> list = new ArrayList<Animal>();
        ArrayList<? super Animal> list2 = new ArrayList<Cat>();//编译报错，list2只能引用Animal或者Animal父类类型的list
        list.add(new Animal());//添加元素时，只要添加的元素的类型是Animal或者Animal的子类就可以
        list.add(new Cat());
        Object s2 = list.get(0);//可以

        ArrayList<? super Animal> list3 = new ArrayList<Object>();
        Cat s1 = list3.get(0);//error因为构造对象时可以构造Animal父类类型的ArrayList，取出的对象不一定是Animal或者Animal的子类
    }
    public static void main4(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Double> arrayList2 = new ArrayList<>();
        arrayList1.add(10);
        List<? extends Number> list = arrayList1;
        System.out.println(list.get(0));//ok
        //Integer = list.get(0);//error因为不能确定list所持有的对象具体是什么
        //list.add(2);//error因为不能确定list所持有的对象具体是什么，为了安全，这种情况Java不允许插入元素
    }
    public static void main3(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Bird bird = new Bird();

        //通配符
        ArrayList<Cat> list1 = new ArrayList<>();
        ArrayList<Dog> list2 = new ArrayList<>();
        ArrayList<Bird> list3 = new ArrayList<>();
        list1.add(cat);
        list2.add(dog);
        list3.add(bird);
        printAnimal2(list1);//Cat
        printAnimal2(list2);//Dog
        printAnimal2(list3);//Bird
    }
    public static void main2(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Bird bird = new Bird();

        //泛型
        ArrayList<Cat> list1 = new ArrayList<>();
        ArrayList<Dog> list2 = new ArrayList<>();
        ArrayList<Bird> list3 = new ArrayList<>();
        list1.add(cat);
        list2.add(dog);
        list3.add(bird);
        printAnimal1(list1);//Cat
        printAnimal1(list2);//Dog
        printAnimal1(list3);//Bird

    }
    public static void main1(String[] args) {
        printAll(new ArrayList<Integer>());//ok
        printAll(new ArrayList<Double>());//ok
        printAll(new ArrayList<Float>());//ok

        //printAll(new ArrayList<String>());//error
    }
}
