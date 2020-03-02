package factorymethed;

public class Main {
    public static void main(String[] args) {
        Moveable moveable = new CarFactory().createCar();
        moveable.go();

    }
}
