package singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了需要的时候加载，但是带来了线程不安全的问题
 * 可以通过synchronized来解决，但是也带来了效率低下的问题
 * 不加volatile会有指令重排造成问题
 */
public class Mar6 {
    private static volatile Mar6 INSTANCE;
    private Mar6(){}

    public static Mar6 getInstance(){
        if(INSTANCE == null){
            synchronized(Mar6.class){
                if(INSTANCE == null) {
                    //测试并发加入的睡眠
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mar6();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i<100;i++){
            new Thread(()->{
                System.out.println(Mar6.getInstance().hashCode());
            }).start();
        }
    }

}
