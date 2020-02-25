package singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了需要的时候加载，但是带来了线程不安全的问题
 * 可以通过synchronized来解决，但是也带来了效率低下的问题
 */
public class Mar4 {
    private static Mar4 INSTANCE;
    private Mar4(){}

    public static synchronized Mar4 getInstance(){
        if(INSTANCE == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mar4();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i<100;i++){
            new Thread(()->{
                System.out.println(Mar4.getInstance().hashCode());
            }).start();
        }
    }

}
