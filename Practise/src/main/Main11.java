package main;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.lang.reflect.*;

class Person{
    public int id;
    public String name;


    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id=" + id + " name='" + name + '\'';
    }
}

class ObjectGenerator{

    private Random random;



    public ObjectGenerator(int seed) {

        random = new Random(seed);

    }



    public Object getObject(){

        int choice = random.nextInt(3);

        int x = random.nextInt(26);

        switch (choice) {

            case 0:

                char z = (char)(97+x);

                return new String(""+z);

            case 1:

                return Integer.valueOf(x);

            case 2:

                char name = (char)(65+x);

                return new Person(x, name+"");

        }

        return null;

    }

}

public class Main11 {
    /**
     * **编写Person类 **
     * 属性：String name, int id;
     * 方法：必要的构造方法，属性name的getter/setter方法，覆盖Object中继承的toString方法(返回的字符串格式：id=id的值 name='name的值')
     *
     * ObjectGenerator的getObject可以根据给定的种子随机生成String、Integer、Person对象。
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int seed = sc.nextInt();
        int n = sc.nextInt();

        Object[] data = new Object[n];

        ObjectGenerator objectGenerator = new ObjectGenerator(seed);

        for (int i = 0; i < n; i++) {
            data[i] = objectGenerator.getObject();
        }
        System.out.println(Arrays.toString(data));

        for (int i = 0; i < n; i++) {
            String className = data[i].getClass().getName();
            if (className.equals("Person")) {
                Person person = (Person) data[i];
                System.out.println("Name of the person is " + person.name);
            }
        }
    }
}
