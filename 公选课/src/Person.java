public class Person {
    public String name;
    public String sex;
    private int age;
    private String address;
    private String ID;

    public Person(String name, String sex, int age, String address, String ID) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    //身份证是不能修改的
    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

