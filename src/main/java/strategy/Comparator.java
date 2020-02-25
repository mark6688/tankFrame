package strategy;

//如果一个接口中只有一个方法，则称之为函数式方法
//或者也可以加如下注解表示该接口为函数接口
//@FunctionalInterface
public interface Comparator<T> {
    int compareTo(T o1,T o2);

    //jdk1.8之后才支持的接口中写默认方法
    default void m(){
        System.out.println("m");
    }
    default void d(){
        System.out.println("m");
    }
}
