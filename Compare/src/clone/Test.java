package clone;

class Person implements Cloneable {
    int age;
    public Person(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class Test {
    public static void main(String[] args) {
        Person p1 = new Person(18);
        try {
            Person p2 = (Person) p1.clone();
            System.out.println(p1);
            System.out.println(p2);
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.out.println("克隆异常！");
        }
    }
}
