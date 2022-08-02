package main.wei.jian;

import java.util.*;

class Person {
    public String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equalsIgnoreCase(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person [" +
                "name=" + name +
                ", age=" + age +
                ']';
    }
}
public class Main13 {
    /**
     * 编写Person类 属性：String name, int age;
     * 方法：
     * 构造方法(name, age) 覆盖自Object中继承的**boolean equals(Object o)**方法。比较规则：name相等（忽略大小写）且age相等，则返回true。如果两者姓名均为为null，且age相等，则返回true。
     *
     * main方法：
     * 输入n行字符串（name age），并创建Person对象。如果name位置字符串null，则代表所创建的Person对象name属性为null(注意不是字符串"null")。
     *
     * 创建完对象后，在列表中查询有无与该对象相同的对象（equals为ture即为相同），如果没有则将该对象放入列表。
     * @param args f
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
       Person[] people = new Person[n];
       int nums = 0;
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            int age = sc.nextInt();
            Person person = new Person(str, age);
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (person.equals(people[j])) flag = true;
            }
            if (!flag) {
                people[nums++] = person;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < nums - 1; i++) {
            stringBuilder.append(people[i].toString());
            stringBuilder.append(", ");
        }
        stringBuilder.append(people[nums - 1]);
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }
}
