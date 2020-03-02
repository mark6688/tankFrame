package factorymethed;

/**
 * 简单工厂，可扩展性不好（任意定制交通工具）
 */
public class SimpleVehicleFactory {
    public Car createCar(){
        //before processing
        return new Car();
    }
    public Broom createBroom(){
        return new Broom();
    }
}
