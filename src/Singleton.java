
// 单例模式
// 单例对象的类必须保证只有一个实例存在

// 简单版本，不具有线程安全
class Singleton1 {
    // 单例对象
    // 这里设定初始值为null，是懒汉模式
    // 若这里主动new一个对象，后面不需要判空操作，为饿汉模式
    private static Singleton1 instance = null;
    // 私有构造函数
    private Singleton1() {}
    // 静态工厂方法
    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}

// 双层检测机制
// 由于JVM编译器的指令重排可能会出现问题：返回一个没有初始化完全的instance对象
// 1 分配对象的内存空间
// 2 初始化对象
// 3 设置instance指向刚分配的内存地址
// 以上指令顺序并非一成不变
class Singleton2 {
    private Singleton2() {}  //私有构造函数
    private static Singleton2 instance = null;  //单例对象
    //静态工厂方法
    public static Singleton2 getInstance() {
        if (instance == null) {      //双重检测机制
            synchronized (Singleton2.class) {  //同步锁，这里不能使用对象锁
                if (instance == null) {     //双重检测机制
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}

// 双重校验锁实现对象单例（线程安全）
public class Singleton {

    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}

// 静态内部类实现单例模式
class Singleton3 {
    // 从外部无法访问静态内部类
    // INSTANCE对象初始化的时机并不是在单例类Singleton被加载的时候
    // 而是在调用getInstance方法，使得静态内部类LazyHolder被加载的时候
    // 利用classloader的加载机制来实现懒加载，并保证构建单例的线程安全
    // 同样存在单例模式共同的问题：无法防止利用反射来重复构建对象
    private static class LazyHolder {
        private static final Singleton3 INSTANCE = new Singleton3();
    }
    private Singleton3() {}
    public static Singleton3 getInstance() {
        return LazyHolder.INSTANCE;
    }
}

// 利用反射打破单例
// 获得单例类的构造器
// 设置构造器为可访问
// 使用newInstance方法构造对象
