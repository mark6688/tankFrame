package singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了需要的时候加载，但是带来了线程不安全的问题
 */
public class Mar3 {
    private static Mar3 INSTANCE;
    private Mar3(){}

    public static Mar3 getInstance(){
        if(INSTANCE == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mar3();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i<100;i++){
            new Thread(()->{
                System.out.println(Mar3.getInstance().hashCode());
            }).start();
        }
    }

}
