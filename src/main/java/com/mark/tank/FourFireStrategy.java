package com.mark.tank;

public class FourFireStrategy implements FireComparable<Tank> {
    @Override
    public void fir(Tank tank) {
        int dX = tank.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int dY = tank.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        Dir[] dirs = Dir.values();
        for (Dir dir:dirs) {
            new Bullet(dX,dY,dir,tank.group,tank.tankFrame);
        }
    }
}
