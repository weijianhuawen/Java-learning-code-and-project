package newSrc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Person{
    public int age;
    public String name;
    public int score;
    public Person(int age, String name, int score) {
        this.age = age;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.age - o2.age;
    }
}
class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.name.compareTo(o2.name);
    }
}
class ScoreComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.score - o2.score;
    }
}
public class Test {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person(32, "wang", 92);
        people[1] = new Person(18, "zhang", 78);
        people[2] = new Person(12, "chen", 90);
        AgeComparator ageCmp = new AgeComparator();
        NameComparator nameCmp = new NameComparator();
        ScoreComparator scoreCmp = new ScoreComparator();
        Arrays.sort(people, ageCmp);
        System.out.println("按年龄排序：");
        System.out.println(Arrays.toString(people));
        Arrays.sort(people, nameCmp);
        System.out.println("按姓名排序：");
        System.out.println(Arrays.toString(people));
        Arrays.sort(people, scoreCmp);
        System.out.println("按分数排序：");
        System.out.println(Arrays.toString(people));
    }
}
