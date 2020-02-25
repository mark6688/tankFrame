package singleton;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，jvm保证线程安全
 * 加载外部类的时候不会加载内部类，这样可以实现懒加载
 */
public class Mar7 {
    private Mar7(){}
    private static class Mar7Holder{
        private static Mar7 INSTANCE = new Mar7();
    }

    public static Mar7 getInstance(){
        return Mar7Holder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i<100;i++){
            new Thread(()->{
                System.out.println(Mar7.getInstance().hashCode());
            }).start();
        }
    }

}
