package absctractfactory;

public class MagicFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Bream();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
