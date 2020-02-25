package singleton;

/**
 * 不仅可以解决线程安全还可以防止反序列化
 * java通过class文件进行反射的方式，枚举单例：枚举类没有构造方法；枚举类返回的这个值根据这个去查实例是同一个实例
 */
public  enum  Mar8 {

    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i<100;i++){
            new Thread(()->{
                System.out.println(Mar8.INSTANCE.hashCode());
            }).start();
        }
    }

}
