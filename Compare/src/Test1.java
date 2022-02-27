import java.util.Arrays;

class Person implements Comparable<Person>{
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

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}
public class Test1 {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person(32, "zhang", 92);
        people[1] = new Person(18, "wang", 78);
        people[2] = new Person(12, "chen", 90);
        Arrays.sort(people);
        System.out.println(Arrays.toString(people));
    }
}
