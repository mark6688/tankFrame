package singleton;

/**
 * 和第一个没区别
 */
public class Mar2 {
    private static Mar2 INSTANCE;
    static {
        INSTANCE = new Mar2();
    }
    private Mar2(){}

    public static Mar2 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        Mar2 mar1 = Mar2.getInstance();
        Mar2 mar11 = Mar2.getInstance();
        System.out.println(mar1 == mar11);
    }

}
