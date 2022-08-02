package main.wei.jian.hua.wen;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Person {
    public int id;
    public String name;
    public String phoneNumber;
    public String address;

    public Person(){
        System.out.println("This is a no-argument constructor");
    }
    public Person(int id) {
        this.id = id;
        System.out.println("This is a single parameter constructor");
    }
    public Person(int id, String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.address = address;
        System.out.println("This is a multi-parameter constructor");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person [" +
                "id=" + id +
                ", name=" + name  +
                ", phoneNumber=" + phoneNumber +
                ", address=" + address +
                ']';
    }
}
public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Person person = new Person();
        int id = sc.nextInt();
        String name = sc.next();
        String num = sc.next();
        String address = sc.next();
        person.setId(id);
        person.setName(name);
        person.setPhoneNumber(num);
        person.setAddress(address);

        id = sc.nextInt();
        Person person1 = new Person(id);

        id = sc.nextInt();
        name = sc.next();
        num = sc.next();
        address = sc.next();
        Person person2 = new Person(id, name, num, address);
        Person[] people = {person, person1, person2};

        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.id - o2.id;
            }
        });

        for (Person x: people) {
            System.out.println(x);
        }
    }
}
