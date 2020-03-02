package factorymethed;

/**
 * 抽象工厂
 */
public class CarFactory {
    public Car createCar(){
        System.out.println("日志框架");
        return new Car();
    }
}
