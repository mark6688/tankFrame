package singleton;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，jvm保证线程安全
 * 唯一缺点，不管用到与否，类装载时就会完成实例化
 */
public class Mar1 {
    private static Mar1 INSTANCE = new Mar1();
    private Mar1(){}

    public static Mar1 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        Mar1 mar1 = Mar1.getInstance();
        Mar1 mar11 = Mar1.getInstance();
        System.out.println(mar1 == mar11);
    }

}
