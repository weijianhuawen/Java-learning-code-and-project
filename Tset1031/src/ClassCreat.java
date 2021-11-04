/*public class ClassCreat {
    public static void main(String[] args) {
        Student stu = new Student();//实例化对象
        stu.name = "weijianhuawen";//使用.对这个实例化的对象stu进行访问
        stu.sex = "man";
        stu.major = "computer";
        stu.getMajor();//同理该对象的方法进行访问
        stu.getName();
    }
}*/
/*public class ClassCreat {
    public static void main(String[] args) {
        Variable var = new Variable();
        System.out.println(var.a);
        System.out.println(var.pi);
        System.out.println(var.str);
        var.pi = 3.14;
        var.a = 12;
        System.out.println(var.a);
        System.out.println(var.pi);
        System.out.println("---------------------");
        Variable var2 = new Variable();
        System.out.println(var2.a);
        System.out.println(var2.pi);
        System.out.println(var2.c);
    }
}*/

/*public class ClassCreat {
    public static void main(String[] args) {
        Menthod men = new Menthod();
        men.a = 3.14;
        men.b = 2.88;

        double sum = men.add(men.a, men.b);
        double sub = men.sub(men.a, men.b);

        System.out.printf("和为%.2f\n差为%.2f\n", sum, sub);
    }
}*/

/*public class ClassCreat {
    public static void main(String[] args) {
        int a = 12;
        int sum = StaticMember.add(a, StaticMember.x);
        System.out.println(sum);
        System.out.println("------------");
        StaticMember sm1 = new StaticMember();
        sm1.x = 14;
        sum = sm1.add(a, sm1.x);
        System.out.println(sum);
        System.out.println("------------");
        StaticMember sm2 = new StaticMember();
        sum = sm2.add(a, sm2.x);
        System.out.println(sum);
    }
}*/




class Variable {
    public char c;
    public int a;
    public double pi;
    public String str;
}

class Menthod {
    public double a;
    public double b;

    public double add(double x, double y) {
        return x + y;
    }
    public double sub(double x, double y) {
        return x - y;
    }
}
class StaticMember {
    public static int x;

    public static int add(int a, int b) {
        return a + b;
    }
}

class PriviteMember {
    private int m;
    private double n;
    private int add(int a, int b) {
        return  a + b;
    }

    public int getM() {
        return m;
    }

    public double getN() {
        return n;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setN(double n) {
        this.n = n;
    }

    public int getterInt() {
        return m;   //获取m
    }
    public double getterDouble() {
        return  n;//获取n
    }
    public void setterInt(int x) {
        m = x;//设置m
    }
    public void setterDouble(double y) {
        n = y;//设置n
    }
    public int getAdd(int x, int y) {
        return add(x, y);//调用私有方法add
    }
}

/*public class ClassCreat {
    private int add(int a, int b) {
        return  a + b;
    }
    public static void main(String[] args) {
        ClassCreat pm = new ClassCreat();
        int x = 10;
        int y = 12;
        System.out.println(pm.add(x, y));
    }
}*/

/*public class ClassCreat {
    public static void main(String[] args) {
        PriviteMember pm = new PriviteMember();
        pm.setterInt(12);//对m赋值
        System.out.println(pm.getterInt());//获取m的值

        pm.setterDouble(3.14);//对n赋值
        System.out.println(pm.getterDouble());//获取n的值

        int a = 14;
        int b = 12;
        System.out.println(pm.getAdd(a, b));//间接调用私有方法add
    }
}*/

class ConstructionMethod {
    public int a;
    private int b;

    public ConstructionMethod() {
        System.out.println("这是一个不带参数的构造方法！");
    }
    public ConstructionMethod(int x) {
        this.b = x;
        System.out.println("这是一个带有参数的构造方法！可以给成员变量b赋值！赋值后b = " + this.b);
    }
    public ConstructionMethod(int x, int y) {
        this.a = this.add(x, y);
        System.out.println("这是一个带有两个参数的构造方法！可以计算两个整数的和！这两个数的和为：" + a);
    }
    private int add(int m, int n) {
        return m + n;
    }
}

/*public class ClassCreat {
    public static void main(String[] args) {
        ConstructionMethod cm1 = new ConstructionMethod();
        System.out.println("------------");
        ConstructionMethod cm2 = new ConstructionMethod(12);
        System.out.println("------------");
        ConstructionMethod cm3 = new ConstructionMethod(18, 2);
    }
}*/

/*public class ClassCreat {
    public static void main(String[] args) {

        {
            int a = 12;
            int b = 48;
            String name = "weijianhuawen";
        }
    }
}*/
/*class CodeBlock {
    private int c;
    private int d;
    public int sum;

    //构造代码块 or 实例代码块
    {
        this.c = 10;
        this.d = 12;
        sum = this.add(c, d);
    }

    public int add(int x, int y) {
        return x + y;
    }
}*/

class CodeBlock {
    public static int a;
    public static String name;

    //静态代码块
    static {
        a = 18;
        name = "未见花闻";
    }
}

class Student {
    public String name;
    public String sex;
    public int age;
    public String id;
    public String major;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                ", major='" + major + '\'' +
                '}';
    }

    public void getName() {
        System.out.println(name);
    }
    public void getMajor() {
        System.out.println(major);
    }
}
/*public class ClassCreat {

    public static void main(String[] args) {
        Student sc = new Student();
        sc.name = "weijianhuawen";
        sc.sex = "man";
        sc.age = 1;
        sc.id = "5201314";
        sc.major = "computer";

        System.out.println(sc);
    }
}*/
class AnonymousObject {
    public int a;
    int b;
    public AnonymousObject() {
        this.a = 188;
    }
}

public class ClassCreat {


    public static void main(String[] args) {
        System.out.println(new AnonymousObject().a);
        AnonymousObject anob = new AnonymousObject();
        anob.b = 12;
        System.out.println(anob.b);
    }
}