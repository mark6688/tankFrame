package absctractfactory;

import factorymethed.CarFactory;
import factorymethed.Moveable;

public class Main {
    public static void main(String[] args) {
       AbstractFactory abstractFactory = new MagicFactory();
       Food f = abstractFactory.createFood();
       f.printName();
       Vehicle v = abstractFactory.createVehicle();
       v.go();
       Weapon w = abstractFactory.createWeapon();
       w.shoot();
    }
}
