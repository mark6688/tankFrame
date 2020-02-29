package singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了需要的时候加载，但是带来了线程不安全的问题
 * 可以通过synchronized来解决，但是也带来了效率低下的问题
 * 没有解决线程问题
 * */
public class Mar5 {
    private static Mar5 INSTANCE;
    private Mar5(){}

    public static  Mar5 getInstance(){
        if(INSTANCE == null){
            synchronized(Mar5.class){
                //测试并发加入的睡眠
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Mar5();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i<100;i++){
            new Thread(()->{
                System.out.println(Mar5.getInstance().hashCode());
            }).start();
        }
    }

}
