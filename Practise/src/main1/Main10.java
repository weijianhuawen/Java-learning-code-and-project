package main1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Person {
    private static String hostname;
    private int id;
    private String name;
    private String phoneNumber;
    private Address address;

    public Person(String name, String phoneNumber, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    static {
        hostname = "zhangsan";
        System.out.println("init");
        System.out.println("zhangsan");
    }

    public static String getHostname() {
        return hostname;
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

    public Address getAddress() {
        return address;
    }

    public static void setHostname(String hostname) {
        Person.hostname = hostname;
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

    public void setAddress(Address address) {
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
class Address{
    private String country;
    private String province;
    private String city;
    private String street;
    private String zipcode;

    public Address(String country, String province, String city, String street, String zipcode){
        this.country = country;
        this.province = province;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Address [" +
                "country=" + country +
                ", province=" + province +
                ", city=" + city +
                ", street=" + street +
                ", zipcode=" + zipcode +
                ']';
    }
}
public class Main10 {
    /**
     * 编写代码实现一个简单通讯录
     *
     * Person类：
     *
     * 属性(代码中属性请按照如下顺序编写，且均为private)：
     *
     * static String hostname;
     * int id;
     * String name;
     * String phoneNumber;
     * Address address;
     *
     * 构造方法：
     *
     * Person(String name, String phoneNumber, Address address)
     *
     * 方法：
     *
     * getter/setter方法、toString方法（建议使用Eclipse进行自动生成）
     *
     * 初始化块:
     *
     * 对id进行赋值。每个对象的id不一样。第一个新建的Person对象id为1，第二个为2，依次类推。
     * 建议:添加一个static int count属性记录最新的id值。
     *
     * 静态初始化块：
     *
     * 为hostname赋值"zhangsan"，并输出"init"
     *
     * Address类：
     *
     * 属性(代码中属性请按照如下顺序编写，且均为private)：
     * String country;
     * String province;
     * String city;
     * String street;
     * String zipcode;
     *
     * 构造方法：
     * Address(String country, String province, String city, String street, String zipcode)
     *
     * 方法：
     * getter/setter方法、toString方法（建议使用自动生成）
     *
     * 一．编写Person类
     * 二．编写Address类
     * 三．Main类中的main方法
     * 详见如下输入格式中的描述。
     * @param args ff
     */
    private static int cnt;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        String str3 = scanner.nextLine();

        ArrayList<Person> list = new ArrayList<>();

        String[] s = str1.split(" ");
        Address address = new Address(s[2],s[3],s[4], s[5], s[6]);
        Person person1 = new Person(s[0], s[1], address);
        cnt++;
        person1.setId(cnt);

        s = str2.split(" ");
        address = new Address(s[2],s[3],s[4], s[5], s[6]);
        Person person2 = new Person(s[0], s[1], address);
        cnt++;
        person2.setId(cnt);

        s = str3.split(" ");
        address = new Address(s[2],s[3],s[4], s[5], s[6]);
        Person person3 = new Person(s[0], s[1], address);
        cnt++;
        person3.setId(cnt);

        list.add(person1);
        list.add(person2);
        list.add(person3);

        System.out.println("add success!");

        int id = scanner.nextInt();
        Person find = null;
        for (Person x: list) {
            if (x.getId() == id) find = x;
        }

        list.remove(find);

        System.out.println("delete success!");

        id = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        s = str.split(" ");
        address = new Address(s[2],s[3],s[4], s[5], s[6]);
        Person person = new Person(s[0], s[1], address);
        for (Person x: list) {
            if (x.getId() == id) find = x;
        }
        int index = list.indexOf(find);
        person.setId(id);
        list.set(index, person);

        System.out.println("change success!");

        id = scanner.nextInt();
        boolean flag = false;
        for (Person x: list) {
            if (x.getId() == id) {
                flag = true;
                find = x;
                break;
            }
        }
        if (!flag) System.out.println("Not found!");
        else {
            System.out.println(find);
            System.out.println("find success!");
        }

        for (Person x: list) {
            System.out.println(x);
        }
    }
}
