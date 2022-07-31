package single;

public class Singleton {
    public static void main(String[] args) {
        EnumSingleton.INSTANCE.doSomething();
    }
}

//单元素的枚举类型已经成为实现Singleton的最佳方法
enum  EnumSingleton {
    INSTANCE;
    public void doSomething() {
        System.out.println("完成一些任务！");
    }
}
//单例模式 - 饿汉模式
class HungrySingleton {
    //1.使用一个变量来保存该类唯一的实例，因为单例模式在一个程序中只能拥有一个实例，由于static成员只有一份，我们可以使用static变量来保存
    private static final HungrySingleton instance = new HungrySingleton();

    //2.封装构造方法，防止该类被实例出新的对象
    private HungrySingleton() {}

    //3.获取该类的唯一实例对象
    public HungrySingleton getInstance() {
        return instance;
    }
}

//单例模式 - 懒汉模式
class SlackerSingleton {
    //1.使用一个变量来保存该类唯一的实例，因为单例模式在一个程序中只能拥有一个实例，由于static成员只有一份，我们可以使用static变量来保存
    //懒汉单例模式是在使用的时候创建对象，因此初始时对象不应该被创建
    private static SlackerSingleton instance;

    //2.封装构造方法，防止该类被实例出新的对象
    private SlackerSingleton() {}

    //3.获取该类的唯一对象，如果没有就创建
    public SlackerSingleton getInstance() {
        if (instance == null) {
            instance = new SlackerSingleton();
        }
        return instance;
    }
}

//多线程情况下饿汉模式获取对象时只读不修改，所以是线程安全的
//多线程情况下懒汉模式获取对象时存在两次读操作，分别为判断instance是否为null和返回instance，除了读操作还存在修改操作，即新建对象并使instance指向该对象
//懒汉模式对象还未初始化的时候，可能会存在多个线程进入判断语句，会导致实例出多个对象，因此懒汉单例模式是线程不安全的。

//线程安全单例模式 - 懒汉模式
class SafeSlackerSingleton {
    //1.使用一个变量来保存该类唯一的实例，因为单例模式在一个程序中只能拥有一个实例，由于static成员只有一份，我们可以使用static变量来保存
    //懒汉单例模式是在使用的时候创建对象，因此初始时对象不应该被创建
    private static SafeSlackerSingleton instance;

    //2.封装构造方法，防止该类被实例出新的对象
    private SafeSlackerSingleton() {}

    //3.获取该类的唯一对象，如果没有就创建
    public SafeSlackerSingleton getInstance() {
        synchronized (SafeSlackerSingleton.class) {
            if (instance == null) {
                instance = new SafeSlackerSingleton();
            }
        }
        return instance;
    }
}

//线程安全优化单例模式 - 懒汉模式
class SafeSlackerSingletonPlus {
    //1.使用一个变量来保存该类唯一的实例，因为单例模式在一个程序中只能拥有一个实例，由于static成员只有一份，我们可以使用static变量来保存
    //懒汉单例模式是在使用的时候创建对象，因此初始时对象不应该被创建
    private static volatile SafeSlackerSingletonPlus instance;

    //2.封装构造方法，防止该类被实例出新的对象
    private SafeSlackerSingletonPlus() {}

    //3.获取该类的唯一对象，如果没有就创建
    public SafeSlackerSingletonPlus getInstance() {
        //判断instance是否初始化，如果已经初始化了，那么该方法只有两个读操作，本身就是线程安全的，不需要加锁了，这样能减少锁竞争，提高效率
        //如果线程很多，频繁进行外层或内层if判断，可能会引发内层可见性问题，因此要给instan变量加上volatile
        if (instance == null) {
            synchronized (SafeSlackerSingletonPlus.class) {
                if (instance == null) {
                    instance = new SafeSlackerSingletonPlus();
                }
            }
        }
        return instance;
    }
}


