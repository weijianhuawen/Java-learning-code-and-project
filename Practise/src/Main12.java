import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

class Person{
    public int id;
    public String name;
    public LocalDate birthDate;

    public Person(int id, String name, String year, String month, String dayOfMonth) {
        this.id = id;
        this.name = name;
        int m = Integer.valueOf(month);
        int d = Integer.valueOf(dayOfMonth);
        if (m >= 10 &&  d >= 10) this.birthDate = LocalDate.parse(year + "-" + month + "-" + dayOfMonth);
        else if (m < 10 && d >= 10) this.birthDate = LocalDate.parse(year + "-0" + month + "-" + dayOfMonth);
        else if (m >= 10) this.birthDate = LocalDate.parse(year + "-" + month + "-0" + dayOfMonth);
        else this.birthDate = LocalDate.parse(year + "-0" + month + "-0" + dayOfMonth);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person [" +
                "id=" + id +
                ", name=" + name +
                ", birthDate=" + birthDate +
                ']';
    }
}
class Student extends Person{
    public int enrollmentYear;
    public String clazzName;


    public Student(int id, String name, String year, String month, String dayOfMonth, String enrollmentYear, String clazzName) {
        super(id, name, year, month, dayOfMonth);
        this.enrollmentYear = Integer.valueOf(enrollmentYear);
        this.clazzName = clazzName;
    }



    @Override
    public String toString() {
        return "Person [" +
                "id=" + id +
                ", name=" + name +
                ", birthDate=" + birthDate +
                ']' + "\n"+
                "Student [" +
                "enrollmentYear=" + enrollmentYear +
                ", clazzName=" + clazzName +
                ']';
    }
}
class Teacher extends Person{
    public String department;
    public double salary;


    public Teacher(int id, String name, String year, String month, String dayOfMonth, String department, String salary) {
        super(id, name, year, month, dayOfMonth);
        this.department = department;
        this.salary = Double.valueOf(salary);
    }

    @Override
    public String toString() {
        return "Person [" +
                "id=" + id +
                ", name=" + name +
                ", birthDate=" + birthDate +
                ']' + "\n" + "Teacher [" +
                "department=" + department +
                ", salary=" + salary +
                ']';
    }
}
/**
 * Person类：
 * 属性：int id, String name, LocalDate birthDate。注意：定义时需按照顺序从上到下定义。
 * 方法：构造方法（id, name, year, month, dayOfMonth）, id与birthDate的getter方法， name的getter/setter方法，Eclipse自动生成的tostring。
 *
 * **Student类继承自Person: **
 * 属性：int enrollmentYear， String clazzName。
 * 方法：构造方法（id, name, year, month, dayOfMonth, enrollmentYear, clazzName)，建议使用super复用Person的构造函数。toString方法（包含两行，第一行为父类的toString方法，第二行为Student类自身属性的toString方法，具体格式见输出样例）
 *
 * Teacher类继承自Person：
 * 属性：String department， double salary。
 * 方法：构造方法（id, name, year, month, dayOfMonth, department, salary)，建议使用super复用Person的构造函数。toString方法（包含两行，第一行为父类的toString方法，第二行为Teacher类自身属性的toString方法，具体格式见输出样例）
 */
public class Main12 {
    public static void main(String[] args) {
        String[] types = {"Student","Teacher"};
        Scanner sc = new Scanner(System.in);
        //输入种子seed，并用其初始化Random对象
        int seed = sc.nextInt();
        Random random = new Random(seed);

        //输入对象生成数量n
        int n = sc.nextInt();
        sc.nextLine();
        //以下是生成n个对象的循环
        Person[] people = new Person[n];

        for (int i = 0; i < n; i++) {
            //使用random.nextInt(2)从types数组中随机选取元素x并输出
            //根据x选择输入相应的参数
            //n个对象的"id,name,birthdate"
            //输出数组中的每个对象的toString
            String str = sc.nextLine();
            String[] s = str.split(" ");
            int ran = random.nextInt(2);
            if (types[ran].equals("Student")) {
                people[i] = new Student(i, s[0], s[1], s[2], s[3], s[4], s[5]);
            } else {
                people[i] = new Teacher(i, s[0], s[1], s[2], s[3], s[4], s[5]);
            }
            System.out.println(types[ran]);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(people[i].getId() + "," + people[i].getName() + "," + people[i].getBirthDate());
        }
        for (int i = 0; i < n; i++) {
            System.out.println(people[i]);
        }
    }
}
